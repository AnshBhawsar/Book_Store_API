package com.mapper;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import com.model.OrderItem;

public class Order_ItemRowMapper implements RowMapper<OrderItem>{

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum)throws SQLException{

        OrderItem o = new OrderItem();

        o.setId(rs.getInt("id"));
        o.setOrder_id(rs.getInt("order_id"));
        o.setBook_id(rs.getInt("book_id"));
        o.setQuantity(rs.getInt("quantity"));
        o.setPrice(rs.getDouble("price"));

        return o;
    }
}
