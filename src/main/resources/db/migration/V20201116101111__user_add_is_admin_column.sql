ALTER TABLE `user`
    ADD `is_admin` bit(1) NOT NULL DEFAULT false AFTER `is_enable`;
