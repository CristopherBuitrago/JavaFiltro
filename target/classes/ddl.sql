DROP DATABASE IF EXISTS sgpzf;
CREATE DATABASE sgpzf;
USE sgpzf;

-- creacion de tablas independientes

CREATE TABLE stack(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT Pk_stack PRIMARY KEY (id)
);

CREATE TABLE skill(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT Pk_skill PRIMARY KEY (id)
);

CREATE TABLE country(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    CONSTRAINT Pk_country PRIMARY KEY (id)
);

CREATE TABLE gender(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    CONSTRAINT Pk_gender PRIMARY KEY (id)
);

-- creacion de tablas dependientes

CREATE TABLE region(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    idcountry INT NOT NULL,
    CONSTRAINT Pk_region PRIMARY KEY (id),
    CONSTRAINT Fk_region_1 FOREIGN KEY (idcountry) REFERENCES country(id)
);

CREATE TABLE city (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    idregion INT NOT NULL,
    CONSTRAINT Pk_city PRIMARY KEY (id),
    CONSTRAINT Fk_city_1 FOREIGN KEY (idregion) REFERENCES region(id)
);

CREATE TABLE person (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    idcity INT NOT NULL,
    address VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    idgender INT NOT NULL,
    CONSTRAINT Pk_person PRIMARY KEY (id),
    CONSTRAINT Fk_person_1 FOREIGN KEY (idcity) REFERENCES city (id),
    CONSTRAINT Fk_person_2 FOREIGN KEY (idgender) REFERENCES gender (id)
);

CREATE TABLE persons_skill (
	id INT NOT NULL AUTO_INCREMENT,
    registration_date DATE NOT NULL,
    idperson INT NOT NULL,
    idskill INT NOT NULL,
    CONSTRAINT Pk_person_skill PRIMARY KEY (id),
    CONSTRAINT Fk_person_skill_1 FOREIGN KEY (idperson) REFERENCES person (id),
    CONSTRAINT Fk_person_skill_2 FOREIGN KEY (idskill) REFERENCES skill (id)
);