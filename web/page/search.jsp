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
            var data = {"user_name": $userName.val(), "user_major": $user_major.val()}
            console.log(data);
            $.ajax({
                url: "<%=request.getContextPath()%>/search.action",
                type: "get",
                contentType: 'application/json; charset=UTF-8',
                dataType: "json",//请求页面返回的数据类型
                data: data,
                success: function (data) {
                    console.log("111111111");
                    $.each(data, function () {
                        var tr = $("<tr align='center'/>");
                        $("<td/>").html(this.id).appendTo(tr);
                        $("<td/>").html(this.name).appendTo(tr);
                        $("<td/>").html(this.price).appendTo(tr);
                        $("<td/>").html(this.creatTime).appendTo(tr);
                        $("<td/>").html(this.detail).appendTo(tr);
                        $("#book-table").append(tr);
                    })
                }

            })
        })
    })
</script>
</body>
</html>
