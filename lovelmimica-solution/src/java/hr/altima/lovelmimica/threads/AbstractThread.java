/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.threads;

import hr.altima.lovelmimica.web.spring.beans.AppConfigurationBean;
import hr.altima.lovelmimica.web.spring.beans.BeanConfiguration;
import hr.altima.lovelmimica.web.spring.beans.ParsingServiceBean;
import hr.altima.lovelmimica.web.spring.beans.PresentEntriesBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author lovelmimica
 */
public abstract class AbstractThread extends Thread{
    private long interval;
    private long start;
    private long end;
    private static boolean working;
    
    protected AppConfigurationBean configuration;
    
    protected abstract void work();

    public AbstractThread() {
        loadBeans();
        working = true;
        interval = configuration.getThreadInterval() * 1000;
        
    }

    @Override
    public void run() {
        while(working){
            start = System.currentTimeMillis();
            //obavi posao
            work();
            end = System.currentTimeMillis();
            //odspavaj do kraja intervala
            try {
                sleep();
            } catch (InterruptedException ex) {}
        }
    }
    
    public static void stopThreads(){
        working = false;
    }
    
    private void sleep() throws InterruptedException{
        long workDuration = end - start;
        long sleepDuration = interval - workDuration;
        if(sleepDuration > 0) sleep(sleepDuration);
    }
    
    private void loadBeans(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        if(this.configuration == null)         
            this.configuration = (AppConfigurationBean)ctx.getBean(AppConfigurationBean.class);
        
    }
    
}
