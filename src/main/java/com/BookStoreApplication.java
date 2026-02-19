package com;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.Service.BookService;
import com.Service.OrderService;
import com.dto.BookSearchRequest;
import com.dto.ORderREsponce;
import com.model.Book;
@SpringBootApplication
public class BookStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
        
	}
}
