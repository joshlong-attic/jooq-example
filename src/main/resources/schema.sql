drop TABLE IF EXISTS customer;
drop TABLE IF EXISTS product;

CREATE TABLE customer (
  id    BIGINT SERIAL PRIMARY KEY,
  email VARCHAR(255) NOT NULL
);

CREATE TABLE product (
  id          BIGINT SERIAL PRIMARY KEY,
  customer_id BIGINT      NOT NULL REFERENCES customer (id),
  sku         VARCHAR(10) NOT NULL
);