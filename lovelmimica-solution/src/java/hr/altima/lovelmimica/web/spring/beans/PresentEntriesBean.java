/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import hr.altima.lovelmimica.web.utils.Entry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lovelmimica
 */
public class PresentEntriesBean implements Serializable{
    
    //beanovi za spajanje na BP
    @Autowired
    private EntryJdbcTemplateBean entryJdbcTemplate;
    @Autowired
    private IdGeneratorBean idGenerator;
    
    private List<Entry> presentEntriesList;

    public List<Entry> getPresentEntriesList() {
        findAll();
        setParents();
        return presentEntriesList;
    }
    
    
    public PresentEntriesBean() {       
    }
    public void init(){
        findAll();
    }
    
    public void appendEntries(List<Entry> newEntries){
        //filtriraj entriye koji vec postoje (name mora biti unique)
        for(int i = 0; i<newEntries.size(); i++){
            Entry current = newEntries.get(i);
            if(findEntry(current.getName()) == null) {
                current.setId(idGenerator.generateId());
                this.presentEntriesList.add(current);  
                setParents();
                entryJdbcTemplate.insert(current);
            }
        }

    }
    
    private void findAll(){
        //TODO: Implementiraj spajanje na BP i setanje parenta
        this.presentEntriesList =  new ArrayList<Entry>();
        this.presentEntriesList = entryJdbcTemplate.selectAll();
        setParents();
    }
    
    private void setParents(){
        for(int i = 0; i < this.presentEntriesList.size(); i++){
            Entry current = this.presentEntriesList.get(i);
            if(current.hasParent() == false){
                Entry parent = findParent(current);
                current.setParent(parent);
            }
        }
    }
    private Entry findParent(Entry entry){
        if(isRootEntry(entry)) return null;
        if(entry.getParentId() != null && entry.getParentId() > 0) return findEntry(entry.getParentId());
        if(entry.getParentName() != null) return findEntry(entry.getParentName());
        return null;
    }
    private boolean isRootEntry(Entry e){
        if(e.getParentName() == null && e.getParentId() == null) return true;
        return false;
    }
    private Entry findEntry(String name){
        for(Entry e : presentEntriesList){
            if(name.equalsIgnoreCase(e.getName())) return e;
        }
        return null;
    }
    private Entry findEntry(Integer id){
        for(Entry e : presentEntriesList){
            if(id.equals(e.getId())) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
       for(Entry e : this.presentEntriesList){
           sb.append("</br>" + e.toString());
       }
        return new String(sb);
    }
    
}
