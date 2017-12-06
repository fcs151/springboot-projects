use test;

DROP TABLE IF EXISTS State;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS Worker;
DROP TABLE IF EXISTS Issue;

CREATE TABLE State (
	id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Role (
	id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
	PRIMARY KEY (id)
);

CREATE TABLE Worker (
	id int(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
	email VARCHAR(255),
	role int(11) NOT NULL,
	PRIMARY KEY (id),
    CONSTRAINT FK_Role FOREIGN KEY (role) REFERENCES Role (id)
);

CREATE TABLE Issue (
	id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
	responsible int(11) NOT NULL,
	state_id int(11) NOT NULL DEFAULT 1,
	enabled TINYINT NOT NULL DEFAULT 1,
    createdAt datetime NOT NULL,
    updatedAt datetime DEFAULT NULL,
	PRIMARY KEY (id),
    CONSTRAINT FK_Worker FOREIGN KEY (responsible) REFERENCES Worker (id),
    CONSTRAINT FK_State FOREIGN KEY (state_id) REFERENCES State (id)
);

INSERT INTO State (name) 
VALUES ('TO_DO');
INSERT INTO State (name) 
VALUES ('SPRINT_BACKLOG');
INSERT INTO State (name) 
VALUES ('IN_PROGRESS');
INSERT INTO State (name) 
VALUES ('CODE_REVIEW');
INSERT INTO State (name) 
VALUES ('QA');
INSERT INTO State (name) 
VALUES ('DONE');

INSERT INTO Role (name, description) 
VALUES ('Developer', 'The man who is always suffering because of the code bugs');
INSERT INTO Role (name, description) 
VALUES ('Business Analyst', 'The man who is always trying to acquire system requirements');

INSERT INTO Worker (first_name, last_name, email, role) 
VALUES ('Federico', 'Schaefer', 'fedeschaefer@gmail.com', 2);
INSERT INTO Worker (first_name, last_name, email, role) 
VALUES ('Alan', 'Albertengo', 'alan.albertengo@santexgroup.com', 1);

INSERT INTO Issue (name, description, responsible, state_id, enabled, createdAt, updatedAt) 
VALUES ('Code Spring-Boot Example', 'Learn about Spring-Boot concepts', 1, 3, 1, NOW(), NULL);
INSERT INTO Issue (name, description, responsible, state_id, enabled, createdAt, updatedAt) 
VALUES ('Code Review of Spring-Boot Example', 'Review the Spring-Boot project and make comments about improvements', 2, 1, 1, NOW(), NULL);
