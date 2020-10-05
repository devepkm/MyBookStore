<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <%@include file="/page/common/header.jsp" %>

    <script type="text/javascript" src="static/script/sign_up.js"></script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">Welcome</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>Sign up for free</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("errMsg") == null ? "" : request.getAttribute("errMsg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <%--                        for UserServlet to determinate which method to call--%>

                        <input type="hidden" name="action" value="signUp">
                        <label>Username：</label>
                        <input class="itxt" type="text" placeholder="Username" autocomplete="off" tabindex="1"
                               name="username"
                               value="<%=request.getAttribute("usename") == null ? "" : request.getAttribute("usename")%>"
                               id="username"/>
                        <br/>
                        <br/>
                        <label>Password：</label>
                        <input class="itxt" type="password" placeholder="Password" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <span><label>Confirm: </label>
                        <input class="itxt" type="password" placeholder="Confirm Password" autocomplete="off"
                               tabindex="1"
                               name="repwd" id="repwd"/></span>
                        <br/>
                        <br/>
                        <label>Email：</label>
                        <input class="itxt" type="text" placeholder="Email" autocomplete="off" tabindex="1"
                               name="email"
                               value="<%=request.getAttribute("email") == null ? "" : request.getAttribute("email")%>"
                               id="email"/>
                        <br/>
                        <br/>
                        <label>Code：</label>
                        <input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
                        <img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="Sign Up" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
			<span>
				Devepkm Copyright &copy;2020
			</span>
</div>
</body>
</html>