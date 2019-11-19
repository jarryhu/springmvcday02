<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/19
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="<%=request.getContextPath()%>/page/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<table border="1" cellspacing="0" align="center">
    <caption>图书列表</caption>

    </thead>
    <tbody>
    <c:forEach items="${books}" var="item">
        <tr>
            <input type="hidden" name="bubid" value="{item.bubid}">
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.author}</td>
            <td>${item.publishDate}</td>
            <td><input type="button" value="借阅"
                       <c:if test="${item.borrowBookUser.id!=null}">disabled </c:if> </td>
            <td><input type="button" value="还书"
                       <c:if test="${item.borrowBookUser.id==null}">disabled </c:if> </td>
        </tr>
    </c:forEach>


    </tbody>
</table>
<script type="text/javascript">
    $(function () {

        var a = $("input[type=button]");
        a.on("click", function () {
            for (var i = 0; i < a.length; i++) {
                var id = $(this)[i].parentNode.parentNode.children[0].innerHTML;
                console.log(id);
                location.href = "<%=request.getContextPath()%>/borrow.action?bookid=" + id;
            }
        })


    })
</script>
</body>
</html>
