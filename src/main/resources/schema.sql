DROP TABLE IF EXISTS users;

CREATE TABLE `users`
(
    id          BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        varchar(255),
    second_name varchar(255),
    age         INT,
    sex         varchar(255),
    interests   varchar(255),
    city        varchar(255)
);