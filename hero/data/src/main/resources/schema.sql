create or replace schema if not exists superhero;

CREATE TABLE superhero.hero_power (
    id_power int not null, 
    power_name varchar(20), 
    damage double, 
    element varchar(10),
    PRIMARY KEY (id_power)
);

CREATE TABLE superhero.hero_superhero (
    id_hero int not null, 
    hero_name varchar(10), 
    id_power int, 
    alive boolean, 
    description varchar(50), 
    age int, 
    health double, 
    resistance double,
    PRIMARY KEY (id_hero),
    FOREIGN KEY (id_power) REFERENCES hero_power (id_power) 
);

CREATE SEQUENCE superhero.hero_seq_superhero INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE superhero.hero_seq_power INCREMENT BY 1 START WITH 1;