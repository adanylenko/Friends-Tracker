-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema trackfriends
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trackfriends
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trackfriends` DEFAULT CHARACTER SET utf8 ;
USE `trackfriends` ;

-- -----------------------------------------------------
-- Table `trackfriends`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackfriends`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `token` VARCHAR(255) DEFAULT NULL,
  `phoneNumber` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trackfriends`.`friends`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackfriends`.`friends` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `privilege` INT(11) NOT NULL,
  `id_user` INT(11) NOT NULL,
  `id_friend` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `friends_fk_idx` (`id_user` ASC),
  INDEX `friends_user_friend_fk_idx` (`id_friend` ASC),
  CONSTRAINT `friends_user_fk`
    FOREIGN KEY (`id_user`)
    REFERENCES `trackfriends`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `friends_user_friend_fk`
    FOREIGN KEY (`id_friend`)
    REFERENCES `trackfriends`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trackfriends`.`points`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackfriends`.`points` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `lat` DOUBLE NOT NULL,
  `lng` DOUBLE NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `points_fk_idx` (`id_user` ASC),
  CONSTRAINT `points_fk`
    FOREIGN KEY (`id_user`)
    REFERENCES `trackfriends`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trackfriends`.`users_config`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackfriends`.`users_config` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `update_time` INT(11) NOT NULL,
  `alert_zone` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC),
  CONSTRAINT `user_config_fk`
    FOREIGN KEY (`id_user`)
    REFERENCES `trackfriends`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
