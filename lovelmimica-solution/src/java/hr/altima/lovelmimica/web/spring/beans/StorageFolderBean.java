/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lovelmimica
 */
public class StorageFolderBean {
    private String path;
    private File folder;
    
    @Autowired
    private AppConfigurationBean configuration;
 
    
    public void init(){
        path = configuration.getStorageFolder();
        createFolder();
    }
    
    public List<File> getFiles(){
        File[] fileArray = folder.listFiles();
        List<File> fileList = Arrays.asList(fileArray);
        return fileList;
    }
    
    private void createFolder(){
        folder = new File(path);
        if(folder.mkdir())System.out.println(new Date() + " STORAGE: Folder JE kreiran");
        else System.out.println(new Date() + " STORAGE: Fodler NIJE kreiran");
    }

}
