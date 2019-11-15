<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/7
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="<%=request.getContextPath()%>/page/jquery/jquery-3.4.1.min.js"></script>
<div><c:if test="${msg!=null}">${msg}</c:if></div>
<form action="<%=request.getContextPath()%>/login.action" method="post">
    <input name="user_name">
    <input name="user_password">
    <input type="submit" value="登录">
    <input type="button" value="注册">

</form>
<script type="text/javascript">

    $(function () {

        var register = $("input[type=button]");
        register.on("click", function () {

            location.href = "<%=request.getContextPath()%>/registerPage.action"
        })

    })
</script>
</body>
</html>
