<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员登录页面</title>
    <%@include file="/page/common/header.jsp" %>

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="page/user/regist.jsp">Sign Up Now</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg"><%=request.getAttribute("errMsg") == null ? "Plase Enter Username and Password" : request.getAttribute("errMsg")%></span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <%--                        for UserServlet to determinate which method to call--%>
                        <input type="hidden" name="action" value="login">
                        <label>Username: </label>
                        <input class="itxt" type="text" value="${cookie.username.value}" autocomplete="off" tabindex="1"
                               name="username"/>
                        <br/>
                        <br/>
                        <label>Password: </label>
                        <input class="itxt" type="password"  autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="Login" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/page/common/footer.jsp" %>

</body>
</html>