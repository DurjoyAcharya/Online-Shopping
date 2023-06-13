/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConfig;

import java.sql.*;

/**
 *
 * @author rupkotha
 */
public class InventoryDao {
    public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public InventoryDao() throws SQLException {
        con= DbConfig.getCon();
    }

    private double totalPurchase(int id) throws SQLException {
        double total=0.0;
        st=con.createStatement();
        rs=st.executeQuery("select sum(total) as 'total' from purchase where uid = "+id+ "");
        if (rs.next())
            total=rs.getDouble(1);
        return total;
    }
    public int totalDeliveries(String Name) throws SQLException {
        int total=0;
        st=con.createStatement();
        rs=st.executeQuery("select count(*) as 'total' from purchase where supplier = '"+Name+"' and status = 'Reveived'");
        if (rs.next())
            total=rs.getInt(1);
        return total;
    }

}
