DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  age int(11) DEFAULT NULL,
  balance decimal(19,2) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;