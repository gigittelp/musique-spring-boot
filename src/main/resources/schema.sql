CREATE SCHEMA MUSIQUE_DB AUTHORIZATION SA;

use MUSIQUE_DB;

CREATE TABLE artist (
    id   INTEGER   PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    bio VARCHAR(255),
    fan_number INTEGER
);

CREATE TABLE album (
    id   INTEGER   PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(70) NOT NULL,
    release_date DATE,
    artist_id INT,
    foreign key (artist_id) references artist(id)
);