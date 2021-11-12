package com.lt.web.servlet; /**
 * Author: lt
 * Date: 2021/10/19 - 14:53
 **/

import com.lt.domain.Book;
import com.lt.service.BookService;
import com.lt.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookListServlet")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用BookService完成查询
        BookService service = new BookServiceImpl();
        List<Book> books = service.queryAllBooks();
        //将list存入request域中
        request.setAttribute("books", books);
        //3.转发到list.jsp页面中
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
