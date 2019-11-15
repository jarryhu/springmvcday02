<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/update.action" method="post" enctype="multipart/form-data">
    <table border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td><input type="text" name="user_id" value="${user.user_id}" readonly></td>
        </tr>

        <tr>
            <td>name</td>
            <td><input type="text" name="user_name" value="${user.user_name}"></td>
        </tr>
        <tr>
            <td>major</td>
            <td><input type="text" name="user_major" value="${user.user_major}"></td>
        </tr>
        <tr>
            <td>头像</td>
            <td><img src="/pic/${user.headpath}" width="100" height="100"/><input type="file" name="pictureFile"></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
