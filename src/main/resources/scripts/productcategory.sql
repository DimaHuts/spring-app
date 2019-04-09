ALTER TABLE product_category RENAME COLUMN category_name TO name;

INSERT INTO product_category (id, name)
VALUES (2, 'TV')