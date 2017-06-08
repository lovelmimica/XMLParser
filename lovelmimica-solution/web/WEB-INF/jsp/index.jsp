<%@page import="hr.altima.lovelmimica.web.spring.beans.PresentEntriesBean"%>
<%@page import="hr.altima.lovelmimica.web.utils.Entry"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lovel Mimica - solution</title>
    </head>

    <body>
        <h1>Put xml content in textarea:</h1>
        <form method="post">
            <textarea name="xmlInpuArea" rows="5" ></textarea>
            <input type="submit" value="Submit xml content"/>
        </form>
        <h1>Present entries: </h1>
        <% 
           PresentEntriesBean presentEntries = (PresentEntriesBean)session.getAttribute("presentEntries");
           if(presentEntries != null) out.print(presentEntries.toString());
        %>
    </body>
</html>
