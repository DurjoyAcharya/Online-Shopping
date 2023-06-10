/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rupkotha
 */
public class PurchaseDao {
    public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public PurchaseDao() {
    try {
               con=DbConfig.getCon();
           } catch (SQLException ex) {
               Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    
     public int getMaxRowElement() throws SQLException {
        int row =0;
        st= con.createStatement();
        rs=st.executeQuery("select max(id) from purchase");
        while (rs.next())
            row=rs.getInt(1);
        return row;
    }
}
