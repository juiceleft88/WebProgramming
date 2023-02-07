drop table if exists movies2;
drop table if exists reviews2;

create table movies2(
    id integer auto_increment primary key,
    title varchar(255),
    releaseYear integer,
    ratingScore integer
);

insert into movies2 values (1, 'Bad Boys For Life', 2020, 1);
insert into movies2 values (2, '1917', 2017, 1);
insert into movies2 values (3, 'The Gentleman', 2019, 0);

create table reviews2(
    id integer auto_increment primary key,
    userName varchar(255),
    rating integer,
    review varchar(8000),
    movie_id integer references movies(id)
);

insert into reviews2 (movie_id, userName, rating, review) 
    values(1, 'Max', 10, 'Watchu gonna do when they come for you??');
insert into reviews2 (movie_id, userName, rating, review)
    values(1, 'Gustavo', 6, 'Meh, wasnt as good as Bady Boys 2');
insert into reviews2 (movie_id, userName, rating, review)
    values(2, 'Jake', 9, 'Excellent film, great cinemetography and action sequences');
insert into reviews2 (movie_id, userName, rating, review)
    values(2, 'Gustavo', 8, 'We always see WW2 movies, nice to see a Great War film');




drop table if exists users;

create table users(
    id integer auto_increment primary key,
    fullName varchar(255),
    screenName varchar(255),
    pass varchar(255),
    clearance integer
);

insert into users (fullName, screenName, pass, clearance)
    values ('John Doe', 'jdoe1', 'abcd', 2);
insert into users (fullName, screenName, pass, clearance)
values ('Jane Doe', 'jdoe2', 'abcd', 1);
