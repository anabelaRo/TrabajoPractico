create database timeline;

use database timeline;

create table Empresa (
	id_empresa int primary key,
	nombre_empresa varchar(30)
);

create table Agente (
	id_agente int primary key,
	nombre varchar(20)
);

create table Mensaje (
	id_mensaje int primary key,
	contenido varchar(30),
	id_empresa int,
	id_agente int,
	fecha datetime,
	foreign key (id_empresa) references Empresa(id_empresa),
	foreign key (id_agente) references Agente(id_agente)
);

insert into Empresa (id_empresa, nombre_empresa) values 
					(1,'empresa1'),
					(2,'empresa2'),
					(3,'empresa3'),
					(4,'empresa4'),
					(5,'empresa5');

insert into Agente (id_agente, nombre_agente) values 
					(1,'agente1'),
					(2,'agente2'),
					(3,'agente3'),
					(4,'agente4'),
					(5,'agente5');
					
insert into Mensaje (id_mensaje, contenido, id_empresa, id_agente, fecha) values
					(1,'contenido1',1,1,'2013-11-28'),
					(2,'contenido2',2,2,'2013-10-28'),
					(3,'contenido3',3,3,'2013-7-28'),
					(4,'contenido4',4,4,'2013-3-28'),
					(5,'contenido5',5,5,'2013-6-28'),
					(6,'contenido6',6,6,'2013-8-28');