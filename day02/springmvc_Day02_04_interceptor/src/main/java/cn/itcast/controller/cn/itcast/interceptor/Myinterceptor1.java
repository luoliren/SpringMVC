package cn.itcast.controller.cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class Myinterceptor1 implements HandlerInterceptor {
    /**
     * 预处理：controller方法执行前执行
     * return ture放行，执行下一个拦截器，如果没有执行controller中的方法
     * return false不放行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Myinterceptor1执行了。。。前");
       /*
       在controller的方法执行之前执行，不放行，直接跳转到/WEB-INF/pages/error.jsp
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return false;
        */
        return true;
    }

    /**
     * 后处理：controller方法执行后执行 success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @param
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Myinterceptor1执行了。。后");
        /*执行流程  预处理 -- controller --后处理 -- /WEB-INF/pages/error.jsp --不再执行success.jsp */
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    /**
     * success.jsp页面执行后，该方法会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     * 跳不不了其他的页面
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Myinterceptor1执行了。。最后");
    }
}