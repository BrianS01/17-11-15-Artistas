drop database if exists ArtistaBases;
create database ArtistaBases;
use ArtistaBases;

create table artista
(
	cedula int,
	nombre varchar(45),
    edad int,
	obra varchar(45),
    estilo varchar(45),
    primary key(cedula)
);