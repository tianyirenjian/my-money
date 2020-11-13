CREATE TABLE system_tag (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8mb4_unicode_ci';

INSERT INTO `system_tag` (`id`, `name`) VALUES
(1,	'交通'),
(2,	'餐饮'),
(3,	'房租'),
(4,	'日用'),
(5,	'医药');
