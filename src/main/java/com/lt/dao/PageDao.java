package com.lt.dao;

import com.lt.domain.Book;

import java.util.List;
import java.util.Map;

/**
 * Author: lt
 * Date: 2021/10/19 - 9:41
 **/
public interface PageDao {
    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Book> findByPage(int start, int rows, Map<String, String[]> condition);
}
