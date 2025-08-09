package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Book book) {
        String sql = "INSERT INTO book (title, author) VALUES (?, ?)";
        return jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Book b = new Book();
            b.setId(rs.getInt("id"));
            b.setTitle(rs.getString("title"));
            b.setAuthor(rs.getString("author"));
            return b;
        }, id);
    }
}
