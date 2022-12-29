<%--
  Created by IntelliJ IDEA.
  User: 23179
  Date: 2022/12/7
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc_06</title>
</head>
<body>
<h1>文件上传</h1>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<br/>
</body>
</html>
