package com.lt.web.servlet; /**
 * Author: lt
 * Date: 2021/10/19 - 15:19
 **/

import com.lt.domain.Book;
import com.lt.domain.PageBean;
import com.lt.service.PageService;
import com.lt.service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findBookByPageServlet")
public class FindBookByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");   //当前页码
        String rows = request.getParameter("rows");     //每页显示的条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //2.调用service查询
        PageService service = new PageServiceImpl();
        PageBean<Book> pb = service.findBookByPage(currentPage, rows, condition);

        //3.将PageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition);   //将查询条件存入request
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
