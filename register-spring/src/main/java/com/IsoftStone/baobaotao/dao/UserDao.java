package com.IsoftStone.baobaotao.dao;

import com.IsoftStone.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2014/9/11.
 */
@Repository
public class UserDao {
    @Autowired  //自动注入JdbcTemplate 的bean
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        String sqlStr = "select count(*) from t_user where user_name = ? and password=?";
        return jdbcTemplate.queryForInt(sqlStr, new Object[]{userName, password});
    }

    public User findUserByUserName(final String userName) {
        String sqlStr = "select user_id,user_name,credits from t_user where user_name=?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserid(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sqlStr = " update t_user set last_visit=?,last_ip=?,credits=? where user_id=? ";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserid()});
    }
}
