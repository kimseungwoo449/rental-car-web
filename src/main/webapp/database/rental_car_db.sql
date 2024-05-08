CREATE DATABASE rental_car_db;
USE rental_car_db;

SHOW TABLES;
DROP DATABASE rental_car_db;
CREATE TABLE users(
	`user_id` VARCHAR(20) PRIMARY KEY,
    `email` VARCHAR(40) UNIQUE CHECK(`email` REGEXP '^[0-9a-zA-Z]{4,20}@[a-z]{3,10}.(com|co.kr)$'),
	`resident_no` VARCHAR(14) NOT NULL UNIQUE CHECK(`resident_no` REGEXP '^[0-9]{6}-[0-9]{7}$'),
	`phone` VARCHAR(13) NOT NULL UNIQUE CHECK(`phone` REGEXP '^[0-9]{3}-[0-9]{4}-[0-9]{4}$'),
    `password` VARCHAR(20) NOT NULL,
    `gender` CHAR(1) NOT NULL CHECK(`gender` IN ('M','F')),
    `name` VARCHAR(15) NOT NULL,
	`reg_date` DATETIME NOT NULL DEFAULT(NOW()),
	`mod_date` DATETIME NOT NULL DEFAULT(NOW())
);

SELECT * FROM users;

ALTER TABLE users ADD COLUMN `is_admin` TINYINT NOT NULL DEFAULT(false);
alter table users modify column `password` VARCHAR(100) NOT NULL;

CREATE TABLE post(
	`post_no` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` VARCHAR(20),
    `title` VARCHAR(30) NOT NULL,
    `contents` VARCHAR(200) NOT NULL,
    `admin_comment` VARCHAR(100),
    `is_commented` TINYINT DEFAULT(false),
    `post_date` DATETIME NOT NULL DEFAULT(NOW()),
    `mod_date` DATETIME NOT NULL DEFAULT(NOW()),
    `is_notice` TINYINT NOT NULL,
    FOREIGN KEY(`user_id`) REFERENCES users(`user_id`)
)AUTO_INCREMENT 1;

ALTER TABLE post MODIFY COLUMN `is_notice` TINYINT NOT NULL DEFAULT(false);

INSERT INTO post(`user_id`,`title`,`contents`) VALUES('ehdanf449','1','11');
INSERT INTO post(`user_id`,`title`,`contents`) VALUES('ehdanf449','2','22');
INSERT INTO post(`user_id`,`title`,`contents`) VALUES('ehdanf449','3','33');
INSERT INTO post(`user_id`,`title`,`contents`) VALUES('ehdanf449','4','44');
INSERT INTO post(`user_id`,`title`,`contents`) VALUES('ehdanf449','5','55');

INSERT INTO post (`user_id`, `title`, `contents`, `is_notice`)
VALUES 
    ('user1', 'First Post', 'This is the content of the first post.', 1),
    ('user2', 'Second Post', 'This is the content of the second post.', 0),
    ('user3', 'Third Post', 'This is the content of the third post.', 0),
    ('user1', 'Fourth Post', 'This is the content of the fourth post.', 0),
    ('user2', 'Fifth Post', 'This is the content of the fifth post.', 1),
    ('user3', 'Sixth Post', 'This is the content of the sixth post.', 0),
    ('user1', 'Seventh Post', 'This is the content of the seventh post.', 0),
    ('user2', 'Eighth Post', 'This is the content of the eighth post.', 0),
    ('user3', 'Ninth Post', 'This is the content of the ninth post.', 1),
    ('user1', 'Tenth Post', 'This is the content of the tenth post.', 0),
    ('user2', 'Eleventh Post', 'This is the content of the eleventh post.', 0),
    ('user3', 'Twelfth Post', 'This is the content of the twelfth post.', 1),
    ('user1', 'Thirteenth Post', 'This is the content of the thirteenth post.', 0),
    ('user2', 'Fourteenth Post', 'This is the content of the fourteenth post.', 0),
    ('user3', 'Fifteenth Post', 'This is the content of the fifteenth post.', 1),
    ('user1', 'Sixteenth Post', 'This is the content of the sixteenth post.', 0),
    ('user2', 'Seventeenth Post', 'This is the content of the seventeenth post.', 0),
    ('user3', 'Eighteenth Post', 'This is the content of the eighteenth post.', 1),
    ('user1', 'Nineteenth Post', 'This is the content of the nineteenth post.', 0),
    ('user2', 'Twentieth Post', 'This is the content of the twentieth post.', 0);
    
CREATE TABLE reservation(
	`user_id` VARCHAR(20),
    `car_no` VARCHAR(10) CHECK(`car_no` REGEXP '^[0-9]{2,3}(하|허|호){1}[0-9]{4}$'),
    `is_returned` INT AUTO_INCREMENT PRIMARY KEY,
    `rental_date` DATETIME NOT NULL,
	`return_date` DATETIME NOT NULL,
    `resev_date` DATETIME NOT NULL DEFAULT(NOW()),
    `resev_mod_date` DATETIME NOT NULL DEFAULT(NOW()),
	FOREIGN KEY(`user_id`) REFERENCES users(`user_id`),
	FOREIGN KEY(`car_no`) REFERENCES cars(`car_no`)
)AUTO_INCREMENT 1;


CREATE TABLE cars(
	`car_no` VARCHAR(10) PRIMARY KEY CHECK(`car_no` REGEXP '^[0-9]{2,3}(하|허|호){1}[0-9]{4}$'),
    `cate_no` INT,
    `car_name` VARCHAR(30) NOT NULL,
    `car_age` INT NOT NULL,
    `passengers_no` INT NOT NULL,
    `fuel_type` VARCHAR(8) NOT NULL CHECK(fuel_type IN ('gasoline','diesel','gas')),
	`hourly_rental_price` INT NOT NULL,
    FOREIGN KEY(`cate_no`) REFERENCES categories(`cate_no`)
);
DROP TABLE cars;
SELECT * FROM cars;

INSERT INTO cars(`car_no`,`cate_no`,`car_name`,`car_age`,`passengers_no`,`fuel_type`,`hourly_rental_price`) 
VALUES('10하0001',1001,'쉐보레 스파크',2021,5,'gasoline',6900);
INSERT INTO cars VALUES('00하0002',1001,'쉐보레 스파크',2023,5,'gasoline',7200);
INSERT INTO cars VALUES('00하0003',1001,'기아 모닝',2021,5,'gasoline',7300);
INSERT INTO cars VALUES('00하0004',1001,'기아 레이',2022,5,'gasoline',7400);
INSERT INTO cars VALUES('00하0005',1000,'기아 K3',2020,5,'gasoline',7000);
INSERT INTO cars VALUES('00하0006',1000,'기아 K3',2021,5,'gasoline',7200);
INSERT INTO cars VALUES('00하0007',1000,'기아 K3',2021,5,'gasoline',7200);
INSERT INTO cars VALUES('00하0008',1001,'현대 캐스퍼',2023,4,'gasoline',7500);
INSERT INTO cars VALUES('00하0009',1001,'현대 캐스퍼',2022,4,'gasoline',7000);
INSERT INTO cars VALUES('00하0010',1000,'현대 아반떼',2020,5,'gas',7600);
INSERT INTO cars VALUES('00하0011',1000,'현대 아반떼',2021,5,'gasoline',7700);
INSERT INTO cars VALUES('00하0012',1000,'현대 아반떼',2022,5,'gasoline',7800);
INSERT INTO cars VALUES('00하0013',1000,'현대 아반떼',2023,5,'gasoline',7900);
INSERT INTO cars VALUES('00허0014',1002,'기아 카니발',2020,11,'diesel',11000);
INSERT INTO cars VALUES('00허0015',1002,'기아 카니발',2020,9,'diesel',10000);
INSERT INTO cars VALUES('00호0016',1002,'현대 스타리아',2022,11,'diesel',11200);
INSERT INTO cars VALUES('00호0017',1002,'현대 스타리아',2021,9,'diesel',10200);
INSERT INTO cars VALUES('00호0018',1002,'현대 스타리아',2023,9,'diesel',11000);
INSERT INTO cars VALUES('00호0019',1002,'현대 스타리아',2024,9,'gasoline',11900);
INSERT INTO cars VALUES('00호0020',1002,'기아 K8',2021,5,'gasoline',8900);
INSERT INTO cars VALUES('00호0021',1002,'기아 K8',2023,5,'gasoline',9300);

SELECT * FROM cars;

CREATE TABLE categories(
	`cate_no` INT PRIMARY KEY AUTO_INCREMENT,
    `cate_name` VARCHAR(10) NOT NULL UNIQUE
)AUTO_INCREMENT 1000;

SELECT * FROM categories;
DROP DATABASE rental_car_db;

INSERT INTO categories(`cate_name`) VALUES('중형');
INSERT INTO categories(`cate_name`) VALUES('경형/소형');
INSERT INTO categories(`cate_name`) VALUES('대형');
