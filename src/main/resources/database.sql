
create table if not exists "user" (
    id bigserial primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    date_of_birth timestamp null,
    phone_number varchar(255) null,
    status int null default 0,
    avatar_url varchar(255) null,
    friend_count bigint null default 0,
    about text null
);

create table if not exists "friend" (
    sender_id bigint not null references "user" (id),
    receiver_id bigint not null references "user" (id),
    is_friend int null default 0,
    primary key (sender_id, receiver_id)
);

create table if not exists "post" (
    id bigserial primary key,
    share_id bigint null references "post" (id),
    create_by bigint not null references "user" (id),
    create_at timestamp not null default now(),
    update_at timestamp null,
    resources text null,
    content text null,
    react_count bigint null default 0,
    public int null default 0
);

create table if not exists "user_react_post" (
    user_id bigint not null references "user" (id),
    post_id bigint not null references "post" (id),
    react_type int null default 0,
    primary key (user_id, post_id)
);

create table if not exists "comment" (
    id bigserial primary key,
    user_id bigint not null references "user" (id),
    post_id bigint not null references "post" (id),
    create_at timestamp not null default now(),
    react_count bigint null default 0,
    parent_id bigint null references "comment" (id),
    resources text null,
    content text null
);

create table if not exists "user_react_comment" (
    user_id bigint not null references "user" (id),
    comment_id bigint not null references "comment" (id),
    react_type int null default 0,
    primary key (user_id, comment_id)
);

create table if not exists "m_group" (
    id bigserial primary key,
    group_name varchar(255) not null,
    banner_url varchar(255) null,
    about text null
);

create table if not exists "user_group" (
    user_id bigint not null references "user" (id),
    group_id bigint not null references "m_group" (id),
    role int null default 0,
    status int null default 0,
    primary key (user_id, group_id)
);

create table if not exists "post_group" (
    post_id bigint not null references "post" (id),
    group_id bigint not null references "m_group" (id),
    primary key (post_id, group_id)
);

create table if not exists "notification" (
    id bigserial primary key,
    user_id bigint not null references "user" (id),
    url text null,
    description text null,
    create_at timestamp not null default now(),
    create_by bigint null references "user" (id),
    is_read int null default 0
);