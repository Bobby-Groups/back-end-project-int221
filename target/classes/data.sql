insert into brands(brandName) values('TOA');
insert into brands(brandName)values('FOURSEASON');
insert into brands(brandName) values('begershield');

insert into types(id,typename,price,description,images)
values (1,'Acrylic',499.10,'acrylic in house','http.acb.com');
insert into types(id,typename,price,description,images)
values (2,'Latex',500.00,'Latex in house','http.bca.com');
insert into types(id,typename,price,description,images)
values (3,'Exterior',600.99,'Exterior in house','http.cba.com');

insert into have_type(brand_brandid,type_typeid)values(1,1);
insert into have_type(brand_brandid,type_typeid)values(2,2);
insert into have_type(brand_brandid,type_typeid)values(3,3);


insert into colors(colorName) values('red');
insert into colors(colorName) values('green');
insert into colors(colorName) values('blue');



insert into products(date,colors_Id,brands_id) 
values('2001-02-22',1,1);
insert into products(date,colors_Id,brands_id) 
values('1999-04-9',2,2);
insert into products(date,colors_Id,brands_id) 
values('2000-08-16',3,3);