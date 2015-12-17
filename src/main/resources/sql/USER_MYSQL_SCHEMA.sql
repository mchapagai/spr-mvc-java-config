-- IMPORTING MySQL SCRIPT USING COMMAND LINE
-- mysql -u root -p db_name < path-to-the-script/script.sql

CREATE TABLE `users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `last_name` VARCHAR(20) NOT NULL,
    `first_name` VARCHAR(10) NOT NULL,
    `birth_date` DATETIME,
    `address` VARCHAR(60),
    `city` VARCHAR(15),
    `postal_code` VARCHAR(10),
    `country` VARCHAR(15),
    `homephone` VARCHAR(24),
    `salary` FLOAT,
    `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `PK_USERS` PRIMARY KEY (`id`)
);

TRUNCATE TABLE users;
INSERT INTO users VALUES(null,'Davolio','Nancy','1948-12-08','507 - 20th Ave. E.Apt. 2A','Seattle','98122','USA','(206) 555-9857','2954.55', now());
INSERT INTO users VALUES(null,'Fuller','Andrew','1952-02-19','908 W. Capital Way','Tacoma','98401','USA','(206) 555-9482','2254.49', now());
INSERT INTO users VALUES(null,'Leverling','Janet','1963-08-30','722 Moss Bay Blvd.','Kirkland','98033','USA','(206) 555-3412','3119.15', now());
INSERT INTO users VALUES(null,'Peacock','Margaret','1937-09-19','4110 Old Redmond Rd.','Redmond','98052','USA','(206) 555-8122','1861.08', now());
INSERT INTO users VALUES(null,'Buchanan','Steven','1955-03-04','14 Garrett Hill','London','SW1 8JR','UK','(71) 555-4848','1744.21', now());
INSERT INTO users VALUES(null,'Suyama','Michael','1963-07-02','Coventry House Miner Rd.','London','EC2 7JR','UK','(71) 555-7773','2004.07', now());
INSERT INTO users VALUES(null,'King','Robert','1960-05-29','Edgeham Hollow Winchester Way','London','RG1 9SP','UK','(71) 555-5598','1991.55', now());
INSERT INTO users VALUES(null,'Callahan','Laura','1958-01-09','4726 - 11th Ave. N.E.','Seattle','98105','USA','(206) 555-1189','2100.50', now());
INSERT INTO users VALUES(null,'Dodsworth','Anne','1908-12-08','17 Houndstooth Rd.','London','WG2 7LT','UK','(71) 555-4444','2333.33', now());