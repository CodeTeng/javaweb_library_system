package com.lt.web.servlet; /**
 * Author: lt
 * Date: 2021/10/19 - 15:05
 **/

import com.lt.domain.Book;
import com.lt.service.BookService;
import com.lt.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Book book = new Book();
        try {
            BeanUtils.populate(book, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service修改
        BookService service = new BookServiceImpl();
        service.updateBook(book);
        //5.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/bookListServlet");
    }
}
