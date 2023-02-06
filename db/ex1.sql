create database
	delivery_db
default character set
	utf8mb4
collate
	utf8mb4_general_ci;
	

create table delivery_mst
(
	delivery_id INT primary key auto_increment,
    delivery_company VARCHAR(20) not null,
    delivery_man VARCHAR(15) not null,
    delivery_address VARCHAR(100) not null,
    consignee_name VARCHAR(15) not null,
    consignee_phone VARCHAR(14) not null,
    consignee_message TEXT
    );
 
 
insert into delivery_mst
values (1, '대한통운', '김준일', '부산광역시 연제구 중앙대로 1001 부산광역시청', '김춘식', '010-8282-5353', '안전하게 배송해주세요.');