package com.devepkm.web;

import com.devepkm.bean.User;
import com.devepkm.service.UserService;
import com.devepkm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: dev
 * @Date: 30/9/2020 14:57
 * @Description:
 */
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isLogin = userService.login(new User(username, password));

        if (isLogin) {
            req.getRequestDispatcher("/page/user/login_success.jsp").forward(req, resp);
            return;
        } else {
            req.setAttribute("errMsg", "Wrong Username or Password");
            req.setAttribute("usename", username);
            req.getRequestDispatcher("page/user/login.jsp").forward(req, resp);
            return;

        }



    }


    protected void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        set code to abcd as right (since no backend has impled.)
        if ("abcd".equalsIgnoreCase(code)) {

            if (!userService.isUsernameExits(username)) {
                userService.signUp(new User(username, password, email));
                req.getRequestDispatcher("page/user/regist_success.jsp").forward(req, resp);
                return;

            }
            req.setAttribute("errMsg", "Username Exits");
            req.setAttribute("usename", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("page/user/regist.jsp").forward(req, resp);
            return;


        } else {
            req.setAttribute("errMsg", "Wrong Code");
            req.setAttribute("usename", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("page/user/regist.jsp").forward(req, resp);
            return;

        }


    }
}
