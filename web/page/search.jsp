<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/14
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="<%=request.getContextPath()%>/page/jquery/jquery-1.12.4.js"></script>
<head>
    <title>Title</title>
</head>
<body>
name: <input type="text" name="user_name"> major: <input type="text" name="user_major">
<input type="button" value="查询" id="search">
<div>

</div>

<script type="text/javascript">
    $(function () {
        var search = $("#search");
        var $userName = $("input[name=user_name]");
        var $user_major = $("input[name=user_major]");

        search.on("click", function () {
            var data = {user_name: $userName.val(), user_major: $user_major.val()}
            console.log(data);
            $.ajax({
                url: "<%=request.getContextPath()%>/search.action",
                dataType: 'json',
                contentType: 'application/json',
                type: "POST",
                data: JSON.stringify(data),
                success: function (d) {
                    var tbody = $("tbody");
                    tbody.empty();
                    for (var i = 0; i < d.length; i++) {
                        tbody.append("<tr><td>" + d[i].id + "</td><td>" + d[i].name + "</td><td>" + d[i].price + "</td><td>" + d[i].creatTime + "</td><td>" + d[i].detail + "</td></tr>")


                    }


                }

            })
        })
    })
</script>
<table>
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

        </tbody>
    </table>
</table>
</body>
</html>
