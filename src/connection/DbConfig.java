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

   
   public static Connection con=null;
   private String user="root";
   private String pass="";
   private String url="jdbc:mysql://127.0.0.1/rupkotha";

   public static Connection getCon() throws SQLException{
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);

       }catch(ClassNotFoundException e){
           JOptionPane.showMessageDialog(null,"","",JOptionPane.WARNING_MESSAGE);
       }
       return con;
   }
   
    
}
