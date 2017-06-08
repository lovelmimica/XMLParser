/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import hr.altima.lovelmimica.web.utils.EntryMapper;
import hr.altima.lovelmimica.web.utils.Entry;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lovelmimica
 */
public class EntryJdbcTemplateBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void insert(Entry e){
        String sql = "insert into entry (id, name, parent_id) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{e.getId(), e.getName(), e.getParentId()});
    }
    public void update(Entry e){
        String sql = "update entry set name = ? , parent_id = ? where id = ?";
        jdbcTemplate.update(sql, new Object[]{e.getName(), e.getParentId(), e.getId()});
    }
    
    public List<Entry> selectAll(){
        String sql = "select * from entry";
        List<Entry> allEntries = jdbcTemplate.query(sql, new EntryMapper());
        return allEntries;
    }
    public void insertList(List<Entry> entryList){
        for(Entry e : entryList){
            insert(e);
        }
    }
    public void updateList(List<Entry> entryList){
        for(Entry e : entryList){
            update(e);
        }
    }
    
    
}
