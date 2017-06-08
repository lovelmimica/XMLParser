/*
 * To change this license h
    eader, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import org.foi.nwtis.lovmimica.konfiguracije.Konfiguracija;
import org.foi.nwtis.lovmimica.konfiguracije.KonfiguracijaApstraktna;
/**
 *
 * @author lovelmimica
 */
public class AppConfigurationBean {
    
    private static final String THREAD_INTERVAL = "thread-interval";
    private static final String STORAGE_FOLDER = "storage-folder";
    private static final String NODE_NAME = "node-name";
    private static final String PARENT_ATTRIBUTE = "parent-attribute";
    private static final String DB_URL = "db-url";
    private static final String DB_USERNAME = "db-username";
    private static final String DB_PASSWORD = "db-password";
    
    private Integer threadInterval;
    private String storageFolder;
    private String nodeName;
    private String parentAttribute;
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    
    public AppConfigurationBean() {
        //psotavi defaultne vrijednosti konfiguraciji
        threadInterval = 10;
        storageFolder = "/storage-folder";
        nodeName = "entry";
        parentAttribute = "parentName";
        dbUrl = "jdbc:derby://localhost:1527/altima-test-db";
        dbUsername = "lovel";
        dbPassword = "123";
    }
    
    public void load(String path){
        try {
            Konfiguracija conf = KonfiguracijaApstraktna.preuzmiKonfiguraciju(path);
            threadInterval = new Integer(conf.dajPostavku(THREAD_INTERVAL));
            storageFolder = conf.dajPostavku(STORAGE_FOLDER);
            nodeName = conf.dajPostavku(NODE_NAME);
            parentAttribute = conf.dajPostavku(PARENT_ATTRIBUTE);
            dbUrl = conf.dajPostavku(DB_URL);
            dbUsername = conf.dajPostavku(DB_USERNAME);
            dbPassword = conf.dajPostavku(DB_PASSWORD);
            
        } catch (Exception ex) {
            System.err.println("Nemoguce ucitati konfiguraciju. Zadrzane prethodne (ili default) vrijednosti");
            ex.printStackTrace();
        }
    }

    public Integer getThreadInterval() {
        return threadInterval;
    }

    public String getStorageFolder() {
        return storageFolder;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getParentAttribute() {
        return parentAttribute;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
    
    
    
}
