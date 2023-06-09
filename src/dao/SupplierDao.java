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
     public void updateSupplier(
            int id,
            String uname,
            String uemail,
            String upass,
            String uphone,
            String address1,
            String address2
    ) throws SQLException {
        String sql="UPDATE supplier SET sname=?,semail=?,spassword=?,sphone=?,saddress1=?,saddress2=? WHERE sid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,uname);
        ps.setString(2,uemail);
        ps.setString(3,upass);
        ps.setString(4,uphone);
        ps.setString(5,address1);
        ps.setString(6,address2);
        ps.setInt(7,id);
        if (ps.executeUpdate()>0)
            JOptionPane.showMessageDialog(null,"Supplier Data Successfully Updated");
    }
     
        public int getSupplierId(String email) throws SQLException {
        int id=0;
        String sql="select sid from supplier where semail=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,email);
        rs=ps.executeQuery();
        if (rs.next())
            id=rs.getInt(1);
        return id;
    }
        
        
        public String[] getSupplierData(int sid) throws SQLException {
        String[] value=new String[7];
        String sql="select * from supplier where sid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,sid);
        rs = ps.executeQuery();
        if (rs.next()){
            value[0]=rs.getString(1);
            value[1]=rs.getString(2);
            value[2]=rs.getString(3);
            value[3]=rs.getString(4);
            value[4]=rs.getString(5);
            value[5]=rs.getString(6);
            value[6]=rs.getString(7);
        }
        return value;
    }
        
       public void deleteSupplierdata(int id){
       String sql="DELETE FROM supplier WHERE sid=?";
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this account? ","Remove Account",JOptionPane.OK_CANCEL_OPTION,0);
        if(showConfirmDialog==JOptionPane.OK_OPTION){
           try {
               ps=con.prepareStatement(sql);
               ps.setInt(1, id);
               if(ps.executeUpdate()>0)
                   JOptionPane.showMessageDialog(null, "Account Successfully Removed");
           } catch (SQLException ex) {
               Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
    }
       
       public int countSuppliers(){
           int total =0;
        try {
            st=con.createStatement();
            rs=st.executeQuery("select count(*) as 'total' from supplier");
            if(rs.next())
                total=rs.getInt(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return total;
       }
       
       public String[] getSuppliers(){
           String[] suppliers=new String[countSuppliers()]; 
        try {
            st=con.createStatement();
            rs=st.executeQuery("select * from supplier");
            int i=0;
            while(rs.next()){
                suppliers[i]=rs.getString(2);
                i++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return suppliers;
       }
     
       public String getSupplierName(String email) throws SQLException {
        String name="";
        String sql="select sname from supplier where semail=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,email);
        rs=ps.executeQuery();
        if (rs.next())
            name=rs.getString(1);
        return name;
    }
       
}
