package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//现在在类上加上注解就等于把msg=meimei存入到session域对象中 //存入session域用于方法参数的共享
public class AnnoController {

    @RequestMapping("/testServletParam")
                                    /*@RequestParam(name = "name") 把请求中的指定名称的参数给控制器中的形参赋值 把请求
                                     中的name属性的值赋给参数username  注解中的name和value属性作用一样 是请求参数的名称
                                      required：默认值是true 请求参数中必须提供注解中name或value中的值的参数 否则报错*/
    public  String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println(username);
        System.out.println("执行了");
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
                        /*@RequestBody String body 用于获取请求体的内容，直接使用得到是键值对结构的数据
                            只适用post请求 */
    public  String testRequestBody(@RequestBody String body){
        System.out.println(body);
        System.out.println("执行了");
        return "success";
    }

    /**
     * PathVariable注解
     * @param
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
                /*@PathVariable(name = "sid") 注解 用于绑定url中的占位符 name属性的值应和
                  @RequestMapping("/testPathVariable/{sid}")中的{sid}保持一致 请求url
                  <a href="anno/testPathVariable/10">RequestParam</a> 是这种格式 */
    public  String testPathVariable( @PathVariable(name = "sid") String id){
        System.out.println(id);
        System.out.println("执行了");
        return "success";
    }

    /**
     * RequestHeader注解 获取请求头的值 一般不用
     * @param
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public  String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        System.out.println("执行了");
        return "success";
    }

    /**
     * 获取Cookie的值 用的少
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public  String testCookieValue( @CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        System.out.println("执行了");
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public  String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println(user);
        System.out.println("执行了");
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);

    }
    /**
     * ModelAttribute注解
     * @return
     *//*
    @RequestMapping("/testModelAttribute")
    public  String testModelAttribute(User user){
        System.out.println(user);
        System.out.println("执行了");
        return "success";
    }

    *//**
     * 该方法会先执行
     * @param uname
     * @return
     *//*

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * SessionAttributes的注解
     * @param
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public  String testSessionAttributes(Model model){

        System.out.println("testSessionAttributes执行了");
        /*底层会存储到request域对象中 在jsp中用EL表达式    ${requestScope}获取所有request中的对象   ${msg}只获取 msg的Value值
        获取到页面上
        <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
        isELIgnored="false" 要配置上*/
        model.addAttribute("msg","meimei");
        return "success";
    }

    /**
     * 从session域中获取值
     * @param model
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public  String getSessionAttributes(ModelMap model){

        System.out.println("getSessionAttributes执行了");
        String msg = (String)model.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除Session域
     * @param status
     * @return
     */
    @RequestMapping("/deleteSessionAttributes")
    public  String deleteSessionAttributes(SessionStatus status){

        System.out.println("deleteSessionAttributes执行了");
        status.setComplete();
        return "success";
    }

}
