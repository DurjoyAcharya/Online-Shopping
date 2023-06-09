package dao;

import connection.DbConfig;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public UserDao() throws SQLException {
        this.con = DbConfig.getCon();
    }

    public int getMaxRowElement() throws SQLException {
        int row =0;
        st= con.createStatement();
        rs=st.executeQuery("select max(uid) from user");
        while (rs.next())
            row=rs.getInt(1);
        return row;
    }
    public void insertData(
            int id,
            String uname,
            String uemail,
            String upass,
            String uphone,
            String useq,
            String uans,
            String address1,
            String address2)
            throws SQLException {
        String sql="INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,uname);
        ps.setString(3,uemail);
        ps.setString(4,upass);
        ps.setString(5,uphone);
        ps.setString(6,useq);
        ps.setString(7,uans);
        ps.setString(8,address1);
        ps.setString(9,address2);
        if (ps.executeUpdate()>0){
            JOptionPane.showMessageDialog(null,
                    "User Data Successfully Added ","Used Added",JOptionPane.INFORMATION_MESSAGE);
        }


    }
    public String[] getUserData(int uid) throws SQLException {
        String[] value=new String[9];
        String sql="select * from user where uid=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,uid);
        rs = ps.executeQuery();
        if (rs.next()){
            value[0]=rs.getString(1);
            value[1]=rs.getString(2);
            value[2]=rs.getString(3);
            value[3]=rs.getString(4);
            value[4]=rs.getString(5);
            value[5]=rs.getString(6);
            value[6]=rs.getString(7);
            value[7]=rs.getString(8);
            value[8]=rs.getString(9);
        }
        return value;
    }
    public int getUserId(String email) throws SQLException {
        int id=0;
        String sql="select uid from user where uemail=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,email);
        rs=ps.executeQuery();
        if (rs.next())
            id=rs.getInt(1);
        return id;
    }
    
    public void deleteUserdata(int id){
       String sql="DELETE FROM user WHERE uid=?";
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
    public void updateUser(
            int id,
            String uname,
            String uemail,
            String upass,
            String uphone,
            String useq,
            String uans,
            String address1,
            String address2
    ) throws SQLException {
        String sql="UPDATE user SET uname=?,uemail=?,upassword=?,uphone=?,usecqus=?,uans=?,uaddress1=?,uaddress2=? WHERE uid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,uname);
        ps.setString(2,uemail);
        ps.setString(3,upass);
        ps.setString(4,uphone);
        ps.setString(5,useq);
        ps.setString(6,uans);
        ps.setString(7,address1);
        ps.setString(8,address2);
        ps.setInt(9,id);
        if (ps.executeUpdate()>0)
            JOptionPane.showMessageDialog(null,"User Data Successfully Updated");
    }


}
