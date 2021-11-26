package cn.yj.mysql.jdbc1;

import org.junit.Test;

import java.sql.*;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-17
 */
public class TestJdbc {
    public static String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useSSL=false";
    public static String userName = "root";
    public static String pwd = "123456";
    public static String DRIVER = "com.mysql.jdbc.Driver";

    @Test
    public void queryWithStatement(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//注册数据库驱动
            Connection con = DriverManager.getConnection(jdbcUrl, userName, pwd);//获取数据库连接
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from user");
            System.out.println("---查询结果如下：---");
            while (rs.next()){
                System.out.println("id:"+rs.getInt("id")+", name:"+rs.getString("name")+", age:"+rs.getInt("age")+",sex:"+rs.getString("sex"));
            }

            rs.close();
            statement.close();
            con.close();

            System.out.println("---成功结束！--");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryWithStatement2() throws Exception{
        Connection connection = DriverManager.getConnection(jdbcUrl, userName, pwd);
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from user");//statement.execute
        System.out.println("执行结果："+execute);
        ResultSet rs = statement.getResultSet();
        while (rs.next()){
            System.out.println("id:"+rs.getInt("id")+", name:"+rs.getString("name")+", age:"+rs.getInt("age")+",sex:"+rs.getString("sex"));
        }

        rs.close();
        statement.close();
        connection.close();

        System.out.println("---成功结束！--");
    }

    @Test
    public void updateWithStatement(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcUrl, userName, pwd);
            Statement statement = con.createStatement();
            int count = statement.executeUpdate("insert into user(name, age, sex) values ('bigKinfeWangwu',50,'male')");
            System.out.println("成功条数:"+count);
            statement.close();
            con.close();
            System.out.println("---成功结束！--");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void batchWithStatement(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcUrl, userName, pwd);
            Statement statement = con.createStatement();

            statement.addBatch("insert into user(name, age, sex) values ('wangchongyang',69,'male')");
            statement.addBatch("insert into user(name, age, sex) values ('xiaolongnv',26,'female')");
            statement.addBatch("insert into user(name, age, sex) values ('yangguo',20,'male')");

            int[] ints = statement.executeBatch();

            System.out.println("成功条数:"+ints);
            statement.close();
            con.close();
            System.out.println("---成功结束！--");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryWithPreparedStatement(){

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.160.35.155:3306/yaojun_db?user=work&password=test123";
            Connection con = DriverManager.getConnection(url);
//            Connection con = DriverManager.getConnection(jdbcUrl, userName, pwd);
            String preSql = "select * from t_learn_user where id<? and sex=?";
            PreparedStatement pst = con.prepareStatement(preSql);
            pst.setInt(1, 4);
            pst.setString(2, "female");
            ResultSet rs = pst.executeQuery();
            System.out.println("---查询结果为：---");
            while (rs.next()){
                System.out.println("id:"+rs.getInt("id")+", name:"+rs.getString("name")+", age:"+rs.getInt("age")+",sex:"+rs.getString("sex"));
            }

            rs.close();
            pst.close();
            con.close();

            System.out.println("---成功结束！--");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteWithPreparedStatement(){

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcUrl, userName, pwd);
            String preSql = "delete from t_learn_user where id=?";
            PreparedStatement pst = con.prepareStatement(preSql);
            pst.setString(1, "5");
            int i = pst.executeUpdate();
            System.out.println("成功条数:"+i);

            pst.close();
            con.close();

            System.out.println("---成功结束！--");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testTransaction() throws Exception{
        Connection conn = DBUtil.getConnection();
        try {
            System.out.println(conn.getAutoCommit());
            conn.setAutoCommit(false);//关闭自动提交
            System.out.println(conn.getAutoCommit());

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
            System.out.println(conn.getAutoCommit());

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
        String deleteSQL = "delete from t_learn_user where id=?";
        PreparedStatement pst = conn.prepareStatement(deleteSQL);
        pst.setInt(1, 1);
        int i = pst.executeUpdate();
        System.out.println("updateForTransaction成功条数:"+i);
    }

    private void updateForTransaction(Connection conn) throws SQLException {
        String updateSQL = "update t_learn_user set name=? where id=?";
        PreparedStatement pst = conn.prepareStatement(updateSQL);
        pst.setString(1, "goudan");
        pst.setInt(2, 11);
        int i = pst.executeUpdate();
        System.out.println("updateForTransaction成功条数:"+i);
    }

    private void insertForTransaction(Connection conn) throws SQLException {
        String insertSQL = "insert into t_learn_user(name, age, sex) values(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(insertSQL);
        pst.setString(1, "adan");
        pst.setInt(2, 32);
        pst.setString(3, "male");
        int i = pst.executeUpdate();
        System.out.println("insertForTransaction成功条数:"+i);
    }


}
