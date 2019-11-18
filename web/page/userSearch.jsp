<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/16
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>searchUserByAjax</title>
    <script src="<%=request.getContextPath()%>/page/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>

姓名<input type="text" name="user_name"/> 专业<input type="text" name="user_major"/> <input
        type="button"
        name="search" value="搜索"/>


<script type="text/javascript">
    $(function () {
        var search = $("input[name=search]");
        search.on("click", function () {
            var name = $("input[name=user_name]").val();
            var major = $("input[name=user_major]").val();
            var data = {user_name: name, user_major: major};
            $.ajax({
                url: "<%=request.getContextPath()%>/searchUserAjax.action",//搜索的URL请求路径
                data: JSON.stringify(data),
                dataType: "json",//返回的数据格式
                contentType: "application/json;charset=utf-8",//请求的数据格式
                type: "post",
                success: function (d) {
                    for (var i = 0; i < d.length; i++) {
                        console.log(d[i]);
                    }
                }
            })
        })
    })
</script>


</body>
</html>
