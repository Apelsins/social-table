-- INSERT INTO social.users
-- (name, second_name, age, sex, interests, city)
-- VALUES('name1', 'secondName1', 23, 'm', 'interes1', 'London');

-- User user/pass
INSERT INTO users (id, username, password, enabled)
values (1,
        'user',
        '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
        1);

INSERT INTO users (id, username, password, enabled)
values (2,
        'y',
        '$2a$10$a2v25.GdScx70NhjUrzZxuDfygoaAdqM5XVvTiIyw3wpHt0Eh3pYS',
        1);

INSERT INTO users (id, username, password, enabled)
values (3,
        'u',
        '$2a$10$X9jmJFk3TThLo/sPnjaAvOjR1aZiVP00AgD78DKQiO0GlvOvfiHre',
        1);

INSERT INTO authorities (username, authority)
values ('user', 'ROLE_USER');

INSERT INTO authorities (username, authority)
values ('y', 'ROLE_USER');

INSERT INTO authorities (username, authority)
values ('u', 'ROLE_USER');

INSERT INTO social.questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(1, 'y', 't', 't', 4, 't', 't', 't');

INSERT INTO social.questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(2, 'y', 'u', 'u', 443, 'u', 'u', 'u');

INSERT INTO social.questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(3, 'u', 'fgh', 'gfh', 4333, 'dfg', 'fdg', 'dfg');

INSERT INTO social.questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(4, 'u', 'fgh', 'gfh', 4333, 'dfg', 'fdg', 'dfg');

INSERT INTO social.questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(5, 'u', 'fgh', 'gfh', 4333, 'dfg', 'fdg', 'dfg');

INSERT INTO social.questionnaire
(id, username, name, second_name, age, sex, interests, city)
VALUES(6, 'user', 'fgh', 'gfh', 4333, 'dfg', 'fdg', 'dfg');

INSERT INTO social.friends
(user_id, friend_id)
VALUES(2, 1);

INSERT INTO social.friends
(user_id, friend_id)
VALUES(2, 3);