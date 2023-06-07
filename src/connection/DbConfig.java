/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author rupkotha
 */
public class DbConfig {
   public static String username="root";
   public static String password="";
   public static String url="jdbc:mysql://localhost:3306/rupkotha";//for windows
   
   public static Connection con=null;

   public static Connection getCon() throws SQLException{
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,username,password);

       }catch(ClassNotFoundException e){
           JOptionPane.showMessageDialog(null,"","",JOptionPane.WARNING_MESSAGE);
       }
       return con;
   }
   
    
}
