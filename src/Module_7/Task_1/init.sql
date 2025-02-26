DROP DATABASE IF EXISTS `world_currencies`;
CREATE DATABASE `world_currencies` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `world_currencies`;

CREATE TABLE CURRENCY (
	abbreviation CHAR(3) NOT NULL,
	name VARCHAR(50) NOT NULL,
	conversion DECIMAL(12, 9) NOT NULL,
	symbol VARCHAR(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
	PRIMARY KEY (abbreviation)
);

INSERT INTO CURRENCY (abbreviation, name, conversion, symbol) VALUES
("EUR", "Euro", 1.04, "€"),
("USD", "US Dollar", 1, "$"),
("PLN", "Polish Zloty", 0.25, "zł"),
("JPY", "Japanese Yen", 0.0065, "¥"),
("RUB", "Russian Ruble", 0.011, "₽"),
("CNY", "Chinese Yuan", 0.14, "¥"),
("INR", "Indian Rupee", 0.012, "₹"),
("GBP", "British Pound", 1.25, "£"),
("AUD", "Australian Dollar", 0.72, "$"),
("CAD", "Canadian Dollar", 0.74, "$"),
("BRL", "Brazilian Real", 0.19, "R$"),
("MXN", "Mexican Peso", 0.051, "$"),
("KRW", "South Korean Won", 0.00085, "₩"),
("SEK", "Swedish Krona", 0.11, "kr");

DROP USER IF EXISTS "appuser"@"localhost";
CREATE USER "appuser"@"localhost" IDENTIFIED BY "password";
GRANT SELECT ON `world_currencies`.* TO 'appuser'@'localhost';