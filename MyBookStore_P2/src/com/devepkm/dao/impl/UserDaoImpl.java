package com.devepkm.dao.impl;

import com.devepkm.bean.User;
import com.devepkm.dao.BaseDao;
import com.devepkm.dao.UserDao;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:11
 * @Description:
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        return queryForOne(sql, username);
    }

    @Override
    public User verifyUser(String username, String password) {
        String sql = "select * from user where username = ? AND password = ?";
        return queryForOne(sql, username, password);
    }

    @Override
    public boolean saveUser(User u) {
        String sql = "insert into user(username, password, email) values(?,?,?)";
        int rsCount = update(sql, u.getUsername(), u.getPassword(), u.getEmail());
        return rsCount == 0 ? false : true;
    }
}
