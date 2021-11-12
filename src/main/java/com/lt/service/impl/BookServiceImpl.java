package com.lt.service.impl;

import com.lt.dao.BookDao;
import com.lt.dao.impl.BookDaoImpl;
import com.lt.domain.Book;
import com.lt.service.BookService;

import java.util.List;

/**
 * Author: lt
 * Date: 2021/10/18 - 20:15
 **/
public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();

    @Override
    public List<Book> queryAllBooks() {
        return dao.queryAllBooks();
    }

    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }

    @Override
    public void deleteBook(String id) {
        dao.deleteBook(Integer.parseInt(id));
    }

    @Override
    public void delSelectedBook(String[] ids) {
        if (ids != null && ids.length > 0) {
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.deleteBook(Integer.parseInt(id));
            }
        }
    }

    @Override
    public Book queryBookById(String id) {
        return dao.queryBookById(Integer.parseInt(id));
    }

    @Override
    public void updateBook(Book book) {
        dao.updateBook(book);
    }


}
