<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>

    <%@include file="/page/common/header.jsp" %>


</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <c:if test="${empty sessionScope.user}">

        <div>
            <a href="page/user/login.jsp">Login</a> &nbsp;
            <a href="page/user/regist.jsp">Sign Up</a> &nbsp;
            <a href="page/cart/cart.jsp">Cart</a> &nbsp;&nbsp;
            <a href="page/manager/manager.jsp">Management</a>
        </div>

    </c:if>

    <c:if test="${not empty sessionScope.user}">

        <%@include file="/page/common/login_success_menu.jsp" %>


    </c:if>

</div>

<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="priceSearch">
                Price：<input id="min" type="text" name="min" value="${param.min}"> -
                <input id="max" type="text" name="max" value="${param.max}">
                <input type="submit" value="Search"/>
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有3件商品</span>
            <div>
                您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
            </div>
        </div>

        <c:forEach items="${requestScope.page.records}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">Name:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">Author:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">Price:</span>
                        <span class="sp2">$${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">Sales:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">Stock:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button>加入购物车</button>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>

    <%@ include file="/page/common/nav.jsp" %>

</div>

<%@include file="/page/common/footer.jsp" %>


</body>
</html>