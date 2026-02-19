package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int row)throws SQLException{
    	Customer c=new Customer();
    	c.setId(rs.getInt("id"));
    	c.setName(rs.getString("name"));
    	c.setEmail(rs.getString("email"));
    	c.setPhone(rs.getString("phone"));
    	return c;
    }
    
}
