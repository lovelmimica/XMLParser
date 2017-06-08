/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lovelmimica
 */
public class ParsingServiceBeanIT {
    
    public ParsingServiceBeanIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doService method, of class ParsingServiceBean.
     */
    @Test
    public void testDoService_List() {
        System.out.println("doService");
        List<File> xmlFiles = new ArrayList<File>();
        String path = "C:\\Users\\lovelmimica\\Documents\\Business\\altima\\lovelmimica-solution\\test_file.xml";
        xmlFiles.add(new File(path));
        ParsingServiceBean instance = new ParsingServiceBean();
        instance.doService(xmlFiles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doService method, of class ParsingServiceBean.
     */
    @Test
    public void testDoService_String() {
        System.out.println("doService");
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
"<entries> \n" +
"	<entry>Adam</entry> \n" +
"	<entry parentName=\"Adam\">Stjepan</entry> \n" +
"	<entry parentName=\"Stjepan\">Luka</entry> \n" +
"	<entry parentName=\"Adam\">Leopold</entry> \n" +
"</entries>";
        ParsingServiceBean instance = new ParsingServiceBean();
        instance.doService(xmlString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
