create table sales
(
    id serial not null,
    item_name text not null,
    price integer not null,
    primary key (id)
);

create table users
(
    id serial not null,
    name text not null,
    password text not null,
    primary key (id)
);

create table roles
(
    id serial not null,
    user_id integer not null,
    name text not null,
    primary key(id)
);

-- リレーションとかガッツリ無視しています。
create table authorities
(
    id serial not null,
    user_id integer not null,
    name text not null,
    primary key(id)
);

create table cards
(
    id serial not null,
    user_id integer not null,
    name text not null,
    primary key(id)
);


