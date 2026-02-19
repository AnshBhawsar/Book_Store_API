package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exception.BookNotFoundException;
import com.Repository.BookRepository;
import com.Repository.OrderItemRepository;
import com.Repository.OrderRepository;
import com.Repository.customerREpository;
import com.dto.ORderREsponce;
import com.model.Book;
import com.model.Customer;
import com.model.OrderItem;
import com.model.Orders;
@Service
public class OrderService {
private BookRepository Brepo;
private customerREpository Crepo;
private OrderItemRepository OIrepo;
private OrderRepository Orepo;
@Autowired
public OrderService(BookRepository Brepo,customerREpository Crepo,OrderItemRepository OIrepo,OrderRepository Orepo) {
	this.Brepo=Brepo;
	this.Crepo=Crepo;
	this.OIrepo=OIrepo;
	this.Orepo=Orepo;
}

@Transactional
public void placeHandle(int customer_Id, int Book_Id, int Quantity) throws BookNotFoundException {
	if(Quantity<=0) {
		throw new IllegalArgumentException("Quantity must be Grther than 0");
	}
	Customer c=Crepo.getById(customer_Id);
	if(c==null) {
		throw new IllegalArgumentException("Customer is not exist");
	}
	
	Book b=Brepo.getById(Book_Id);
	if(b==null) {
		throw new BookNotFoundException("Book not found"+Book_Id);
	}
	
	if(b.getStock()<=Quantity) {
		throw new BookNotFoundException("Stock must be grether than quantity");
	}
	
	//Total price
	Double total=b.getPrice()*Quantity;
	
	//crete Order
	int order_id=Orepo.createOrder(customer_Id, total);
	OrderItem oi=new OrderItem();
	oi.setOrder_id(order_id);
	oi.setBook_id(Book_Id);
	oi.setQuantity(Quantity);
	oi.setPrice(b.getPrice());
	
	OIrepo.addItems(oi);
	
	
	//reduce stock
	int currentStock=b.getStock()-Quantity;
	Brepo.updateStock(Book_Id, currentStock);
	
}
public  List<ORderREsponce> getOrdersWithItems(int customer_id) {
	//1 
	List<Orders>orderList=Orepo.getOrdersByCustomer(customer_id);
	//2
	List<ORderREsponce>orderresponse=new ArrayList<>();
	//3
	for(Orders o:orderList) {
		List<OrderItem>orderitem=OIrepo.getOrdersByOrderID(o.getId());
		ORderREsponce dto=new ORderREsponce(o,orderitem);
		orderresponse.add(dto);
		
	}
	
	
	
	
	return orderresponse;
}




	
}
