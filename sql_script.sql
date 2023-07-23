DROP DATABASE IF EXISTS pets;
CREATE DATABASE pets;
USE pets;

DROP TABLE IF EXISTS horses;
CREATE TABLE horses (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25),
    commands VARCHAR(100),
	birthday DATE
);
INSERT INTO horses (name, commands,  birthday)
VALUES ('Гарри', 'Говорить;Идти;Останавливаться', '2018-01-01'),
	('Хола', 'Говорить;Идти;Останавливаться', '2020-02-02'),
	('Джек', 'Говорить;Идти;Останавливаться', '2022-03-03');
    
DROP TABLE IF EXISTS camels;
CREATE TABLE camels (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25),
    commands VARCHAR(100),
	birthday DATE
);
INSERT INTO camels (name, commands,  birthday)
VALUES ('Первый', 'Говорить;Идти;Останавливаться;Сесть;Встать', '2017-01-01'),
	('Второй', 'Говорить;Идти;Останавливаться;Сесть;Встать', '2020-02-02'),
	('Третий', 'Говорить;Идти;Останавливаться;Сесть;Встать', '2023-03-03');
 
DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25),
    commands VARCHAR(100),
	birthday DATE
);
INSERT INTO donkeys (name, commands,  birthday)
VALUES ('Гриха', 'Говорить;Идти;Останавливаться;Стоять', '2015-01-01'),
	('Миха', 'Говорить;Идти;Останавливаться;Стоять', '2020-02-02'),
	('Виха', 'Говорить;Идти;Останавливаться;Стоять', '2021-03-03');

/*    
SELECT * FROM horses
UNION
SELECT * FROM camels
UNION
SELECT * FROM donkeys;
*/
-- Удаляем верблюдов

TRUNCATE camels;

/*
SELECT * FROM horses
UNION
SELECT * FROM camels
UNION
SELECT * FROM donkeys;
*/

-- Лошади и ослы в одну таблицу с сохранением признака животины
DROP TABLE IF EXISTS repository;
CREATE TABLE repository (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(25),
    old_id INT,
    name VARCHAR(25),
    commands VARCHAR(100),
	birthday DATE
);

INSERT INTO repository (type, old_id, name, commands,  birthday)
SELECT  "horses" AS type, id AS old_id, name, commands,  birthday
FROM horses;

INSERT INTO repository (type, old_id, name, commands,  birthday)
SELECT  "donkeys" AS type, id AS old_id, name, commands,  birthday
FROM donkeys;

SELECT * FROM repository;

DROP TABLE IF EXISTS youngsters;
CREATE TABLE youngsters (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(25),
    old_id INT,
    name VARCHAR(25),
    commands VARCHAR(100),
	birthday DATE
);

SET @now = NOW();
INSERT INTO youngsters (type, old_id, name, commands,  birthday)
SELECT  type, old_id, name, commands,  birthday
FROM repository
WHERE TIMESTAMPDIFF(MONTH, birthday, @now) BETWEEN 12 AND 35;

SELECT * FROM youngsters;