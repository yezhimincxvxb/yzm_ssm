<%--
  Created by IntelliJ IDEA.
  User: 23179
  Date: 2022/12/6
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/receiver" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    爱好:
    <input type="checkbox" name="hobby" value="足球" checked>
    <input type="checkbox" name="hobby" value="篮球">
    <input type="checkbox" name="hobby" value="网球"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
