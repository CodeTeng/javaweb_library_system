package com.lt.service.impl;

import com.lt.dao.PageDao;
import com.lt.dao.impl.PageDaoImpl;
import com.lt.domain.Book;
import com.lt.domain.PageBean;
import com.lt.service.PageService;

import java.util.List;
import java.util.Map;

/**
 * Author: lt
 * Date: 2021/10/19 - 9:40
 **/
public class PageServiceImpl implements PageService {
    private PageDao dao = new PageDaoImpl();

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        return dao.findTotalCount(condition);
    }

    @Override
    public PageBean<Book> findBookByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<Book> pb = new PageBean<>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Book> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        //5.计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);

        if (currentPage >= totalPage) {
            currentPage = totalPage;
            pb.setCurrentPage(currentPage);
        }
        return pb;
    }
}
