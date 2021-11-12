package com.lt.web.servlet; /**
 * Author: lt
 * Date: 2021/10/19 - 15:08
 **/

import com.lt.domain.Book;
import com.lt.service.BookService;
import com.lt.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findBookServlet")
public class FindBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service查询
        BookService service = new BookServiceImpl();
        Book book = service.queryBookById(id);
        //3.将book存入request域
        request.setAttribute("book", book);
        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
