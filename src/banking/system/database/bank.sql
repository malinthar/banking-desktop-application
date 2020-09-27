create database bank;
use bank;

create table if not exists AccountHolder(
	id int not null auto_increment,
	first_name varchar(20) not null,
	last_name varchar(20),
	nic varchar(10) not null unique,
	birthday date not null,
	telephone varchar(10) not null,
	registered_branch varchar(50) not null,
	email varchar(65) ,
	streetNumber varchar(25),
	streetName varchar(100) not null,
	city varchar(25) not null,
	district varchar(25) not null,
	province varchar(25) not null,
	zip varchar(6) not null,
	primary key (id)
);

create table if not exists Employee(
	id int not null auto_increment,
	first_name varchar(20) not null,
	last_name varchar(20) ,
	nic varchar(10) not null unique,
	birthday date not null,
	telephone varchar(10) not null,
    employee_type enum("cashier","manager") not null,
	employed_branch varchar(50) not null,
	email varchar(65),
	streetNumber varchar(25),
	streetName varchar(100) not null,
	city varchar(25) not null,
	district varchar(25) not null,
	province varchar(25) not null,
	zip varchar(6) not null,
	primary key (id)
);

create table if not exists BankAccount(
	account_number int not null auto_increment,
	account_name varchar(20),
	account_holder_id int not null,grid.add(new Label(attribute), 0, index + 1);
	account_type enum("savings","current"),
	balance double,
	opened_date date not null,
	branch varchar(20),
	primary key (account_number)
);

create table if not exists TransactionLog(
    transaction_id int not null auto_increment,
    transaction_timestamp timestamp not null DEFAULT CURRENT_TIMESTAMP,
    transaction_type enum("withdraw","deposit") not null,
    amount double not null,
    account_number int not null,
    employee_id int not null,
    primary key (transaction_id),
    foreign key (account_number) references BankAccount (account_number),
    foreign key (employee_id) references Employee (id)
);


















