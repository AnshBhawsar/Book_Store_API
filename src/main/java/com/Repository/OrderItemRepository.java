package com.Repository;
import java.util.List;
import com.mapper.Order_ItemRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.OrderItem;

@Repository
public class OrderItemRepository {

    private final JdbcTemplate jd;

    public OrderItemRepository(JdbcTemplate jd) {
        this.jd = jd;
    }

    public int addItems(OrderItem o) {

        String sql = """
            INSERT INTO order_items(order_id, book_id, quantity, price)
            VALUES (?, ?, ?, ?)
            """;

        return jd.update(sql,
                o.getOrder_id(),
                o.getBook_id(),
                o.getQuantity(),
                o.getPrice());
    }

    public List<OrderItem> getOrdersByOrderID(int orderId){

        String sql = """
            SELECT *
            FROM order_items
            WHERE order_id=?
            """;

        return jd.query(sql, new Order_ItemRowMapper(), orderId);
    }
}
