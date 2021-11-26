package cn.yj.mysql.jdbc1;

import org.junit.Test;

import java.sql.*;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-17
 */
public class TestJdbcPrepare {
    @Test
    public void queryWithPreparedStatement(){
        try {
			Connection con = DBUtil.getConnection();
            String preSql = "select * from user where id>? and sex=?";
            PreparedStatement pst = con.prepareStatement(preSql);
            pst.setInt(1, 3);
            pst.setString(2, "male");
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
			Connection con = DBUtil.getConnection();
            String preSql = "delete from user where id=?";
            PreparedStatement pst = con.prepareStatement(preSql);
            pst.setInt(1, 4);
            int i = pst.executeUpdate();
            System.out.println("成功条数:"+i);

            pst.close();
            con.close();

            System.out.println("---成功结束！--");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
