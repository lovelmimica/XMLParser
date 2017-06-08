/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.altima.lovelmimica.web.spring.beans.controllers;

import hr.altima.lovelmimica.web.spring.beans.BeanConfiguration;
import hr.altima.lovelmimica.web.spring.beans.ParsingServiceBean;
import hr.altima.lovelmimica.web.spring.beans.PresentEntriesBean;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.w3c.dom.Document;

/**
 *
 * @author lovelmimica
 */
public class IndexController extends ParameterizableViewController{

    private ParsingServiceBean parsingService;
    private PresentEntriesBean presentEntries;
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("CONTROLLER: handlam request");
        if(request.getMethod().equalsIgnoreCase("post")) {
           
            String txtAreaContent = request.getParameter("xmlInpuArea");
            System.out.println("CONTROLLER: post metoda " + txtAreaContent);
            
            loadBeans();
            parsingService.doService(txtAreaContent);
            
            
            
            request.getSession().setAttribute("presentEntries", presentEntries);
            
        }
        return super.handleRequest(request, response); 
        
    }
    
    private void loadBeans(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        if(parsingService == null)         
            parsingService = (ParsingServiceBean)ctx.getBean(ParsingServiceBean.class);
        if(presentEntries == null)
            presentEntries = (PresentEntriesBean)ctx.getBean(PresentEntriesBean.class);
        
    }
           
    
}
