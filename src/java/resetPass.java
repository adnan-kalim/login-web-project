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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.*; // For HttpServlet
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

public class resetPass extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        String pass = req.getParameter("newpass");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            
            String q = "select * from forgot;";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            
            String name = rs.getString(1);
            
            String query = "update loginInfo set password = ? where userid = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, name);
            int num = ps.executeUpdate();
            
            ps.close();
            con.close();
            
            if(num==0)
            out.println("0 rows affected");                     
            else
            {
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.html"); 
                dispatcher.include(req, res); 
            }
        }
        catch(SQLException se)
        {
            out.println(se);
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
