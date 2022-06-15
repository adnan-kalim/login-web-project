/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adnan
 */
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.servlet.ServletException;

public class addnew extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            ps = con.prepareStatement("insert into loginInfo values (?,?);");
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ps.executeUpdate();
            
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

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.html"); 
        dispatcher.include(req, res); 
        
        
    }
}
