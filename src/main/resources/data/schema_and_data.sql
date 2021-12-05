-- DATABASE
CREATE DATABASE IF NOT EXISTS hex_db;
USE hex_db;

-- TABLES
CREATE TABLE `customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) NOT NULL,
  `last_name` VARCHAR(64) NOT NULL,
  `address` VARCHAR(255) NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE `product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `customer_id` INT UNSIGNED NOT NULL,
  `catalog_name` VARCHAR(255) NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_product_customer_id_key_idx` (`customer_id` ASC),
  CONSTRAINT `fk_product_customer_id_key`
    FOREIGN KEY (`customer_id`)
    REFERENCES `hex_db`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- SEEDS
INSERT INTO `customer` (first_name, last_name, address) VALUES
('Heril', 'Muratovic', 'Test address 01'),
('John', 'Wick', '121 Mill Neck in Long Island, NY');

INSERT INTO `product` (customer_id, catalog_name, price) VALUES
((SELECT id FROM customer WHERE first_name = 'Heril' AND last_name = 'Muratovic' LIMIT 1), 'SIG-Sauer P320', 1560.12),
((SELECT id FROM customer WHERE first_name = 'John' AND last_name = 'Wick' LIMIT 1), 'Coharie Arms CA-415', 3500.00);