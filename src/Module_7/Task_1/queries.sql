USE `world_currencies`;

SELECT * FROM currency;

SELECT * FROM currency WHERE abbreviation = "EUR";

SELECT COUNT(*) FROM currency;

SELECT * FROM currency WHERE conversion = (SELECT MAX(conversion) FROM currency);