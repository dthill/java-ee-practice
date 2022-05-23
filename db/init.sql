DROP TABLE IF EXISTS  Products;

CREATE TABLE Products (
    id int PRIMARY KEY,
    name varchar(50) NOT NULL
);

INSERT INTO Products (id, name)
VALUES (1, "Apple");


INSERT INTO Products (id, name)
VALUES (2, "Pear");

INSERT INTO Products (id, name)
VALUES (3, "Banana");

INSERT INTO Products (id, name)
VALUES (4, "Grape");

INSERT INTO Products (id, name)
VALUES (5, "Orange");

INSERT INTO Products (id, name)
VALUES (6, "Pineapple");

INSERT INTO Products (id, name)
VALUES (7, "Peach");

INSERT INTO Products (id, name)
VALUES (8, "Appricot");

INSERT INTO Products (id, name)
VALUES (9, "Melon");

INSERT INTO Products (id, name)
VALUES (10, "Grapefruit");
