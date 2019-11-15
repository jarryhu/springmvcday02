<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/11
  Time: 22:29
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


<table border="1" cellspacing="0" align="center">
    <caption>用户列表</caption>

    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="item">
        <tr>
            <td>${item.user_id}</td>
            <td>${item.user_name}</td>
            <td>${item.user_age}</td>
            <td>${item.user_major}</td>
            <td><img src="/pic/${item.headpath}" width="100" height="100"></td>
            <td><a href="#">编辑</a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>
<div align="center"> 当前页是第<span>${pageInfo.pageNum}</span>页 &nbsp; 一共<span>${pageInfo.pages}</span>页 &nbsp;
    <c:if test="${pageInfo.isFirstPage==false}">
        <a href="<%=request.getContextPath()%>/userList.action?page=${pageInfo.prePage}"> 上一页</a></c:if>
    <c:if test="${pageInfo.isFirstPage==true}">上一页</c:if>
    <c:if test="${pageInfo.isLastPage==false}">
        <a href="<%=request.getContextPath()%>/userList.action?page=${pageInfo.nextPage}">下一页</a>
    </c:if>
    <c:if test="${pageInfo.isLastPage==true}">下一页</c:if>
</div>
<script type="text/javascript">
    $(function () {

        var a = $("a");
        a.on("click", function () {

            for (var i = 0; i < a.length; i++) {
                var id = $(this)[i].parentNode.parentNode.children[0].innerHTML;
                console.log(id);
                location.href = "<%=request.getContextPath()%>/getUserByid.action?id=" + id;
            }
        })
    })
</script>

</body>
</html>
