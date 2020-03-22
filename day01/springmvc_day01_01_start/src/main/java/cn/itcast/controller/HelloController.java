package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    /* @RequestMapping(path = "/hello") 建立请求URL和处理请求方法之间的对应关系 可以放在类和方法上 形成相应的模块，结构清晰*/
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     *  属性： value 和path的作用一样
     *  一个属性 可以省略 value path
     *          value 可以省略
     *          method : 用于指定请求方式
     *          params = {"username"} :指的是请求时必须传一个username的属性，否则报错
     *           <a href="user/testRequestMapping">RequestMapping 注解</a>
     *          params = {"username=haha"} :指的是请求时必须传一个username的属性，且属性username必须等于haha，否则报错
     *           <a href="user/testRequestMapping?username=haha">RequestMapping 注解</a>
     *           headers：用于指定限制请求头的条件 发送的请求中必须包含的请求头
     *
     *
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",params = {"username=haha"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解。。");
        return "success";
    }
}
