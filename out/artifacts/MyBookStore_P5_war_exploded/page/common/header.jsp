<%--
  Created by IntelliJ IDEA.
  User: dev
  Date: 5/10/2020
  Time: 12:24 PM
  Static include css, js and base tag
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
        String baseUrl = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
    %>
<%--    <base href="http://localhost:8080/MyBookStore_P5/">--%>
<%--    change the static base to dynamic base--%>
<base href="<%=baseUrl%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
