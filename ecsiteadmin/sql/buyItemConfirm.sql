set names utf8;
set foreign_key_checks=0;

use ecsite_admin;

Drop table if exists buy_item_confirm;
Create table buy_item_confirm(

	id int not null primary key auto_increment,
	item_name varchar(30),
	item_price int,
	item_total_price int
	item_stock int,
	
);