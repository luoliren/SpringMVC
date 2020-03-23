<%--
  Created by IntelliJ IDEA.
  User: 18400
  Date: 2020/3/10
  Time: 11:25
 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js">
    </script>
    <script>
        //页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                alert("hello world");
                //发送一个ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",/*表示后台的请求方法，后台需要提供这么一个方法*/
                    contentType:"application/json;charset=UTF-8",//发送服务器编码的类型json类型
                    data:'{"username":"hehe","password":"123","age":"12"}',/*发送到服务器的数据*/
                    dataType:"json"/*预期服务器返回的数据类型*/,
                    type:"post",//请求类型
                    success:function (data) {
                        //data服务器端响应的json的数据，把服务器段的数据data拿到进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);


                    }//处理函数
                })
            });
        });
    </script>
</head>
<body>
<a href="user/testString">testString</a>
<br>
<a href="user/testVoid">testVoid</a>
<br>

<a href="user/testModelAndView">testModelAndView</a>
<br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
<br>
<button id="btn">发送ajax的请求</button>
</body>
</html>
