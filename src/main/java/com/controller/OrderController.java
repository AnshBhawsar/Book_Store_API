package com.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exception.BookNotFoundException;
import com.Service.OrderService;
import com.dto.ORderREsponce;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // ⭐ PLACE ORDER (TRANSACTION MAGIC)
    @PostMapping("/place")
    public String placeOrder(@RequestParam int customerId,
                             @RequestParam int bookId,
                             @RequestParam int quantity) throws BookNotFoundException{

        service.placeHandle(customerId, bookId, quantity);

        return "Order Placed Successfully!";
    }

    // ⭐ VIEW ORDERS WITH ITEMS
    @GetMapping("/{customerId}")
    public List<ORderREsponce> getOrders(@PathVariable int customerId){

        return service.getOrdersWithItems(customerId);
    }
}
