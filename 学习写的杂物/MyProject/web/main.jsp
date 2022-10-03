<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: haoge
  Date: 2021/11/6
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录成功</h1>
<button><a href="human?method=loginOut">注销</a></button>

<button><a href="human?method=clockBeginSuccess&name=${loginHuman.username}">上班打卡</a> </button>
<button><a href="human?method=clockEndSuccess&name=${loginHuman.username}">下班打卡</a> </button>
</body>
</html>
