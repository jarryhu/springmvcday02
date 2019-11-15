<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/11
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<c:if test="${msg!=null}">${msg}</c:if>
</body>
</html>
