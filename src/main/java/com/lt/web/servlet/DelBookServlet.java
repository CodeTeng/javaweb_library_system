package com.lt.web.servlet; /**
 * Author: lt
 * Date: 2021/10/19 - 15:02
 **/

import com.lt.service.BookService;
import com.lt.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delBookServlet")
public class DelBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        BookService service = new BookServiceImpl();
        service.deleteBook(id);
        //3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/bookListServlet");
    }
}
