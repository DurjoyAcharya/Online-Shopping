package dao;

import connection.DbConfig;

import javax.swing.*;
import java.sql.*;

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


}
