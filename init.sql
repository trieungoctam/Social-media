use facebook;

drop table if exists user;
create table if not exists user (
    id bigint primary key auto_increment,
    first_name nvarchar(255) not null,
    last_name nvarchar(255) not null,
    email varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    date_of_birth timestamp null,
    phone_number varchar(255) null,
    status int null default 0,
    avatar_url text null,
    friend_count bigint null default 0,
    about text null
);

drop table if exists friend;
create table if not exists friend (
    id bigint primary key auto_increment,
    sender_id bigint not null references user (id),
    receiver_id bigint not null references user (id),
    is_friend int null default 0
);

drop table if exists post;
create table if not exists post (
    id bigint primary key auto_increment,
    share_id bigint null references post (id),
    create_by bigint not null references user (id),
    create_at timestamp not null default current_timestamp,
    update_at timestamp null,
    resources text null,
    content text null,
    react_count bigint null default 0,
    public int null default 0
);

drop table if exists user_react_post;
create table if not exists user_react_post (
    id bigint primary key auto_increment,
    user_id bigint not null references user (id),
    post_id bigint not null references post (id),
    react_type int null default 0
);

drop table if exists comment;
create table if not exists comment (
    id bigint primary key auto_increment,
    user_id bigint not null references user (id),
    post_id bigint not null references post (id),
    create_at timestamp not null default current_timestamp,
    react_count bigint null default 0,
    parent_id bigint null references comment (id),
    resources text null,
    content text null
);

drop table if exists user_react_comment;
create table if not exists user_react_comment (
    id bigint primary key auto_increment,
    user_id bigint not null references user (id),
    comment_id bigint not null references comment (id),
    react_type int null default 0
);

drop table if exists m_group;
create table if not exists m_group (
    id bigint primary key auto_increment,
    group_name varchar(255) not null,
    banner_url text null,
    about text null
);

drop table if exists user_group;
create table if not exists user_group (
    id bigint primary key auto_increment,
    user_id bigint not null references user (id),
    group_id bigint not null references m_group (id),
    role int null default 0,
    status int null default 0
);

drop table if exists post_group;
create table if not exists post_group (
    id bigint primary key auto_increment,
    post_id bigint not null references post (id),
    group_id bigint not null references m_group (id)
);

drop table if exists notification;
create table if not exists notification (
    id bigint primary key auto_increment,
    user_id bigint not null references user (id),
    url text null,
    description text null,
    create_at timestamp not null default current_timestamp,
    create_by bigint null references user (id),
    is_read int null default 0
);