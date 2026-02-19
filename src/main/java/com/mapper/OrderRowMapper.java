package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.model.Orders;

public class OrderRowMapper implements RowMapper<Orders>{

    @Override
    public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {

        Orders o = new Orders();

        o.setId(rs.getInt("id"));
        o.setCustomerId(rs.getInt("customer_id"));

        o.setOrderDate(
            rs.getTimestamp("order_date").toLocalDateTime()
        );

        o.setTotalPrice(rs.getDouble("total_price"));


        return o;
    }
}
