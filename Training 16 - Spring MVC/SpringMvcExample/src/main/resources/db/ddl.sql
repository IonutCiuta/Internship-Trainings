-- -----------------------------------------------------
-- Table `mydb`.`Book`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `shortDescription` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;