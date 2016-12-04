CREATE TABLE product(
id IDENTITY,
name varchar(50) NOT NULL,
brand varchar(50) NOT NULL,
category varchar(50) NOT NULL,
description varchar(50) NOT NULL,
price decimal(10,2) NOT NULL,
quantity int(10) NOT NULL,
CONSTRAINT pk_product_id PRIMARY KEY(id)
);

INSERT INTO product (name,brand,category,description,price,quantity) VALUES
('Iphone 5S', 'Apple', 'Mobile','This is a mobile',12000,8);

INSERT INTO product (name,brand,category,description,price,quantity) VALUES
('Note 3', 'Samsung', 'Mobile','This is a mobile',20000,10);
