DROP TABLE IF EXISTS  Products;

CREATE TABLE Products (
    id int PRIMARY KEY,
    name varchar(50) NOT NULL
);

INSERT INTO Products (id, name)
VALUES (1, "Amazing product");