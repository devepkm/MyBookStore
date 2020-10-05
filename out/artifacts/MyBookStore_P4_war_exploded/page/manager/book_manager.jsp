<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/page/common/header.jsp" %>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <div>
        <a href="book_manager.jsp">图书管理</a>
        <a href="order_manager.jsp">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <table>
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Author</td>
            <td>Sales</td>
            <td>Stock</td>
            <td colspan="2">Manipulate</td>
        </tr>

        <c:forEach items="${requestScope.booklist}" var="book">

            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="book_edit.jsp">Edit</a></td>
                <td><a href="#">Delete</a></td>
            </tr>

        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="book_edit.jsp">Add new a book</a></td>
        </tr>
    </table>
</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>