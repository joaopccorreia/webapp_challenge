DROP DATABASE IF EXISTS challenge;
CREATE DATABASE challenge;
USE challenge;

CREATE TABLE client(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp not null,
    updateTime timestamp not null,
    version integer not null,
    firstName VARCHAR(256) not null,
    lastName VARCHAR(256) not null,
    vatNumber VARCHAR(256) not null,
    email VARCHAR(256) not null,
    age integer not null,
    phone integer not null
);

CREATE TABLE user(
    userName VARCHAR(256) Primary key,
    password VARCHAR(256) not null,
    active BIT not null default 1,
    client_id integer,

    foreign key (client_id) references client(id) ON UPDATE CASCADE,
);

CREATE TABLE item(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creationTime timestamp,
    updateTime timestamp,
    version integer,
    name VARCHAR(256) not null,
    type VARCHAR(256) not null,
    brand VARCHAR(256) not null,
    isActive BIT not null default 1
);

CREATE TABLE client_item(
    client_id integer,
    item_id integer,

    foreign key (client_id) references client(id),
    foreign key (item_id) references item(id)
);