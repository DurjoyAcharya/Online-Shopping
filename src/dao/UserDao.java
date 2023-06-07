package dao;

import connection.DbConfig;
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


}
