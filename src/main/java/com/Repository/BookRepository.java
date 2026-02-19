package com.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dto.BookSearchRequest;
import com.mapper.BookRowMapper;
import com.model.Book;

@Repository

public class BookRepository {
private JdbcTemplate jd;
@Autowired
public BookRepository(JdbcTemplate jd) {
	this.jd=jd;
}
public int addBook(Book b) {

    String sql = """
            INSERT INTO books(title, author, price, stock)
            VALUES(?,?,?,?)
            """;

    return jd.update(sql,
            b.getTitle(),
            b.getAuthor(),
            b.getPrice(),
            b.getStock()
           );
}

public List<Book> getBook(){
	String sql="select * from books";
	List<Book>st=jd.query(sql,new BookRowMapper());
	return st;
}

public Book getById(int id) {
    String sql = "SELECT * FROM books WHERE id = ?";
    try {
        return jd.queryForObject(sql, new BookRowMapper(), id);
    } catch (DataAccessException ex) {
        return null; 
    }
}
public int updateStock(int id, int stock){

    String sql = "UPDATE books SET stock=? WHERE id=?";

    return jd.update(sql, stock, id);
}
public int deleteBook(int id){

    String sql = "DELETE FROM books WHERE id=?";

    return jd.update(sql, id);
}

public List<Book> searchBooks(BookSearchRequest request){

    StringBuilder sql = new StringBuilder("SELECT * FROM books WHERE 1=1 ");
    List<Object> params = new ArrayList<>();

    // title search
    if(request.getTitle() != null && !request.getTitle().isEmpty()){
        sql.append(" AND LOWER(title) LIKE LOWER(?) ");
        params.add("%" + request.getTitle() + "%");
    }

    // author search
    if(request.getAuthor() != null && !request.getAuthor().isEmpty()){
        sql.append(" AND LOWER(author) LIKE LOWER(?) ");
        params.add("%" + request.getAuthor() + "%");
    }

    // category
    if(request.getCategory() != null && !request.getCategory().isEmpty()){
        sql.append(" AND category = ? ");
        params.add(request.getCategory());
    }

    // min price
    if(request.getMinPrice() != 0){
        sql.append(" AND price >= ? ");
        params.add(request.getMinPrice());
    }

    // max price
    if(request.getMaxPrice() != 0){
        sql.append(" AND price <= ? ");
        params.add(request.getMaxPrice());
    }

    // sorting
    if("price_asc".equals(request.getSortBy())){
        sql.append(" ORDER BY price ASC ");
    }
    else if("price_desc".equals(request.getSortBy())){
        sql.append(" ORDER BY price DESC ");
    }
    else{
        sql.append(" ORDER BY id DESC ");
    }

    // pagination
    int offset = request.getPage() * request.getSize();
    sql.append(" LIMIT ? OFFSET ? ");

    params.add(request.getSize());
    params.add(offset);

    return jd.query(sql.toString(),
            params.toArray(),
            new BookRowMapper());
}





}
