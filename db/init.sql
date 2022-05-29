DROP TABLE IF EXISTS  Products;

CREATE TABLE Products (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    price decimal(10,2) NOT NULL
);

INSERT INTO Products (name, price)
VALUES
    ("Apple", 1.25),
    ("Pear", 1.32),
    ("Banana", 0.99),
    ("Grape", 1.89),
    ("Orange", 1.20);

