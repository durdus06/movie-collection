DROP DATABASE IF EXISTS moviecollection;
CREATE DATABASE moviecollection;
USE moviecollection;

CREATE TABLE genre (
	id INT AUTO_INCREMENT,
	name VARCHAR(50),
	CONSTRAINT pk_genre_id PRIMARY KEY (id) 

);

CREATE TABLE movie (
	id INT AUTO_INCREMENT,
	code VARCHAR(20),
	name VARCHAR(50),
	director VARCHAR(50),
	year INT,
	description VARCHAR(255),
	genre_id INT,
	CONSTRAINT pk_movie_id PRIMARY KEY (id),
 	CONSTRAINT fk_movie_genre_id FOREIGN KEY (genre_id) REFERENCES genre (id)
);

CREATE TABLE cast (
	id INT AUTO_INCREMENT,
    real_full_name VARCHAR(50),
    role_name VARCHAR(50),
    sequence_number INT,
    movie_id INT,
    CONSTRAINT pk_cast_id PRIMARY KEY (id),
    CONSTRAINT fk_cast_movie_id FOREIGN KEY (movie_id) REFERENCES movie (id)
);

CREATE TABLE language (
 id INT AUTO_INCREMENT,
 name VARCHAR(50),
 CONSTRAINT pk_language_id PRIMARY KEY (id)
);

CREATE TABLE movie_lang (
	movie_id INT,
	lang_id INT,
	CONSTRAINT fk_movie_lang_movie_id FOREIGN KEY (movie_id) REFERENCES movie (id),
	CONSTRAINT fk_movie_lang_language_id FOREIGN KEY (lang_id) REFERENCES language (id)

);
CREATE TABLE users (
	id INT AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	password VARCHAR(64),
	email VARCHAR(100),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

CREATE TABLE roles (
 id INT AUTO_INCREMENT,
 name VARCHAR(50),
 CONSTRAINT pk_role_id PRIMARY KEY (id)
);
CREATE TABLE users_roles (
	user_id INT,
    role_id INT,
    CONSTRAINT fk_users_roles_users_user_id FOREIGN KEY (user_id) REFERENCES users (id),
	CONSTRAINT fk_users_roles_roles_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);


-- adding two roles
INSERT INTO roles(id,name) VALUES (1,'ADMIN');
INSERT INTO roles(id,name) VALUES (2,'USER');


-- adding three categories
INSERT INTO genre (name) VALUES ('Drama');
INSERT INTO genre (name) VALUES ('Science Fiction');
INSERT INTO genre (name)VALUES ('Mystery');

-- adding 10 languages 
INSERT INTO language (name) VALUES ('Turkish'),('English'),('German'),('French'),('Russian'),
('Italian'),('Japanese'),('Dutch'),('Hindi'),('Chinese'),('Norwegian');

-- adding two users 
INSERT INTO users 
(first_name, last_name, password, email) 
VALUES ('Selahattin', 'Durdu', '$2a$10$vN6s2CXKU5Tc00VJjQgLLOE0SvL28O0DxMdaZCqqtiCmBqDu1/DL.', 'durdu.s06@gmail.com');
INSERT INTO users 
(first_name, last_name, password, email) 
VALUES ('Deniz', 'Buğdaycı', '$2a$10$VoAAW6QB1ifE3DgQ1bF9W.fdUnhxvhLljDBzBuwzOdabul6eaHOd6', 'sn.durdu@gmail.com');

-- adding values into users_roles table
INSERT INTO users_roles(user_id, role_id) VALUES (1,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,2);


-- adding five movies
INSERT INTO movie (code, name, director, year, description, genre_id)
VALUES ('MVDABC123DEFX', 'Nam Aliquet', 'Ut Luctus', 1994, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum egestas dolor eleifend hendrerit tincidunt. Quisque et sapien diam. Suspendisse vel ipsum nulla. Aenean libero nisi, elementum sit amet libero id, laoreet congue orci. Mauris porttitor.', 1 );
INSERT INTO movie (code, name, director, year, description,  genre_id)
VALUES ('MVDDEF123DEFX', 'Donec Eget', 'Orci Varius', 2007, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi felis lacus, dapibus non ex nec, maximus facilisis est. Vestibulum ullamcorper fermentum volutpat. Proin in ipsum et nisi ornare consequat. Interdum et malesuada fames ac ante.',  2 );
INSERT INTO movie (code, name, director, year, description,  genre_id)
VALUES ('MVDPQR123WGTX', 'Sed Eget', 'Integer Pellentesque',  2014, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam id quam sit amet nulla aliquam pretium. Pellentesque tincidunt eros mi, ut facilisis lectus tincidunt et. Maecenas congue finibus velit, vel sodales metus. Fusce venenatis elementum.',  2 );
INSERT INTO movie (code, name, director, year, description, genre_id)
VALUES ('MVDMNO123PQRX', 'Nullam et Tortor','Curabitur Semper', 2008,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in eros lacus. Cras eget ex est. Suspendisse potenti. Donec molestie dui eget magna consectetur pulvinar. Etiam non vestibulum risus. Aliquam lacinia neque sit amet pretium.',  1 );
INSERT INTO movie (code, name, director, year, description, genre_id)
VALUES ('MVDABCXYZDEFX', 'Curabitur Erat', 'Pellentesque Habitant',  2006, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tempus malesuada purus quis consectetur. In in auctor neque. Vivamus faucibus varius lorem, sed volutpat magna rutrum eget. Praesent eu nulla ac augue sodales dignissim et.',  3 );

-- adding languages for the movies
INSERT INTO movie_lang (movie_id,lang_id) VALUES(1,1);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(1,2);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(2,1);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(3,1);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(3,2);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(4,2);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(4,3);
INSERT INTO movie_lang (movie_id,lang_id) VALUES(5,1);

INSERT INTO cast (real_full_name,role_name,sequence_number,movie_id)
VALUES ('Suspendisse Tristique', 'Nunc Volutpat', 1, 1);
INSERT INTO cast (real_full_name,role_name,sequence_number,movie_id)
VALUES ('Phasellus Dictum', 'Morbi Convallis', 1, 2);
INSERT INTO cast (real_full_name,role_name,sequence_number,movie_id)
VALUES ('Vestibulum Maximus', 'Suspendisse Luctus', 1, 3);
INSERT INTO cast (real_full_name,role_name,sequence_number,movie_id)
VALUES ('Duis Suscipit', 'Quisque Pharetra', 1, 4);
