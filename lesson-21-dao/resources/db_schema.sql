create table users
(
  id integer primary key,
  name text,
  login text,
  password text
);

insert into users (name, login, password) values
  ('Alexandr Alexandrov', 'alex', 'asd123'),
  ('Ivan Ivanov', 'vanya', '123456'),
  ('Pavel Pavlov', 'pasha', '1q2w3e'),
  ('Vladimir Vladimirov', 'vova', 'qwe123');

-- user can be a member of many groups
create table groups
(
  id integer primary key,
  name text,
  description text
);

insert into groups (name, description) values
('inters', 'potential workers'),
('workers', 'only company workers'),
('managers', 'managers only'),
('contractors', 'part time workers'),
('guests', 'potential clients'),
('clients', 'company clients');

-- user can have only one role
create table roles
(
  id integer primary key,
  name text,
  description text
);

insert into roles (name, description) values
  ('visitor', 'readonly user'),
  ('user','Can create data, update and delete own data'),
  ('content_manage', 'can create, update, and delete any data'),
  ('administrator', 'full data access, can create users');