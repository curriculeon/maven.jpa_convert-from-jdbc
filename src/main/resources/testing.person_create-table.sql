DROP TABLE IF EXISTS testing_database.person;

CREATE TABLE testing_database.person(
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    name TEXT NOT NULL,
    password TEXT NOT NULL
);