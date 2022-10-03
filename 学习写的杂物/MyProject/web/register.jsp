<%--
  Created by IntelliJ IDEA.
  User: haoge
  Date: 2021/11/4
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <style>
        body{
            padding: 0;margin: 0;
            background-image: url("/image/register.jpeg");
            background-size: 1600px 800px;
        }
        #box1{
            width: 1000px;
            height: 600px;
            background-color: rgb(107,195,205);
            border-radius: 5px;
            margin: 0 auto;
            margin-top: 50px;
        }
        .s1{
            font-size: 20px;
            font-weight: bold;
            display: inline-block;
            margin-left: 100px;
            margin-top: 35px;
        }
        .s2{
            font-size: 15px;
            display: inline-block;
            position: relative;
            left: 650px;
            color: #ffff00;
        }
        form{
            width: 100%;
            height: 400px;
            background-color: #55ffff;
            text-align: center;
        }
        input{
            width: 300px;
            height: 40px;
            line-height: 40px;
            border-radius: 5px;
            border: 1px solid rgb(204,204,204);
        }
        .s3{
            font-size: 15px;
            font-weight: bold;
        }
    </style>


</head>
<body>
<div id="box1">
    <span class="s1">用户注册</span>
    <span class="s2">地址导航</span>
    <hr width="80%" align="center" size="5" color="sandybrown" >
    <form action="human?method=register" method="post">
        <br><br>
        <span class="s3">用户名:</span><input type="text" name="username" value="" /><br><br>
        <span class="s3">密码:</span><input type="password" name="password" value="" /><br><br>
        <span class="s3">年龄:</span><input type="text" name="age" value="" /><br><br>
        <span class="s3">性别:</span><input type="text" name="sex" value="" /><br><br>
        <button type="submit" class="btn btn-primary">立即注册</button>
    </form>
</div>
</body>
</html>
