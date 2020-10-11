package com.devepkm.web;

import com.devepkm.bean.User;
import com.devepkm.service.UserService;
import com.devepkm.service.impl.UserServiceImpl;
import com.devepkm.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Auther: dev
 * @Date: 30/9/2020 14:57
 * @Description:
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");

        User u = WebUtils.injectBean(new User(), req.getParameterMap());

        boolean isLogin = userService.login(u);

        if (isLogin) {
            Cookie cookie = new Cookie("username", u.getUsername());
            resp.addCookie(cookie);
            req.getSession().setAttribute("user", u);
            req.getRequestDispatcher("/page/user/login_success.jsp").forward(req, resp);
            return;
        } else {
            req.setAttribute("errMsg", "Wrong Username or Password");
            req.setAttribute("usename", u.getUsername());
            req.getRequestDispatcher("page/user/login.jsp").forward(req, resp);
            return;

        }


    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
        return;

    }


    protected void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");


        User u = WebUtils.injectBean(new User(), req.getParameterMap());

//        get userinputes code
        String code = req.getParameter("code");

//          verify verification code
        HttpSession session = req.getSession();
        String token = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        session.invalidate();

        if (token != null && token.equalsIgnoreCase(code)) {

            if (!userService.isUsernameExits(u.getUsername())) {
                userService.signUp(u);
                req.getRequestDispatcher("page/user/regist_success.jsp").forward(req, resp);
                return;

            }
            req.setAttribute("errMsg", "Username Exits");
            req.setAttribute("usename", u.getUsername());
            req.setAttribute("email", u.getEmail());
            req.getRequestDispatcher("page/user/regist.jsp").forward(req, resp);
            return;


        } else {
            req.setAttribute("errMsg", "Wrong Code");
            req.setAttribute("usename", u.getUsername());
            req.setAttribute("email", u.getEmail());
            req.getRequestDispatcher("page/user/regist.jsp").forward(req, resp);
            return;

        }


    }
}
