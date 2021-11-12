package com.lt.dao;

import com.lt.domain.Book;

import java.util.List;

/**
 * Author: lt
 * Date: 2021/10/18 - 20:13
 **/

/**
 * 操作书籍总信息的DAO---数据访问层
 */
public interface BookDao {
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
    void deleteBook(int id);

    /**
     * 根据id查询书籍
     * @param id
     * @return
     */
    Book queryBookById(int id);

    /**
     * 更改书籍信息
     * @param book
     */
    void updateBook(Book book);
}
