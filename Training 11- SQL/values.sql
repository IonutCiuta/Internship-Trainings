use homework_schema;

SET FOREIGN_KEY_CHECKS = 0;
truncate detaliu_factura;
truncate factura;
truncate client;
truncate produs;
SET FOREIGN_KEY_CHECKS = 1;

insert into produs(id, nume, cod, descriere, tva) values(1, 'produs 1', 'cod_prod01', 'un produs', 9);
insert into produs(id, nume, cod, descriere, tva) values(2, 'produs 2', 'cod_prod02', 'un produs', 9);
insert into produs(id, nume, cod, descriere, tva) values(3, 'produs 3', 'cod_prod03', 'un produs', 7);
insert into produs(id, nume, cod, descriere, tva) values(4, 'produs 4', 'cod_prod04', 'un produs', 20);

insert into client(id, name, cui, desciere) values(1, 'Ford', 'cui-00001', 'some client');
insert into client(id, name, cui, desciere) values(2, 'BMW', 'cui-00002', 'some client');
insert into client(id, name, cui, desciere) values(3, 'Audi', 'cui-00003', 'some client');
insert into client(id, name, cui, desciere) values(4, 'Mercedes', 'cui-00004', 'some client');

insert into factura(id, serie, client_id) values(1, 'fact1', 1);
insert into factura(id, serie, client_id) values(2, 'fact2', 3);
insert into factura(id, serie, client_id) values(3, 'fact3', 4);

insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(1, 1, 2, 45);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(1, 2, 3, 27);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(1, 3, 4, 10);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(1, 4, 1, 35);

insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(2, 1, 2, 40);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(2, 2, 2, 20);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(2, 3, 2, 10);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(2, 4, 2, 30);

insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(3, 1, 6, 45);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(3, 2, 6, 27);
insert into detaliu_factura(factura_id, produs_id, cantitate, pret) values(3, 3, 6, 10);






