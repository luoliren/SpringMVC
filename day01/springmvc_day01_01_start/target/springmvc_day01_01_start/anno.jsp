<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2020/3/6
  Time: 12:24
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>
    <a href="anno/testServletParam?name=哈哈">RequestParam</a>
    <br>

     <form action="anno/testRequestBody",method="post">

           用户姓名：<input type="text" name="uname" ><br>
           用户年龄：<input type="text" name="age" ><br>


           <input type="submit" value="提交">
     </form>
         <br>
         <a href="anno/testPathVariable/10">RequestParam</a>
         <br>
         <a href="anno/testRequestHeader">RequestHeader</a>
         <br>
         <a href="anno/testCookieValue">CookieValue</a>
         <br>

         <form action="anno/testModelAttribute",method="post">

             用户姓名：<input type="text" name="uname" ><br>
             用户年龄：<input type="text" name="age" ><br>
             <input type="submit" value="提交">
         </form>
    <br>
    <a href="anno/testSessionAttributes">SessionAttributes</a>
    <br>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <br>
    <a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>

</body>

</html>
