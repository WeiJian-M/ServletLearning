package com.mwj.dao;


import com.mwj.domain.User;
import com.mwj.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
操作数据库中User表的类
 */
public class UserDao {

    // 声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate((JDBCUtils.getDataSource()));

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据
     */
    public User login(User loginUser){

        // 1. 编写sql语句
        String sql = "select * from user where username = ? and passord = ?";
        // 2. 调用query方法
        User user = template.queryForObject(sql,
                new BeanPropertyRowMapper<User>(User.class),
                loginUser.getUsername(), loginUser.getPassword());

        return user;

    }
}
