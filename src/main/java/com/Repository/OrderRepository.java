package com.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mapper.OrderRowMapper;
import com.model.Orders;

@Repository
public class OrderRepository {

    private final JdbcTemplate jd;

    public OrderRepository(JdbcTemplate jd){
        this.jd = jd;
    }

    // ⭐ CREATE ORDER
    public int createOrder(int customerId, double totalAmount){

        String sql = """
            INSERT INTO orders(customer_id, order_date, total_amount)
            VALUES(?, CURRENT_TIMESTAMP, ?)
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jd.update(connection -> {

            PreparedStatement ps =
                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, customerId);
            ps.setDouble(2, totalAmount);

            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    // ⭐ GET ORDERS BY CUSTOMER
    public List<Orders> getOrdersByCustomer(int customerId){

        String sql = """
            SELECT *
            FROM orders
            WHERE customer_id=?
            ORDER BY order_date DESC
            """;

        return jd.query(sql, new OrderRowMapper(), customerId);
    }
}
