package com.Repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.CustomerRowMapper;
import com.model.Customer;


@Repository
public class customerREpository {
private JdbcTemplate jd;
public customerREpository(JdbcTemplate jd) {
this.jd=jd;	
}
public int addCustomer(Customer c) {
	String sql = """
            INSERT INTO customers(name, email, phone)
            VALUES(?,?,?)
            """;
	 return jd.update(sql,c.getName(),c.getEmail(),c.getPhone());
	
}
public Customer getById(int id) {
	String sql="select * from customers where id=?";
	try {
		return jd.queryForObject(sql,new CustomerRowMapper(),id);
	}
	catch(DataAccessException s) {
		return null;
	}
}


}
