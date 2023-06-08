package dao;

import connection.DbConfig;
import user.ForgotPassword;

import javax.swing.*;
import java.sql.*;

public class RecoverDao {
    public Connection con;
    public PreparedStatement ps=null;
    public Statement st=null;
    public ResultSet rs=null;

    public RecoverDao() throws SQLException {
        this.con = DbConfig.getCon();
    }

    public boolean isEmailExist(String email) throws SQLException {
        ps=con.prepareStatement("select * from user where uemail=?");
        ps.setString(1,email);
        rs = ps.executeQuery();
        if (rs.next()) {
            ForgotPassword.question.setText(rs.getString(6));
            return true;
        }else
            JOptionPane.showMessageDialog(null,"Email Doesn't Exists");
        return false;
    }

    public boolean getAnswer(String email,String ans) throws SQLException{
        ps=con.prepareStatement("select * from user where uemail=?");
        ps.setString(1,email);
        rs = ps.executeQuery();
        if (rs.next()) {
            var oldans=rs.getString(7);
            if (oldans.equals(ans))
                return true;
            else {
                JOptionPane.showMessageDialog(null,"Security Answer didn't matched");
                return false;
            }
        }else
            JOptionPane.showMessageDialog(null,"Email Doesn't Exists");
        return false;
    }
    public void setPassword(String email,String pass) throws SQLException {
        String sql="update user set upassword = ? where uemail=?";
        ps=con.prepareStatement(sql);
        ps.setString(2,email);
        ps.setString(1,pass);
        if (ps.executeUpdate()>0)
            JOptionPane.showMessageDialog(null,"Password Successfully Updated");
    }
}
