DROP TABLE IF EXISTS production_database.person;

CREATE TABLE production_database.person(
    email VARCHAR(50) NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    password TEXT NOT NULL
);