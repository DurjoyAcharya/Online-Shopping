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
    public PreparedStatement ps = null;
    public Statement st = null;
    public ResultSet rs = null;

    public PurchaseDao() {
        try {
            con = DbConfig.getCon();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaxRowElement() throws SQLException {
        int row = 0;
        st = con.createStatement();
        rs = st.executeQuery("select max(id) from purchase");
        while (rs.next()) {
            row = rs.getInt(1);
        }
        return row;
    }

    public String[] getValue(String email) {
        String[] value = new String[5];
        String sql = "select uid,uname,uphone,uaddress1,uaddress2 from user where uemail = '" + email + "'";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                value[0] = rs.getString(1);
                value[1] = rs.getString(2);
                value[2] = rs.getString(3);
                value[3] = rs.getString(4);
                value[4] = rs.getString(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;

    }
    public void insert (int id, int uid, String uName, String uPhone, 
            int pid, String pname, int qty, double price,
            double total, String pDate, String address,
            String rDate, String supplier, String status) throws SQLException {
         String sql="insert into purchase values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      ps=  con.prepareStatement(sql);
      ps.setInt(1,id);
      ps.setInt(2,uid);
      ps.setString(3,uName);
      ps.setString(4,uPhone);
      ps.setInt(5,pid);
      ps.setString(6,pname);
      ps.setInt(7,qty);
      ps.setDouble (8, price);
      ps.setDouble (9, total);
        ps.setString (10, pDate);
        ps.setString (11, address);
        ps.setString (12, rDate);
        ps.setString (13, supplier);
        ps.setString(14, status);
        ps.executeUpdate();
    }

    public int getQty (int pid) throws SQLException {
        int qty = 0;
        st = con.createStatement();

        rs = st.executeQuery("select pqty from product where pid=" + pid + "");
        if (rs.next())
            qty = rs.getInt(1);
            return qty;
    }

    public void qtyUpdate(int pid,int qty) throws SQLException {
        String sql="update product set pqty=? where pid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,qty);
        ps.setInt(2,pid);
        ps.executeUpdate();
    }

}