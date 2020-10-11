<%--
  Created by IntelliJ IDEA.
  User: dev
  Date: 5/10/2020
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>Welcome <span class="um_span">${sessionScope.user.username}</span></span>
    <a href="page/order/order.jsp">My Order</a>&nbsp;
    <a href="userServlet?action=logout">Logout</a>&nbsp;
    <a href="index.jsp">Back</a>
</div>
