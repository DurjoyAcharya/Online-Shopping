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
public class ProductDao {
       public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public ProductDao() {
           try {
               con=DbConfig.getCon();
           } catch (SQLException ex) {
               Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
     public int getMaxRowElement() throws SQLException {
        int row =0;
        st= con.createStatement();
        rs=st.executeQuery("select max(pid) from product");
        while (rs.next())
            row=rs.getInt(1);
        return row;
    }
     public void insertData(
            int pid,
            String pname,
            String cname,
            int qty,
            double price
            )throws SQLException {
        String sql="INSERT INTO product VALUES(?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setInt(1,pid);
        ps.setString(2,pname);
        ps.setString(3,cname);
        ps.setInt(4,qty);
        ps.setDouble(5, price);
        
        if (ps.executeUpdate()>0){
            JOptionPane.showMessageDialog(null,
                    "Product successfully added ","Product Added",JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
     
      public void getProductValue(JTable table,String search){
        var sql="select * from product where concat(pid,pname,cname) like ? order by pid desc";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,"%"+search+"%");
            rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            Object[] rowData;
            while(rs.next()){
                rowData=new Object[5];
                rowData[0]=rs.getInt(1);
                rowData[1]=rs.getString(2);
                rowData[2]=rs.getString(3);
                rowData[3]=rs.getInt(4);
                rowData[4]=rs.getDouble(5);
                model.addRow(rowData);
            }} 
            catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
}
      
      
      public void updateProduct(
            int pid,
            String pname,
            String cname,
            int qty,
            double price
    ) throws SQLException {
        String sql="UPDATE product SET pname=?,cname=?,qty=?,pprice=? WHERE pid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,pname);
        ps.setString(2,cname);
        ps.setInt(3,qty);
        ps.setDouble(4,price);
        ps.setInt(5, pid);
        if (ps.executeUpdate()>0)
            JOptionPane.showMessageDialog(null,"Product data successfully updated");
    }
      public int countCategories(){
          int total=0;
          String sql="select count(*) as 'total' from category";
           try {
               st=con.createStatement();
                rs=st.executeQuery(sql);
                if(rs.next())
                    total=rs.getInt(1);
                
           } catch (SQLException ex) {
               Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
           }
          return total;    
      }
      public String[] getCategories(){
          String[] categories=new String[countCategories()];
           try {
               con.createStatement();
               rs=st.executeQuery("select * from category");
                  int i=0;
                  while(rs.next()){
                      categories[i]=rs.getString(2);
                      i++;
                  }
               
           } catch (SQLException ex) {
               Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
           }
          return categories;
          
      }
      public boolean isIdExist(int id){
         var sql="select * from category where cid=?";
           try {
               ps=con.prepareStatement(sql);
               ps.setInt(1, id);
               rs=ps.executeQuery();
               if(rs.next())
                   return true;
           } catch (SQLException ex) {
               Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           return false;
      }
      
        public boolean isProductCategoryExist(String product,String category){
         var sql="select * from product where pname=? and cname=?";
           try {
               ps=con.prepareStatement(sql);
               ps.setString(1, product);
               ps.setString(2, category);
               rs=ps.executeQuery();
               if(rs.next())
                   return true;
           } catch (SQLException ex) {
               Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           return false;
      }
}
