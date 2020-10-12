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
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isLogin = userService.login(new User(username, password));

        if (isLogin){
            req.getRequestDispatcher("/page/user/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("errMsg", "Wrong Username or Password");
            req.setAttribute("usename", username);
            dispatchBack(req, resp);
        }


    }

    private void dispatchBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("page/user/login.jsp").forward(req, resp);
    }
}
