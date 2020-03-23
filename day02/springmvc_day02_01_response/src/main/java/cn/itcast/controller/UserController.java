package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回值String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setAge(30);
        user.setUsername("妹妹");
        user.setPassword("123");
        //model对象
        model.addAttribute("user",user);

        return "success";
    }

    /**
     * 返回值void
     * 请求转发一次请求，不用编写项目的名称
     * 重定向两次请求，要编写项目的名称
     * @param request
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了");
        //编写请求转发的程序
        /*手动转发，视图解析器不会别启动 需要自己手动填写跳转页面 */
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        /*如果执行跳转完后面还有代码，不想执行就可以直接写return*/

        //重定向request.getContextPath()项目名称
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //直接会进行响应
        response.getWriter().print("你好");
        return;
    }

    /**
     * 返回值ModelAndView
     * @param
     * @return
     */    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
         //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setAge(30);
        user.setUsername("小风");
        user.setPassword("12322");

        //把user对象存储到mv对象中，也会把user的对象存入到request域中
        mv.addObject("user",user);

        //跳转到那个页面 执行视图解析器
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了");

        //请求的转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @param
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody  User user) {
        System.out.println("testForwardOrRedirect执行了");
        //客户端发送ajax的请求，传的是json的字符串 ，后端把json字符串封装到user的对象中
        System.out.println(user);
        //做一个响应 模拟查询数据库
        user.setUsername("毒死阿达");
        user.setAge(40);
        user.setPassword("2323");
        //做响应
        return user;
    }

}
