create table sales(
	customer varchar(255),
    amount int
);

insert into sales (customer, amount)
values
 ('john', 100),
 ('jane', 200),
 ('john', 150),
 ('jane', 50),
 ('jim', 300);
 

  select sum(amount)
 from
	sales;