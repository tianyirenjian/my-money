CREATE TABLE user_tag
(
    id         bigint PRIMARY KEY AUTO_INCREMENT,
    name       varchar(255) NOT NULL,
    user_id    bigint       NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime     NOT NULL
) ENGINE = 'InnoDB'
  COLLATE 'utf8mb4_unicode_ci';
