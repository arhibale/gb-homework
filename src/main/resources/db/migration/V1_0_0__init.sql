begin;

drop table if exists products cascade;
create table products (id bigserial primary key, title varchar(128), cost integer);
insert into products (title, cost) values
('Red Apple', 30),
('Fly Pineapple', 50),
('Cherry', 20),
('Cyber Lemon', 60);

drop table if exists persons cascade;
create table persons (id bigserial primary key, name varchar(32));
insert into persons (name) values
('Cat'),
('Mr. Cat'),
('Alex');

drop table if exists ordering cascade;
create table ordering (id bigserial primary key, person_id bigint, product_id bigint,
foreign key (person_id) references persons (id),
foreign key (product_id) references products (id),
cost integer, date date);
insert into ordering (person_id, product_id, cost, date) values
(2, 3, 20, localtimestamp),
(2, 3, 20, localtimestamp),
(3, 1, 30, localtimestamp),
(2, 2, 50, localtimestamp),
(1, 3, 20, localtimestamp),
(1, 4, 60, localtimestamp);

commit;