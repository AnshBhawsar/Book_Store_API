package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.BookRepository;
import com.dto.BookSearchRequest;
import com.model.Book;
@Service
public class BookService {
private BookRepository repo;
@Autowired
public BookService(BookRepository repo) {
	this.repo=repo;
}

public void addBook(Book b) {
	if(b.getPrice()<=0) {
		throw new IllegalArgumentException("Price must be grether than 0");
	}
	if(b.getPrice()<0) {
		throw new IllegalArgumentException("price can ot be negative");
	}
	repo.addBook(b);
}
public List<Book> getBook(){
	return repo.getBook();
}
public Book getById(int id) {
	if(id<=0) {
		throw new IllegalArgumentException("invalid id");
		
	}
	return repo.getById(id);
}
public int updateStock(int id, int stock){
	if(id<=0|| stock<=0) {
		throw new IllegalArgumentException("Enter Valid Value");
	}
return	repo.updateStock(id, stock);
}
public int deleteBook(int id){
	if(id<=0) {
		throw new IllegalArgumentException("invalid id "); 
	}
return 	repo.deleteBook(id);
}

public  List<Book> searchBooks(BookSearchRequest request){
	return repo.searchBooks(request);
}

}
