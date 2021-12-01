package cn.yj.db.jdbc1;

import java.sql.*;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-18
 */
public class DBUtil {
    private DBUtil(){

    }

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(TestJdbc.jdbcUrl, TestJdbc.userName, TestJdbc.pwd);
    }

    public static void close(Connection con, Statement st, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
