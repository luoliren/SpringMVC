package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
      //获取到异常对象
        SysException e =null;
        // e instanceof SysException：判断e的类型是否是SysException的类型，
        // 用于判断前面的对象是否是后面的类，或者其子类、实现类的实例。如果是返回true，否则返回false。
        if (e instanceof SysException){
            e = (SysException)ex;

        }else {
            e = new SysException("系统正在维护..");
        }
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //e.getMessage()作用是将UserContriller抛出的异常的信息
        // throw new SysException("查询所有的用户出现了错误。。")
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");//跳转的页面
        return mv;
    }
}
