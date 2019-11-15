<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/7
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table border="1" cellspacing="0" align="center">
    <caption>商品列表</caption>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>createDate</td>
        <td>detail</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td><fmt:formatDate value="${item.creatTime}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/></td>
            <td>${item.detail}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
