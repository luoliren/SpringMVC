<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2020/3/5
  Time: 21:29
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数绑定 此处的/param/testParam 第一个/不用加 ，浏览器默认带着--%>

 <%--   <a href="param/testParam?username=haha&password=1234">请求参数绑定</a>--%>
    <%-- request.setChar--%>
<%--<form action="param/saveAccount",method="post">
    姓名：<input type="text" name="username" ><br>
    密码：<input type="text" name="password" ><br>
    金额：<input type="text" name="money" ><br>
    用户姓名：<input type="text" name="user.uname" ><br>
    用户年龄：<input type="text" name="user.age" ><br>
    <input type="submit" value="提交">

</form>--%>
    <%--把数据封装Account类中，类中存在list和map的集合--%>
<%--    <form action="param/saveAccount",method="post">
        姓名：<input type="text" name="username" ><br>
        密码：<input type="text" name="password" ><br>
        金额：<input type="text" name="money" ><br>

        用户姓名：<input type="text" name="list[0].uname" ><br>
        用户年龄：<input type="text" name="list[0].age" ><br>

        用户姓名：<input type="text" name="map['one'].uname" ><br>
        用户年龄：<input type="text" name="map['one'].age" ><br>
        <input type="submit" value="提交">
    </form>
    --%>
    <%--自定义类型转换器--%>
    <%--<form action="param/saveUser",method="post">

        用户姓名：<input type="text" name="uname" ><br>
        用户年龄：<input type="text" name="age" ><br>
        用户生日：<input type="text" name="date" ><br>

        <input type="submit" value="提交">--%>
        <a href="param/testServlet">Servlet原生态api</a>
    </form>
</body>
</html>
