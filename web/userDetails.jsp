<%-- 
    Document   : userDetails
    Created on : 9 Jun 2022, 1:56:48 PM
    Author     : adnan
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
    </head>
    <body>
        
        <% String user = (String) session.getAttribute("user");
        %>
        
        <h1>Hello <% out.println(user); %></h1>
        
        <% 
        
        Connection con = null;
        PreparedStatement ps = null;
       
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            String query = "select * from details where userid = '" + user + "' ;"; 
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
            out.println("UserID :" + rs.getString(1)); %><br>
            <% out.println("PASS   :" + rs.getString(2)); %><br>
            <% out.println("Designation  :" + rs.getString(3)); %><br>
            <% out.println("Year Of Joining :" + rs.getString(4));%><br>
            <% out.println("Location: " + rs.getString(5)); %><br>
            <%
            }
            
            ps.close();
            con.close();
        }
        catch(SQLException se)
        {
            out.println(se);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        %>
      
    </body>
</html>
