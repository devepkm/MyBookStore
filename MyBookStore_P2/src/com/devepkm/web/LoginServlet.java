package com.devepkm.web;


import com.devepkm.bean.User;
import com.devepkm.service.UserService;
import com.devepkm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:46
 * @Description:
 */
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isLogin = userService.login(new User(username, password));

        if (isLogin){
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        } else {
            System.out.println("wrong info");
            dispatchBack(req, resp);
        }


    }

    private void dispatchBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
    }
}
