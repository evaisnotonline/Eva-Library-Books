drop table if exists book CASCADE;
create table book 
(
	id integer PRIMARY KEY AUTO_INCREMENT, 
	author varchar(255), 
	publisher varchar(255), 
	title varchar(255)
);