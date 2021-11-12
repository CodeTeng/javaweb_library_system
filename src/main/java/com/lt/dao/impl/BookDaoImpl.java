package com.lt.dao.impl;

import com.lt.dao.BookDao;
import com.lt.domain.Book;
import com.lt.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Author: lt
 * Date: 2021/10/18 - 20:14
 **/
public class BookDaoImpl implements BookDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Book> queryAllBooks() {
        String sql = "select * from book";
        return template.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public void addBook(Book book) {
        String sql = "insert into book values(null,?,?,?,?,?,?,?,?)";
        template.update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getType(),book.getPdate(),book.getDescription(),book.getDetail(),book.getAddress());
    }

    @Override
    public void deleteBook(int id) {
        String sql = "delete from book where id = ?";
        template.update(sql, id);
    }

    @Override
    public Book queryBookById(int id) {
        String sql = "select * from book where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update book set name=?,price=?,author=?,type=?,pdate=?,description=?,detail=?,address=? where id=?";
        template.update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getType(),book.getPdate(),book.getDescription(),book.getDetail(),book.getAddress(),book.getId());
    }
}
