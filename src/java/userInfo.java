/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adnan
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.*; // For HttpServlet
import javax.servlet.ServletException;

public class userInfo extends HttpServlet
{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        String name = req.getParameter("user");
        String pass = req.getParameter("newp");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\login1.db");
            String query = "select * from loginInfo";
            
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
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
