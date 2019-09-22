<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>区域信息</center>
<%--<table>
    <tr>
        <td>编号</td>
        <td>区域名称</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
        </tr>
    </c:forEach>
</table>--%>


渊总的详细资料,想牵手，等你来约<hr/>
学号:${stu.num}<br/>
姓名:${stu.name}<br/>
年龄:${stu.age}<br/>
</body>
</html>
