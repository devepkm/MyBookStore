package com.devepkm.test;

import com.devepkm.bean.User;
import com.devepkm.service.UserService;
import com.devepkm.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:40
 * @Description:
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void signUp() {
        boolean issignUped = userService.signUp(new User("akssds", "qawsed", "akssds@gmail.com"));
        System.out.println(issignUped);

    }

    @Test
    public void login() {
        User u = new User("akssds", "qawsed");
        boolean isLogined = userService.login(u);
        System.out.println(isLogined);
        u = new User("akssds", "aaa");
        isLogined = userService.login(u);
        System.out.println(isLogined);
    }

    @Test
    public void isUsernameExits() {
        boolean isUsernameExits = userService.isUsernameExits("akssds");
        System.out.println(isUsernameExits);
        isUsernameExits = userService.isUsernameExits("aaaa");
        System.out.println(isUsernameExits);
    }
}