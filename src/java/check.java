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

public class check extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {      
        String otp = req.getParameter("auth");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        PreparedStatement ps = null;       
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            String query = "select * from forgot where otp = '" + otp + "';";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();          
            
            if(rs.next())
            {
                if(rs.getString(2).equals(otp))
                {                
                    res.sendRedirect("newPass.html");
                }               
            }
            else
            {
                out.println("Wrong OTP !");
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
        
    }
}
