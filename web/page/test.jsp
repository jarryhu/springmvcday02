<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/13
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="<%=request.getContextPath()%>/page/jquery/jquery-3.4.1.min.js"></script>
<input type="text" name="name"><span></span>
<script type="text/javascript">
    $(function () {
        var username = $("input[name=name]");
        console.log(username.val())
        username.on("blur", function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/check.action",
                data: "name=" + username.val(),
                dateType: "text",
                type: "post",
                success: function (d) {
                    if (d.length > 0) {
                        $("span").html(d);
                    }
                }
            })
        })

    })

</script>
</body>
</html>
