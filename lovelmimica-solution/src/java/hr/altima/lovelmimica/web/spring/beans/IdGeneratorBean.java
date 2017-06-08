/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import hr.altima.lovelmimica.web.utils.Entry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lovelmimica
 */
public class IdGeneratorBean {
    @Autowired
    EntryJdbcTemplateBean entryTemplate;
    
    public Integer generateId(){
        List<Entry> entryList = entryTemplate.selectAll();
        
        Integer max = 0;
        for(Entry e : entryList){
            if(e.getId() > max) max = e.getId();
        }
        return max + 1;
    }
}
