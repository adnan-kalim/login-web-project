<%-- 
    Document   : resetDetails
    Created on : 14 Jun 2022, 1:29:55 PM
    Author     : adnan
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%      
        Connection con = null;
        PreparedStatement ps = null;
        int flag = 0;
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            String query = "select * from forgot";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next())
            {
                out.println(rs.getString(1) +" " + rs.getString(2));
                out.println();
            }
            
            stm.close();
            con.close();
        }
        catch(SQLException se)
        {
            out.println(se);
            flag = 1;
        }
        catch(Exception e)
        {
            out.println(e);
            flag = 1;
        }
            
        %>
    </body>
</html>
