-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE products (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
title varchar(255) NOT NULL,
price BIGINT
);
-- END
