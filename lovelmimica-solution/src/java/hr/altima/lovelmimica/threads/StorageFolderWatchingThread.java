/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.threads;

import hr.altima.lovelmimica.web.spring.beans.BeanConfiguration;
import hr.altima.lovelmimica.web.spring.beans.ParsingServiceBean;
import hr.altima.lovelmimica.web.spring.beans.StorageFolderBean;
import hr.altima.lovelmimica.web.spring.beans.AppConfigurationBean;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author lovelmimica
 */
public class StorageFolderWatchingThread extends AbstractThread{
    
    private ApplicationContext ctx;
    private ParsingServiceBean parsingService;
    private StorageFolderBean storageFolder;
    
    public StorageFolderWatchingThread(String realPath) {
        super();
        
        ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        parsingService = (ParsingServiceBean)ctx.getBean(ParsingServiceBean.class);
        storageFolder = (StorageFolderBean)ctx.getBean(StorageFolderBean.class);        
    }
    @Override
    protected void work(){
        try{
            System.out.println(new Date() + " DRETVA: Provjeravam folder: " + configuration.getStorageFolder());
            List<File> newFiles = storageFolder.getFiles();
            parsingService.doService(newFiles);
            
        }catch(Exception e){
            System.out.println(new Date() + " EXCEPTION: " + e.toString() );
        }
    } 
}
