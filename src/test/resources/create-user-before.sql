SET FOREIGN_KEY_CHECKS=0

delete from user_roles;
delete from usr;

insert into usr(id, active, password, username) values
(1, 1, '$2a$08$wIiLQJX6MvdKbEME/e2Sk.xrWTezQEha.M9ziiioqExpFfhyevjzm', 'kevin'),
(2, 1, '$2a$08$wIiLQJX6MvdKbEME/e2Sk.xrWTezQEha.M9ziiioqExpFfhyevjzm', 'mike');

insert into user_role(user_id, roles) values
(1, 'USER'), (1, 'ADMIN'),
(2, 'USER');