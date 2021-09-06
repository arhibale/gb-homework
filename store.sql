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
insert into persons_products (person_id, product_id, cost, date) values
(1, 3, 20, '05-09-2021'),
(1, 2, 50, '04-09-2021'),
(2, 1, 30, '03-09-2021'),
(2, 2, 50, '03-09-2021'),
(2, 3, 20, '03-09-2021'),
(3, 4, 60, '05-09-2021');

commit;