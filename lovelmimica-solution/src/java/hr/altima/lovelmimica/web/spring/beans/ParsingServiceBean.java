/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import hr.altima.lovelmimica.web.utils.Entry;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lovelmimica
 */
public class ParsingServiceBean{
    @Autowired
    XmlParserBean parser;
    @Autowired
    PresentEntriesBean presentEntries;
    
    public void doService(List<File> xmlFiles) {
        System.out.println("SERVICE: izvrsavam uslugu parsiranja xmla");
        for(File f : xmlFiles){
            try {
                parseFile(f);
                deleteFile(f);
            } catch (Exception ex) {
                System.out.println(new Date() + " EXCEPTION: " + ex.toString());
            }
        }
    }
    public void doService(String xmlString){
        try {
            List<Entry> entryList = parser.parseXml(xmlString);
            presentEntries.appendEntries(entryList);
        } catch (Exception ex) {
            System.out.println("EXCEPTION: Neispravan format xmlString - a");
        }
    }
    private void parseFile(File xmlFile) throws Exception{
        System.out.println("SERVICE: parsiram " + xmlFile.toString());
        
        //kreiraj listu novih objekata Entry 
        List<Entry> entryList = parser.parseXml(xmlFile);
        System.out.println("SERVICE: ucitani entry: " + entryList.size());
        //posalji listu Entrya u skladiste Entrya
        presentEntries.appendEntries(entryList);
    }
    private void deleteFile(File f){
        f.delete();
    }
}
