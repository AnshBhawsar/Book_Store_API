package com.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Repository.OrderItemRepository;
import com.Repository.OrderRepository;
import com.model.OrderItem;
import com.model.Orders;

public class Order_ItemsService {
	private OrderItemRepository repo;
	@Autowired
	public Order_ItemsService(OrderItemRepository repo) {
		this.repo=repo;
	}
	public int addItems(OrderItem o) {
		return repo.addItems(o);
	}
}
