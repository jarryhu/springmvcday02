<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2019/11/19
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/page/layui/css/layui.css">
    <script src="<%=request.getContextPath()%>/page/layui/layui.all.js"></script>
    <style type="text/css">
        #div1 {
            width: 200px;
            height: 200px;
            background-color: #00FF00;
        }
    </style>
</head>
<body>
<!-- 你的HTML代码 -->

<form class="layui-form" action="" lay-filter="example">
    <div class="layui-form-item">
        <label class="layui-form-label">输入框</label>
        <div class="layui-input-block">
            <i class="layui-icon">&#xe66f;</i>
            <input type="text" name="user_name" lay-verify="title" autocomplete="off"
                   placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-block">
            <i class="layui-icon">&#xe673;</i>
            <input type="password" name="user_password" placeholder="请输入密码" autocomplete="off"
                   required
                   lay-verify="password"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script>

    //一般直接写在一个js文件中
    layui.use(['layer', 'form', 'jquery', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
        $ = layui.jquery;


        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , password: [
                /^[\S]{5,12}$/
                , '密码必须5到12位，且不能出现空格'
            ]

        });
        form.render();
        form.on('submit(demo1)', function (data) {
            console.log(JSON.stringify(data.field));
            $.ajax({
                url: "<%=request.getContextPath()%>/loginTest.action",
                data: JSON.stringify(data.field),
                dataType: "json",
                type: "post",
                contentType: "application/json",
                success: function (d) {
                    if (d == 1) {
                        location.href = "<%=request.getContextPath()%>/goListPage.action"
                    } else {
                        layer.msg("用户名密码错误");
                    }
                }
            })
            return false;
        })
    });
</script>
</body>
</html>
