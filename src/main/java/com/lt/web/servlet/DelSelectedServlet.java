package com.lt.web.servlet; /**
 * Author: lt
 * Date: 2021/10/19 - 15:12
 **/

import com.lt.service.BookService;
import com.lt.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有的id
        String[] ids = request.getParameterValues("uid");
        //2.调用service删除
        BookService service = new BookServiceImpl();
        service.delSelectedBook(ids);
        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/bookListServlet");
    }
}
