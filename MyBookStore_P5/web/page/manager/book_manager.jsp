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
    <%--    static manager menu--%>
    <%@include file="/page/common/manager_menu.jsp" %>

    <%--    add a js for delete confirmation--%>
    <script type="text/javascript">
        $(function () {
            $("a.delete").click(function () {
                return confirm("Delete " + $(this).parent().parent().find("td:first").text() + "?");
            });
        });
    </script>

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

        <c:forEach items="${requestScope.page.records}" var="book">

            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=querybook&id=${book.id}">Edit</a></td>
                <td><a class="delete" href="manager/bookServlet?action=delete&id=${book.id}">Delete</a></td>
            </tr>

        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="page/manager/book_edit.jsp">Add new a book</a></td>
        </tr>
    </table>

    <div id="page_nav">
        <a href="#">First&nbsp;</a>
        <a href="#">&lt;&nbsp;</a>
        <a href="#">3&nbsp;</a>
        [${requestScope.page.pageNo}]&nbsp;
        <a href="#">5&nbsp;</a>
        <a href="#">&gt;&nbsp;</a>
        <a href="#">Last</a>
        &nbsp;&nbsp;&nbsp;&nbsp; ${requestScope.page.totalPageNo} Pages, ${requestScope.page.totalRecord}  Records&nbsp;<span>Page&nbsp;<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/> </span>
        <input type="button" value="Go">
    </div>
</div>

<%@include file="/page/common/footer.jsp" %>

</body>
</html>