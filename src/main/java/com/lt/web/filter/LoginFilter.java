package com.lt.web.filter; /**
 * Author: lt
 * Date: 2021/10/21 - 19:15
 **/

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest req = (HttpServletRequest) request;

        //1.获取资源请求路径
        String uri = req.getRequestURI();
        //2.判断是否包含登录相关资源路径
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet") || uri.contains("/img/")) {
            //包含，用户就是想登录，放行
            chain.doFilter(request, response);
        } else {
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            Object user = req.getSession().getAttribute("user");
            if (user != null) {
                //登录了。方向
                chain.doFilter(request, response);
            } else {
                //没有登录。跳转登录页面
                req.setAttribute("login_msg", "你尚未登录，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req, response);
            }
        }
    }
}
