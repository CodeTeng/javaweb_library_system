package com.lt.service;

import com.lt.domain.Book;
import com.lt.domain.PageBean;

import java.util.Map;

/**
 * Author: lt
 * Date: 2021/10/19 - 9:40
 **/
public interface PageService {
    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Book> findBookByPage(String currentPage, String rows, Map<String, String[]> condition);
}
