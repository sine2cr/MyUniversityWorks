<%--
  Created by IntelliJ IDEA.
  User: haoge
  Date: 2021/11/3
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户登录</title>
  <link rel="stylesheet" href="css/bootstrap.css"/>
  <style>
    body{
      padding: 0;margin: 0;
      background-image: url(image/2.jpg);
      background-size: 1600px 800px;
    }
    #box1{
      background-color: rgb(86,87,91);
      width: 100%;
      height: 120px;
    }
    .img1{
      position: relative;
      left: 250px;
      bottom: 15px;
    }
    .s1{
      font-size: 70px;
      position: relative;
      left: 300px;
      font-weight: 900;
      top: 10px;
      font-family: "华文彩云";
      color: #aaff00;
    }
    #box2{
      width: 400px;
      height: 500px;
      border: 1px solid black;
      border-radius: 5px;
      position: absolute;
      left: 100px;
      background-color: rgb(135,116,112);
      margin-top: 50px;
    }
    #box3{
      width: 400px;
      height: 500px;
      border: 1px solid black;
      border-radius: 5px;
      position: absolute;
      left: 100px;
      background-color: rgb(135,116,112);
      margin-top: 50px;
    }
    .s2{
      color: white;
      font-weight: bold;
      font-size: 20px;
      position: relative;
      left: 10px;
    }
    form{
      color: white;
      font-weight: bold;
      font-size: 15px;
    }
    input{
      text-align: center;
      background-color: #222222;
      height: 40px;
      line-height: 40px;
      color: #8C8C8C;
    }
    .put{
      width: 100px;
    }
    button{
      width: 200px;
      height: 50px;
      border-radius: 5px;
      position: relative;
      left: 100px;
      font-size: 30px;
      font-weight: bolder;
    }

  </style>
</head>
<body>
<div id="box1">
  <img src="image/1.jpg" class="img1 img-circle">
  <span class="s1">欢迎登录</span>
</div>
<div id="box2">
  <br>
  <span class="s2" id="s1">用户登录</span>
  <span class="s2" style="color: red;" id="s2">管理员登录</span>
  <br>
  <hr width="100%" size="2" color="#333333">
  <form action="human?method=login" method="post">
    &nbsp;&nbsp;&nbsp;用户名:&nbsp;&nbsp;&nbsp;<input type="text" name="username">
    <br><br><br>
    &nbsp;&nbsp;&nbsp;密码:&nbsp;&nbsp;&nbsp;<input type="password" name="password">
    <br><br><br>
    &nbsp;&nbsp;&nbsp;验证码:&nbsp;&nbsp;&nbsp;<input type="text" name="code" class="put">
    <img src="code?method=createCode">
    <br><br>
    <div style="text-align: center;">
      <input name="auto" type="checkbox" />&nbsp;&nbsp;两周以内自动登录
    </div>
    <br><br>
    <button type="submit" class="btn btn-primary">立即登录</button>
  </form>
</div>
<div id="box3">
  <br>
  <span class="s2" id="s3">用户登录</span>
  <span class="s2" style="color: red;" id="s4">管理员登录</span>
  <br>
  <hr width="100%" size="2" color="#333333">
  <form action="mmm?method=managerlogin" method="post">
    &nbsp;&nbsp;&nbsp;用户名:&nbsp;&nbsp;&nbsp;<input type="text" name="managerName">
    <br><br><br>
    &nbsp;&nbsp;&nbsp;用户名:&nbsp;&nbsp;&nbsp;<input type="password" name="managerPassword">
    <br><br><br>
    <button type="submit" class="btn btn-primary">立即登录</button>
  </form>
</div>
</body>
<script>
  window.onload = function(){
    var s1 = document.querySelector("#s1");
    var s2 = document.querySelector("#s2");
    var s3 = document.querySelector("#s3");
    var s4 = document.querySelector("#s4");
    var box2 = document.querySelector("#box2");
    var box3 = document.querySelector("#box3");

    s1.onclick = function(){
      box2.style.visibility = "visible";
      box3.style.visibility = "hidden";
    }
    s2.onclick = function(){
      box2.style.visibility = "hidden";
      box3.style.visibility = "visible";
    }
    s3.onclick = function(){
      box2.style.visibility = "visible";
      box3.style.visibility = "hidden";
    }
    s4.onclick = function(){
      box2.style.visibility = "hidden";
      box3.style.visibility = "visible";
    }
  }
</script>
</html>

