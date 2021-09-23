begin;

create table users (
  id                    bigserial,
  username              varchar(30) not null,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  score                 integer not null,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email, score)
values
('user1', '$2a$10$0mc2bZEbGKhKxAex0vJbCOEmEMKFDVHWlA8t3z9p/T/hWVhXfWjny', 'user1@gmail.com', 0),
('user2', '$2a$10$0yDh/LMDy00YugtpsFlvm.GGlHCrKGla.ekCAbkauJyUYYyisgH4u', 'user2@gmail.com', 10),
('user3', '$2a$10$5A4MhWUpokHq2ijoXEKK5OPIwIvfsHBw5aQfcJ8oEIEHe040Qlwhi', 'user3@gmail.com', 20);

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 1),
(3, 1), (3, 2);

commit;