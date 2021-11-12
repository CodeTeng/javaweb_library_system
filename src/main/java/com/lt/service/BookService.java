package com.lt.service;

import com.lt.domain.Book;

import java.util.List;

/**
 * Author: lt
 * Date: 2021/10/18 - 20:15
 **/

/**
 * 书籍的业务接口---业务逻辑层
 */
public interface BookService {
    /**
     * 查询所有书籍信息
     * @return 书籍信息
     */
    List<Book> queryAllBooks();

    /**
     * 增加书籍信息
     * @param book
     */
    void addBook(Book book);

    /**
     * 删除书籍信息
     * @param id
     */
    void deleteBook(String id);

    /**
     * 批量删除书籍
     * @param ids
     */
    void delSelectedBook(String[] ids);

    /**
     * 根据id查询书籍
     * @param id
     * @return
     */
    Book queryBookById(String id);

    /**
     * 更改书籍信息
     * @param book
     */
    void updateBook(Book book);
}
