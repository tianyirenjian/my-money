create table user (
    id bigint auto_increment primary key,
    name varchar(20) not null,
    password varchar(255) not null,
    phone varchar(20) not null default '',
    is_enable bit not null default true,
    created_at datetime not null,
    updated_at datetime not null
)
