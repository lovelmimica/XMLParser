/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.utils;

import hr.altima.lovelmimica.web.utils.Entry;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author lovelmimica
 */
public class EntryMapper implements RowMapper<Entry>{

    @Override
    public Entry mapRow(ResultSet rs, int i) throws SQLException {
        Entry entry = new Entry();
        entry.setId(rs.getInt("id"));
        entry.setName(rs.getString("name"));
        entry.setParentId(rs.getInt("parent_id"));
        
        return entry;
    }
    
}
