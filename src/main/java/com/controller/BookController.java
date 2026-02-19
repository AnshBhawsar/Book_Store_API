package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.BookService;
import com.dto.BookSearchRequest;
import com.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
private BookService bk;
@Autowired
public BookController(BookService bk) {
	this.bk=bk;
}
@PostMapping("/addBook")
public String addBook(@RequestBody Book b) {
	bk.addBook(b);
	return "Data is added succesfully";
  
}
@GetMapping("/getBook")
public List<Book> getBook(){
return bk.getBook();
}
@GetMapping("/{id}")
public Book getById(@PathVariable int id) {
    return bk.getById(id);
}
@PutMapping("/{id}/stock")
public String  updateStock(@PathVariable int id, @RequestParam int stock){
	 bk.updateStock(id, stock);
	 return "Data is updated successfully";
	
}
@DeleteMapping("/{id}")
public String  deleteBook(@PathVariable int id){
	 bk.deleteBook(id);
	 return "Data is delete successfully";
}
@PostMapping("/search")
public List<Book> searchBooks(@RequestBody BookSearchRequest request){
	return bk.searchBooks(request);
}





}
