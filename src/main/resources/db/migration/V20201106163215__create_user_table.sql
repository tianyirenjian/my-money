CREATE TABLE user (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	password varchar(255) NOT NULL,
	phone varchar(20) NOT NULL DEFAULT '',
	is_enable bit NOT NULL DEFAULT true,
	created_at datetime NOT NULL,
	updated_at datetime NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8mb4_unicode_ci';

INSERT INTO `user` (`id`, `name`, `password`, `phone`, `is_enable`, `created_at`, `updated_at`) VALUES
(1,	'tianyi',	'$2y$10$n7u01UNP4gF7e2iXXew/pefNOvOxbKFYbCDsajcx9Q5V.aIa9wati',	'18610240411',	CONV('1', 2, 10) + 0,	'2020-11-06 17:12:52',	'2020-11-06 17:12:52');