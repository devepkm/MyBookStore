package com.devepkm.test;

import com.devepkm.bean.User;
import com.devepkm.dao.UserDao;
import com.devepkm.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:24
 * @Description:
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User u = userDao.queryUserByUsername("admin");
        System.out.println(u);
        u = userDao.queryUserByUsername("admin1");
        System.out.println(u);
    }

    @Test
    public void verifyUser() {
        User u = userDao.verifyUser("admin", "admin");
        System.out.println(u);
        u = userDao.verifyUser("admin", "a");
        System.out.println(u);
    }

    @Test
    public void saveUser() {

        boolean isSave = userDao.saveUser(new User("abcd", "abcd123", "abcd@gmail.com"));
        System.out.println(isSave);
    }
}