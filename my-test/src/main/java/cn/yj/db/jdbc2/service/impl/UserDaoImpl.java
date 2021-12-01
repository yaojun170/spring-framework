package cn.yj.db.jdbc2.service.impl;

import cn.yj.db.jdbc2.po.User;
import cn.yj.db.jdbc2.po.UserRowMapper;
import cn.yj.db.jdbc2.service.UserDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-12-17
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public void save(User user) {
        String sql = "insert into t_learn_user(name, age, sex) values (?,?,?)";
        int update = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSex());
        System.out.println("--jdbc新增结果返回--"+update);
    }

    @Override
    public List<User> queryUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public User queryUserById(int userId) {
        String sql = "select * from t_learn_user where id=?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "delete from t_learn_user where id=?";
        int update = jdbcTemplate.update(sql, userId);
        System.out.println("删除userId="+userId+",结果为："+update);
    }

    @Override
    public void updateUserById(User user) {
        String sql = "update user set name=?, age=?, sex=? where id=?";
        int update = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSex(), user.getId());
		if(user!=null){
			System.out.println("--主动触发异常--");
			throw new RuntimeException("exception,test transaction rollback");
		}
        System.out.println("更新结果:"+update);
    }

    @Override
    public void batchUpdateUser(List<User> users) {
        String sql = "update t_learn_user set name=?, age=?, sex=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, users.get(i).getName());
                ps.setInt(2, users.get(i).getAge());
                ps.setString(3, users.get(i).getSex());
                ps.setInt(4, users.get(i).getId());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
        System.out.println("更新成功："+ Arrays.toString(ints));
    }
}
