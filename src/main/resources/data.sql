-- INSERT INTO social.users
-- (name, second_name, age, sex, interests, city)
-- VALUES('name1', 'secondName1', 23, 'm', 'interes1', 'London');

-- User user/pass
INSERT INTO users (id, username, password, enabled)
values (1,
        'user1',
        '$2a$10$83CIRuJg9WPsuWsMoOcOUO/Ar6ttiPUZyPDrAUV3.G.QK2ixyHiPe',
        1);

INSERT INTO users (id, username, password, enabled)
values (2,
        'user2',
        '$2a$10$ebX5iLYh.WNTIFigAlvhLOH7od1Rg6mALbXKgnZ8KHtL8CaNxrqmS',
        1);

INSERT INTO users (id, username, password, enabled)
values (3,
        'user3',
        '$2a$10$g1KIemdAXotWEy/dgQqcAuzngkYI5PwI1nmRTL9snur6UBH3EDwk6',
        1);

INSERT INTO authorities (username, authority)
values ('user1', 'ROLE_USER');

INSERT INTO authorities (username, authority)
values ('user2', 'ROLE_USER');

INSERT INTO authorities (username, authority)
values ('user3', 'ROLE_USER');

INSERT INTO questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(1, 'user1', 'Kola', 'Petrov', 21, 'M', 'Painting', 'Moscow');

INSERT INTO questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(2, 'user1', 'Petr', 'Ivanov', 32, 'M', 'Guns', 'Kaluga');

INSERT INTO questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(3, 'user2', 'Oleg', 'Kuplinov', 31, 'M', 'Cars', 'New York');

INSERT INTO questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(6, 'user3', 'Oleg', 'Kuplinov', 33, 'W', 'Cars', 'York');

INSERT INTO friends
(user_id, friend_id)
VALUES(2, 1);

INSERT INTO friends
(user_id, friend_id)
VALUES(2, 3);