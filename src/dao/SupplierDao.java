/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author rupkotha
 */
import connection.DbConfig;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class SupplierDao {
    public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public SupplierDao() throws SQLException {
        this.con = DbConfig.getCon();
    }
    public int getMaxRowElement() throws SQLException {
        int row =0;
        st= con.createStatement();
        rs=st.executeQuery("select max(sid) from supplier");
        while (rs.next())
            row=rs.getInt(1);
        return row;
    }


    //For Supplier
    public void insertData(
            int id,
            String sname,
            String semail,
            String spass,
            String sphone,
            String address1,
            String address2)
            throws SQLException {
        String sql="INSERT INTO supplier VALUES(?,?,?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,sname);
        ps.setString(3,semail);
        ps.setString(4,spass);
        ps.setString(5,sphone);
        ps.setString(6,address1);
        ps.setString(7,address2);
        if (ps.executeUpdate()>0){
            JOptionPane.showMessageDialog(null,
                    "Supplier Data Successfully Added ","Supplier Added",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void getSupplierValue(JTable table,String search){
        var sql="select * from supplier where concat(sid,sname,semail) like ? order by sid desc";
       
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,"%"+search+"%");
            rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object[] rowData;
            while(rs.next()){
                rowData=new Object[7];
                rowData[0]=rs.getInt(1);
                rowData[1]=rs.getString(2);
                rowData[2]=rs.getString(3);
                rowData[3]=rs.getString(4);
                rowData[4]=rs.getString(5);
                rowData[5]=rs.getString(6);
                rowData[6]=rs.getString(7);
                model.addRow(rowData);
            }
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
