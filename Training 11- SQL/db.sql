DROP SCHEMA IF EXISTS `homework_schema`;
CREATE SCHEMA `homework_schema`;
USE `homework_schema`;
  
CREATE TABLE `produs` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `nume` VARCHAR(50) NOT NULL,
    `cod` VARCHAR(10) NOT NULL,
    `descriere` VARCHAR(100),
    `tva` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `cod_UNIQUE` (`cod` ASC)
);

CREATE TABLE `client` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `cui` VARCHAR(10) NOT NULL,
    `desciere` VARCHAR(100),
    PRIMARY KEY(`id`),
    UNIQUE INDEX `cui_UNIQUE` (`cui` ASC)
);

CREATE TABLE `factura` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`serie` VARCHAR(5) NOT NULL,
	`data_inreg` DATE NOT NULL,
    `descriere` VARCHAR(100),
    `client_id` INT NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`client_id`) REFERENCES client(`id`),
	UNIQUE INDEX `serie_UNIQUE` (`serie` ASC)
);

CREATE TABLE `detaliu_factura` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `factura_id` INT NOT NULL,
    `produs_id` INT NOT NULL,
    `cantitate` INT NOT NULL DEFAULT 1,
    `pret` FLOAT(6,2) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`factura_id`) REFERENCES factura(`id`),
    FOREIGN KEY (`produs_id`) REFERENCES produs(`id`)
);

DELIMITER $$
CREATE TRIGGER `data_factura` BEFORE INSERT ON `factura` FOR EACH ROW
if (isnull(new.data_inreg)) then
 set new.data_inreg=curdate();
end if;
$$
delimiter ;