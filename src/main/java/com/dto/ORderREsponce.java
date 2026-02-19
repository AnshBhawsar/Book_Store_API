package com.dto;

import java.util.List;

import com.model.OrderItem;
import com.model.Orders;

import lombok.Data;
@Data
public class ORderREsponce {
private Orders o;
private List<OrderItem>oi;
public ORderREsponce(Orders o, List<OrderItem> oi) {
	super();
	this.o = o;
	this.oi = oi;
}

}
