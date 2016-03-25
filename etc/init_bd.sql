DROP TABLE IF NOT EXISTS user;
CREATE TABLE user (
	user_code VARCHAR(8),
	email VARCHAR(40),
	password VARCHAR(20),
	is_admin BOOLEAN,
	PRIMARY KEY (user_code)
);

DROP TABLE IF NOT EXISTS trade;
CREATE TABLE trade (
	buyer_code VARCHAR(8),
	seller_code VARCHAR(8),
	date DATETIME,
	PRIMARY KEY (buyer_code, seller_code, date)
);
--TODO
