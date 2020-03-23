<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2020/3/10
  Time: 15:38
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>传统文件上传</h3>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>
    <br>
    <br>
    <h3>SpringMvc文件上传</h3>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>
    <br>
    <br>
    <h3>跨服务器文件上传</h3>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
