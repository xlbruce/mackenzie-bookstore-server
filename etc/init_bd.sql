CREATE TABLE publisher (
  id_publisher INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY(id_publisher)
);

CREATE TABLE author (
  id_author INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY(id_author)
);

CREATE TABLE user_type (
  type_id INTEGER UNSIGNED NOT NULL,
  type VARCHAR(45) NOT NULL,
  PRIMARY KEY(type_id)
);

CREATE TABLE user (
  code INTEGER UNSIGNED NOT NULL,
  type_id INTEGER UNSIGNED NOT NULL,
  username VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY(code),
  FOREIGN KEY(type_id)
    REFERENCES user_type(type_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE book (
  isbn VARCHAR(13) NOT NULL,
  id_author INTEGER UNSIGNED NOT NULL,
  id_publisher INTEGER UNSIGNED NOT NULL,
  name VARCHAR(200) NOT NULL,
  description TEXT NULL,
  PRIMARY KEY(isbn),
  FOREIGN KEY(id_publisher)
    REFERENCES publisher(id_publisher)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(id_author)
    REFERENCES author(id_author)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE announce (
  code INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  isbn VARCHAR(13) NOT NULL,
  sold BOOL NULL DEFAULT false,
  description TEXT NULL,
  PRIMARY KEY(code, isbn),
  FOREIGN KEY(isbn)
    REFERENCES book(isbn)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

