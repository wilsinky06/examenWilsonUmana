CREATE DATABASE PlanPaciente;
USE PlanPaciente;

create table Usuario (
                         id varchar(10) unique not null,
                         clave varchar(100) not null,
                         rol varchar(10) not null,
                         Primary key(id)
);

create table Medicamento (
                             id varchar(20) not null,
                             nombre varchar(30) not null,
                             plan integer,
                             regalias integer default 1,
                             Primary key(id)
);

create table Farmacia (
                          id varchar(20) not null,
                          nombre varchar(30) not null,
                          usuario varchar(20) not null,
                          Primary key(id)
);

create table Paciente (
                          id varchar(20) not null,
                          nombre varchar(30) not null,
                          Primary key(id)
);

create table PacienteMedicamento (
                                     id integer auto_increment not null,
                                     paciente varchar(20) not null,
                                     medicamento varchar(20) not null,
                                     dosisafavor integer,
                                     Primary key(id)
);

alter table Farmacia add foreign key (usuario) references Usuario(id);
alter table PacienteMedicamento add foreign key (paciente) references Paciente(id);
alter table PacienteMedicamento add foreign key (medicamento) references Medicamento(id);

-- USUARIOS
insert into Usuario (id,clave,rol) values
                                       ('Farma10','$2a$12$UafqQkd9TVJxw9W4HoQ1eePssHEW6IPlX9VeKHWvMfiEeHGgsdOGO','FARM'),/* clave 111 */
                                       ('Bomba07','$2a$12$z0dbkRqX1JSXOjAN9YX8tOWp.Es70TJl08ebtGgrwdOvgKe9dC67e','FARM'),  /* clave 222 */
                                       ('Rafa01','$2a$10$fo6YAelGGNZsezGZl1PrMOYTycdL1PbNJOkS/rhYkKrT19LliDtje','FARM');  /* clave 333 - en cualquier caso que no le funcione use en el aplication BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); System.out.println("Hash de 333: " + encoder.encode("333")); y updatee el usuario con el hash que le da profe*/

insert into Medicamento (id,nombre,plan,regalias) values
                                                      ('LIP20','LipoRaven 20mg',2,1),
                                                      ('EZE10','Ezetemin 10mg',3,1),
                                                      ('TAL05','Taladaf 5mg',1,1),
                                                      ('IBU500','Ibuprofeno 500mg',2,1),
                                                      ('ENT50','Enterogermina 50ml',5,2);

insert into Farmacia (id,nombre,usuario) values
                                             ('Farma10','FarmaValue Sabanilla','Farma10'),
                                             ('Bomba07','La Bomba San Pedro','Bomba07'),
                                             ('Rafa01','San Rafaelena','Rafa01');

insert into Paciente (id,nombre) values
                                     ('111','Juan Perez'),
                                     ('222','Maria Mata');

insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values
                                                                       ('111','EZE10',1),
                                                                       ('111','TAL05',0),
                                                                       ('222','LIP20',1),
                                                                       ('222','IBU500',1),
                                                                       ('222','ENT50',2),
                                                                       ('111','IBU500',2),
                                                                       ('111','ENT50',1);

-- //Profe en caso que no le funcione ese el anterior use este solo que hagale un alter table a medicamentos
--     USE PlanPaciente;
--
-- ALTER TABLE Medicamento ADD COLUMN regalias INTEGER DEFAULT 1;
--
-- -- Actualizar los medicamentos existentes
-- UPDATE Medicamento SET regalias = 1 WHERE id = 'LIP20';
-- UPDATE Medicamento SET regalias = 1 WHERE id = 'EZE10';
-- UPDATE Medicamento SET regalias = 1 WHERE id = 'TAL05';
-- UPDATE Medicamento SET regalias = 1 WHERE id = 'IBU500';
-- UPDATE Medicamento SET regalias = 2 WHERE id = 'ENT50';

CREATE DATABASE PlanPaciente;
USE PlanPaciente;

create table Usuario (
                         id varchar(10) unique not null,
                         clave varchar(100) not null,
                         rol varchar(10) not null,
                         Primary key(id)
);

create table Medicamento (
                             id varchar(20) not null,
                             nombre varchar(30) not null,
                             plan integer,
                             Primary key(id)
);

create table Farmacia (
                          id varchar(20) not null,
                          nombre varchar(30) not null,
                          usuario varchar(20) not null,
                          Primary key(id)
);

create table Paciente (
                          id varchar(20) not null,
                          nombre varchar(30) not null,
                          Primary key(id)
);

create table PacienteMedicamento (
                                     id integer auto_increment not null,
                                     paciente varchar(20) not null,
                                     medicamento varchar(20) not null,
                                     dosisafavor integer,
                                     Primary key(id)
);

alter table Farmacia add foreign key (usuario) references Usuario(id);
alter table PacienteMedicamento add foreign key (paciente) references Paciente(id);
alter table PacienteMedicamento add foreign key (medicamento) references Medicamento(id);
insert into Usuario (id,clave,rol) values ('Farma10','$2a$12$UafqQkd9TVJxw9W4HoQ1eePssHEW6IPlX9VeKHWvMfiEeHGgsdOGO','FARM'); /* clave 111 */
insert into Usuario (id,clave,rol) values ('Bomba07','$2a$12$z0dbkRqX1JSXOjAN9YX8tOWp.Es70TJl08ebtGgrwdOvgKe9dC67e','FARM'); /* clave 222 */
insert into Usuario (id,clave,rol) values ('Rafa01','$2a$10$fo6YAelGGNZsezGZl1PrMOYTycdL1PbNJOkS/rhYkKrT19LliDtje','FARM'); /* clave 333 - en cualquier caso que no le funcione use en el aplication BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); System.out.println("Hash de 333: " + encoder.encode("333")); y updatee el usuario con el hash que le da profe*/

insert into Medicamento (id,nombre,plan) values ('LIP20','LipoRaven 20mg',2);
insert into Medicamento (id,nombre,plan) values ('EZE10','Ezetemin 10mg',3);
insert into Medicamento (id,nombre,plan) values ('TAL05','Taladaf 5mg',1);
insert into Medicamento (id,nombre,plan) values ('IBU500','Ibuprofeno 500mg',2);
insert into Medicamento (id,nombre,plan) values ('ENT50','Enterogermina 50ml',5);

insert into Farmacia (id,nombre,usuario) values ('Farma10','FarmaValue Sabanilla','Farma10');
insert into Farmacia (id,nombre,usuario) values ('Bomba07','La Bomba San Pedro','Bomba07');
insert into Farmacia (id,nombre,usuario) values ('Rafa01','San Rafaelena','Rafa01');

insert into Paciente (id,nombre) values ('111','Juan Perez');
insert into Paciente (id,nombre) values ('222','Maria Mata');

insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('111','EZE10',1);
insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('111','TAL05',0);
insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('222','LIP20',1);
insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('222','IBU500',1);
insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('222','ENT50',2);
insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('111','IBU500',2);
insert into PacienteMedicamento (paciente,medicamento,dosisafavor) values ('111','ENT50',1);