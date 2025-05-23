-- create table book(
--     id bigint generated by default as identity primary key,
--
-- );

create table book
(
    id bigint generated by default as identity primary key,
    name varchar(255),
    category varchar(255),
    author bigint references author,
    availableCopies INTEGER
);

create table author
(
    id bigint generated by default as identity primary key,
    name varchar(255),
    surname varchar(255),
    country bigint references country
);

create table country
(
    id              bigint generated by default as identity
        primary key,
    name            varchar(255),
    continent        varchar(255)
);


create index idx_book_name on book(name);
create index idx_book_category on book(category);
create index idx_book_author on book(author);
create index idx_author_name_surname on author(name, surname);
create index idx_author_country on author(country);
create index idx_country_name on country(name);
create index idx_country_continent on country(continent);
