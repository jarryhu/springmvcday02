<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/18
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/page/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<input type="text" name="username"><span></span>

姓名： <input type="text" name="user_name">
专业： <input type="text" name="user_major">

<input type="button" name="search" value="搜索">


<script type="text/javascript">
    $(function () {
        var username = $("input[name=username]");
        username.on("blur", function () {

            $.ajax({
                url: "<%=request.getContextPath()%>/checkUserName.action",
                data: "username=" + username.val(),
                success: function (d) {
                    $("span").html(d);

                }
            })
        })


        $("input[name=search]").on("click", function () {
            var user_name = $("input[name=user_name]");
            var user_major = $("input[name=user_major]");
            var data = {"user_name": user_name.val(), "user_major": user_major.val()}
            $.ajax({
                url: "<%=request.getContextPath()%>/searchByWhere.action",//请求地址
                data: JSON.stringify(data),//请求参数
                dataType: "json",//返回值的类型
                type: "post",//请求方式
                contentType: "application/json;charset=utf-8",//请求数据类型
                success: function (d) {
                    $("tbody").empty();
                    for (var i = 0; i < d.length; i++) {
                        console.log(d[i].user_name);
                        $("tbody").append("<tr><td>" + d[i].user_name + "</td><td>" +
                            d[i].user_major + "</td></tr>"
                        )
                    }

                }
            })
        })
    })


</script>


<table border="1" cellspacing="0">
    <tbody>

    </tbody>
</table>

</body>
</html>
