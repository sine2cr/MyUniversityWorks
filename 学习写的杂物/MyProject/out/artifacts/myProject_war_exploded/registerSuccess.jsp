<%--
  Created by IntelliJ IDEA.
  User: haoge
  Date: 2021/11/6
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册成功</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
            background-image: url(image/registerSuccess.jpeg);
            background-size: 1600px 900px;
        }
        div{
            width: 500px;
            height: 300px;
            background-color: rgb(197,180,164);
            text-align: center;
            margin-left: 900px;
            margin-top: 100px;
        }
        span{

            font-size: 50px;
            font-weight: bolder;
            font-family: "幼圆";

        }
        button{
            width: 100px ;
            height: 45px;
            text-align: center;
        }
        .a_top{
            color:#ffffff;
            font-size:25px;
        }
        a:hover{
            text-decoration:none;
            outline:none;
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div>
    <br><br>
    <span>注册成功</span>
    <br><br><br><br>
    <button type="button" class="btn btn-success"><a href="login.jsp" class="a_top">登录</a></button>
    <button type="button" class="btn btn-danger"><a href="index.jsp" class="a_top">退出</a></button>
</div>
</body>
</html>

