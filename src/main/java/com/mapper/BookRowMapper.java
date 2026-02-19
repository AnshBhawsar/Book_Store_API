package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.model.Book;
@Component
public class BookRowMapper implements RowMapper<Book> {
@Override
public Book mapRow(ResultSet rs,int rowCount)throws SQLException{
	Book b=new Book();
	b.setId(rs.getInt("id"));
    b.setTitle(rs.getString("title"));
    b.setAuthor(rs.getString("author"));
    b.setPrice(rs.getDouble("price"));
    b.setStock(rs.getInt("stock"));

    return b;
}
}
