/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.utils;

/**
 *
 * @author lovelmimica
 */
public class Entry {
    private Integer id = null; 
    private String name;
    private Entry parent = null;
    private String parentName;
    private Integer parentId = null;

    public Entry() {
    }

    public Entry(String name, String parentName) {
        this.name = name;
        this.parentName = parentName;
    }

    public Entry(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
    public Entry(String name, Integer parentId) {
        this.name = name;
        this.parentId = parentId;
    }
    
    public boolean hasParent(){
        if(parent != null) return true;
        else return false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParentName() {
        if(parent != null){
            parentName = parent.getName();
            return parentName;
        }
        return parentName;
    }

    public Integer getParentId() {
        if(parent != null) {
            parentId = parent.getId();
            return parentId;
        }
        return parentId;
    }

    public void setParent(Entry parent) {
        this.parent = parent;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Entry{ " + "id=" + this.id + ", name=" + this.name);
        if(parent != null) sb.append(", parent_id="+this.parent.getId()+ ", parent_name=" + this.parent.getName());
        else sb.append(", parent=null");
        sb.append("}");
       
        return new String(sb);
    }
    
    
    
    
    
  
}
