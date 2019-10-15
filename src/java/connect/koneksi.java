/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muhammad Ferly
 */
import java.sql.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "koneksi", urlPatterns = {"/koneksi"})
public class koneksi{
    public static Connection getConnection()
    {
        Connection conn= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tes_icon";
            String user = "root";
            String pass = "";
            
            conn=DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException ex)
        {
            System.out.println("Class Eror :" +ex);
        }catch(SQLException ex)
        {
            System.out.println("Driver eror :"+ex);
            
        }catch(Exception ex)
        {
            System.out.println("Eror :"+ex);
        }
           return conn;
    }
 
}