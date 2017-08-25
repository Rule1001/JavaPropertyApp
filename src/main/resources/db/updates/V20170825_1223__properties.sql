

CREATE TABLE `property` (
  `property_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `property_name` VARCHAR(255) NOT NULL,
  `property_type` VARCHAR(255) NOT NULL,
  `bedrooms` INT(10) NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `property_description` VARCHAR(255) NOT NULL,
  `image_url` VARCHAR(255) NOT NULL,
  `for_sale` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


