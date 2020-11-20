CREATE TABLE `record`
(
    `id`         bigint      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `tag_id`     bigint      NOT NULL,
    `tag_type`   varchar(50) NOT NULL,
    `user_id`    bigint      NOT NULL,
    `is_out`     bit         NOT NULL DEFAULT true,
    `money`      int         NOT NULL,
    `book_id`    bigint      NOT NULL DEFAULT '0',
    `created_at` datetime    NOT NULL,
    `updated_at` datetime    NOT NULL
) ENGINE = 'InnoDB'
  COLLATE 'utf8mb4_unicode_ci';
