/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.listeners;

import hr.altima.lovelmimica.threads.AbstractThread;
import hr.altima.lovelmimica.threads.StorageFolderWatchingThread;
import hr.altima.lovelmimica.web.spring.beans.AppConfigurationBean;
import hr.altima.lovelmimica.web.spring.beans.BeanConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Web application lifecycle listener.
 *
 * @author lovelmimica
 */
public class AppListener implements ServletContextListener {
    private List<Thread> threadPool;
    private String webInfPath;
    
    private AppConfigurationBean configuration;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ucitaj konfiguraciju
        loadConfiguration(sce);
        //pokreni dretve
        startThreads();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        stopThreads();
    }
    
    private void loadConfiguration(ServletContextEvent sce){
        ServletContext servletCtx = sce.getServletContext();
        webInfPath = servletCtx.getRealPath("/WEB-INF");
        String path = servletCtx.getRealPath("/WEB-INF" + File.separator + "app-configuration.xml");
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        configuration = (AppConfigurationBean)appCtx.getBean(AppConfigurationBean.class);
        configuration.load(path);
    }
    private void startThreads(){
        threadPool = new ArrayList<Thread>();
        StorageFolderWatchingThread folderWatching = new StorageFolderWatchingThread(webInfPath);
        folderWatching.start();
        threadPool.add(folderWatching);
        
    }
    private void stopThreads(){
        AbstractThread.stopThreads();
        for(Thread t : threadPool){
            t.interrupt();
        }
    }
    
    
}
