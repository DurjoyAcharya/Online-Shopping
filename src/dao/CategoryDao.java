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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rupkotha
 */
public class CategoryDao {
       public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public CategoryDao() {
           try {
               con=DbConfig.getCon();
           } catch (SQLException ex) {
               Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
     public int getMaxRowElement() throws SQLException {
        int row =0;
        st= con.createStatement();
        rs=st.executeQuery("select max(cid) from category");
        while (rs.next())
            row=rs.getInt(1);
        return row;
    }
     public void insertData(
            int cid,
            String cname,
            String cdesc
            )throws SQLException {
        String sql="INSERT INTO category VALUES(?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setInt(1,cid);
        ps.setString(2,cname);
        ps.setString(3,cdesc);
        if (ps.executeUpdate()>0){
            JOptionPane.showMessageDialog(null,
                    "Category Successfully Added ","Category Added",JOptionPane.INFORMATION_MESSAGE);
        }
    }
      public void getCategoryValue(JTable table,String search){
        var sql="select * from category where concat(cid,cname,cdesc) like ? order by cid desc";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,"%"+search+"%");
            rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object[] rowData;
            while(rs.next()){
                rowData=new Object[3];
                rowData[0]=rs.getInt(1);
                rowData[1]=rs.getString(2);
                rowData[2]=rs.getString(3);
                model.addRow(rowData);
            }} 
            catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
}
      
      
      public void updateCategory(
            int cid,
            String cname,
            String cdesc
    ) throws SQLException {
        String sql="UPDATE category SET cname=?,cdesc=? WHERE cid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,cname);
        ps.setString(2,cdesc);
        ps.setInt(3,cid);
        if (ps.executeUpdate()>0)
            JOptionPane.showMessageDialog(null,"Category Data Successfully Updated");
    }
}
