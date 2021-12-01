package cn.yj.db.mybatis.mapper;

import cn.yj.db.jdbc2.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    User queryUserById(int userId);

    List<User> queryUsers();

    List<User> queryUsersLikeNameGreatAge(@Param("name") String name, @Param("age") int age);

    List<User> queryByAge(@Param("age") Integer age);

    List<User> queryByName(@Param("name") String name);

    void updateUserNameById(@Param("userId") Integer userId, @Param("userName") String userName);

    /*int updateUserById(User user);

    int deleteUserById(int userId);*/
}
