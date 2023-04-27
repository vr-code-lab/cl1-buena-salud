drop database if exists CL_QUISPEIMATA;
create database CL_QUISPEIMATA;
use CL_QUISPEIMATA;

create table doctores(
	id_doctor int auto_increment, 
    nom_doctor varchar(255) not null, 
    especialidad_doctor varchar(255) not null,
    constraint pk_table_doctores primary key (id_doctor)
);

create table citas(
	id_cita int auto_increment, 
    num_cita char(255) not null, 
    fecha_cita varchar(20) not null, 
    nom_paciente_cita varchar(255) not null,
    id_doctor int,
    constraint pf_table_citas primary key (id_cita),
    constraint fk_doctos_citas foreign key (id_doctor) references doctores(id_doctor)
);

select * from doctores;
select * from citas;