DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS questionnaire;
DROP TABLE IF EXISTS friends;
DROP TABLE IF EXISTS users;


CREATE TABLE users
(
    id       BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled  TINYINT      NOT NULL DEFAULT 1
);

CREATE TABLE authorities
(
    id        BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);

CREATE UNIQUE INDEX ix_auth_username
    on authorities (username, authority);

CREATE TABLE questionnaire
(
    id          BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(50) NOT NULL,
    name        varchar(255),
    second_name varchar(255),
    age         INT,
    sex         varchar(255),
    interests   varchar(255),
    city        varchar(255),
    FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE friends
(
    user_id   BIGINT NOT NULL,
    friend_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, friend_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (friend_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);