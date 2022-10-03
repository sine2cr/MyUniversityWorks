<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: haoge
  Date: 2021/11/20
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>显示所有信息</h1>
<table>
    <tr>
        <th>姓名</th>
        <th>begin</th>
        <th>end</th>
    </tr>
    <c:forEach items="${list}" var="ct">
        <tr>
            <td>${ct.c_name}</td>
            <td>${ct.beginTime}</td>
            <td>${ct.endTime}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="center">
            <a href="mmm?method=showClockTime&pageIndex=1">首页</a>
            <c:if test="${page.pageIndex > 1}">
                <a href="mmm?method=showClockTime&pageIndex=${page.pageIndex - 1}">上一页</a>
            </c:if>
            <c:if test="${page.pageIndex == 1}">
                <a>上一页</a>
            </c:if>
            <c:if test="${page.pageIndex < page.totalPages}">
                <a href="mmm?method=showClockTime&pageIndex=${page.pageIndex + 1}">下一页</a>
            </c:if>
            <c:if test="${page.pageIndex == page.totalPages}">
                <a>下一页</a>
            </c:if>
            <a  href="mmm?method=showClockTime&pageIndex=${page.totalPages}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
