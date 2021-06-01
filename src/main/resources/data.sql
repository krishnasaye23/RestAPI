CREATE TABLE if not exists MovieTable
(
    movie_id integer NOT NULL,
    movie_name varchar(255),
    movie_language varchar(200),
    rating double,
    Details_id integer not null,
    CONSTRAINT MovieTable PRIMARY KEY (movie_id),
    FOREIGN KEY (Details_id) REFERENCES details(id)
);
CREATE TABLE if not exists details
(
    id integer NOT NULL PRIMARY KEY,
    genre varchar(250) NOT NULL,
    runtime integer,
    releasedate date,
    FOREIGN KEY (Movie_id) REFERENCES MovieTable(movie_id)
);