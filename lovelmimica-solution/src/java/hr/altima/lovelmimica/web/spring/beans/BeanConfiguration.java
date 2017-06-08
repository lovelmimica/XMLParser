/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import hr.altima.lovelmimica.web.spring.beans.controllers.IndexController;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author lovelmimica
 */
@Configuration
public class BeanConfiguration {
    @Bean
    @Scope("singleton")
    public ParsingServiceBean parsingService(){
        return new ParsingServiceBean();
    }
    
    @Bean(initMethod = "init")
    @Scope("singleton")
    public StorageFolderBean storageFolder(){
        return new StorageFolderBean();
    }
    
    @Bean
    @Scope("singleton")
    public XmlParserBean xmlParser(){
        return new XmlParserBean();
    }
    
    @Bean(initMethod = "init")
    @Scope("singleton")
    public PresentEntriesBean presentEntries(){
        return new PresentEntriesBean();
    }
    
    @Bean
    @Scope("singleton")
    public DataSource dataSource(){
        DataSource dataSource = new DriverManagerDataSource("jdbc:derby://localhost:1527/altima-test-db", "lovel", "123");
        return dataSource;
    }
    
    @Bean
    @Scope("singleton")
    public EntryJdbcTemplateBean entryJdbcTemplate(){
        EntryJdbcTemplateBean jdbcTemplate = new EntryJdbcTemplateBean();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    
    @Bean
    @Scope("singleton")
    public IdGeneratorBean idGenerator(){
        return new IdGeneratorBean();
    }
    
    @Bean
    @Scope("singleton")
    public AppConfigurationBean appConfiguration(){
        return new AppConfigurationBean();
    }
    
}
