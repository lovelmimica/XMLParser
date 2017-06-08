/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import hr.altima.lovelmimica.web.utils.Entry;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author lovelmimica
 */
public class XmlParserBean {
    
    @Autowired
    private AppConfigurationBean configuration;
    
    public List<Entry> parseXml(File file) throws Exception{
        Document doc = createXmlDoc(file);
        
        return parseXmlDoc(doc);
    }
    public List<Entry> parseXml(String xmlString) throws Exception{
        Document doc = createXmlDoc(xmlString);
        
        return parseXmlDoc(doc);
    }
    
    private boolean verifyEntryNode(Node entry){
        if(entry.hasChildNodes() == false) return false;
        if(entry.getNodeName().equalsIgnoreCase(configuration.getNodeName()) == false) return false;
        return true;
    }
    private Document createXmlDoc(File file) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }
    private Document createXmlDoc(String xmlString) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(xmlString));
        Document doc = builder.parse(inputSource);
        return doc;
    }
    
    private List<Entry> parseXmlDoc(Document doc){
        NodeList entryNodeList = doc.getElementsByTagName(configuration.getNodeName());
        
        List<Entry> entryList = new ArrayList<Entry>();
        
        for(int i = 0; i < entryNodeList.getLength(); i++){
            Node entryNode = entryNodeList.item(i);
            if(verifyEntryNode(entryNode)){
                String parentName = null;
                try{
                    parentName = entryNode.getAttributes().getNamedItem(configuration.getParentAttribute()).getNodeValue();
                }catch(Exception e){}           
                String name = entryNode.getTextContent();
                Entry e = new Entry(name, parentName);
                System.out.println(new Date() + " PARSER: " + e.getName());
                entryList.add(e);
            }
        } 
        return entryList;
    }
}
