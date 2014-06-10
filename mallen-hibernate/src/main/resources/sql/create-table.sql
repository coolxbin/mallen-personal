create table t_user(
	id char(36) primary key,
	name varchar(100));
	
create table t_contact(
	id char(36) primary key,
	type varchar(50) not null,
	value varchar(50) not null,
	userId char(36) not null);
Alter table t_contact
add constraint FK_CONTACY_USER foreign key(userId) references t_user(id); 
