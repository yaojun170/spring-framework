package cn.yj.mysql.jdbc1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-17
 */
public class TestJdbcTransaction {

    @Test
    public void testTransaction() throws Exception{
        Connection conn = DBUtil.getConnection();
        try {
            System.out.println(conn.getAutoCommit());
            conn.setAutoCommit(false);//关闭自动提交

            insertForTransaction(conn);
            updateForTransaction(conn);
            deleteForTransaction(conn);
            
            conn.commit();//提交事务
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }



    @Test
    public void testTransaction2() throws Exception{
        /**
         * 测试脏读，读到未提交的数据
         * 1. A更新，但并未提交，测试B在不同的事务级别下是否可以读取
         * 2. 测试是否在同一个事务下可以，读到未提交的数据
         */
        Connection conn = DBUtil.getConnection();
        try {
            System.out.println(conn.getAutoCommit());
            conn.setAutoCommit(false);//关闭自动提交

            insertForTransaction(conn);//新增数据

            String preSql = "select * from t_learn_user where id=?";
            PreparedStatement pst = conn.prepareStatement(preSql);
            pst.setInt(1, 16);
            ResultSet resultSet = pst.executeQuery();
            printResultSet(resultSet);

            conn.commit();//提交事务
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    private void printResultSet(ResultSet rs) throws Exception{
        System.out.println("---查询结果为：---");
        while (rs.next()){
            System.out.println("id:"+rs.getInt("id")+", name:"+rs.getString("name")+", age:"+rs.getInt("age")+",sex:"+rs.getString("sex"));
        }
        System.out.println("--查询结果打印完毕！---");
    }

    private void deleteForTransaction(Connection conn) throws SQLException  {
        String deleteSQL = "delete from user where id=?";
        PreparedStatement pst = conn.prepareStatement(deleteSQL);
        pst.setInt(1, 1);
        int i = pst.executeUpdate();
        System.out.println("updateForTransaction成功条数:"+i);
    }

    private void updateForTransaction(Connection conn) throws SQLException {
        String updateSQL = "update user set name=? where id=?";
        PreparedStatement pst = conn.prepareStatement(updateSQL);
        pst.setString(1, "duanyu");
        pst.setInt(2, 6);
        int i = pst.executeUpdate();
        System.out.println("updateForTransaction成功条数:"+i);
    }

    private void insertForTransaction(Connection conn) throws SQLException {
        String insertSQL = "insert into user(name, age, sex) values(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(insertSQL);
        pst.setString(1, "xuzhuo");
        pst.setInt(2, 32);
        pst.setString(3, "male");
        int i = pst.executeUpdate();
        System.out.println("insertForTransaction成功条数:"+i);
    }


}
