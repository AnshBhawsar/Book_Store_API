-- USERS
INSERT INTO customers(name,email,phone)
VALUES
('Ansh Bhawsar','ansh@gmail.com','9999999999'),
('Rahul Sharma','rahul@gmail.com','8888888888');



-- BOOKS
INSERT INTO books(title,author,price,stock,category) VALUES
('Spring Boot Guide','Rod Johnson',499.00,10,'Programming'),
('Java Fundamentals','James Gosling',399.00,8,'Programming'),
('Database Design','Elmasri',599.00,5,'Database'),
('Clean Code','Robert Martin',699.00,7,'Software Engineering');


-- ORDERS
INSERT INTO orders(customer_id,total_price)
VALUES (1,898.00), (2,399.00);



-- ORDER ITEMS
INSERT INTO order_items(order_id,book_id,quantity,price) VALUES
(1,1,1,499.00),
(1,2,1,399.00),
(2,2,1,399.00);
