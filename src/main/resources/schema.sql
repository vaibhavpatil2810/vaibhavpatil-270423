CREATE TABLE customer (
	id BIGINT not null AUTO_INCREMENT,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	PRIMARY KEY (id)
);

CREATE TABLE mobile_number (
	id BIGINT not null AUTO_INCREMENT,
	number varchar(15) not null,
	customer_id BIGINT not null,
	PRIMARY KEY (id),
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE SEQUENCE customer_sequence START WITH 5 INCREMENT BY 1;