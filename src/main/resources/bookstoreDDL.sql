DROP DATABASE IF EXISTS BookStore;

CREATE DATABASE IF NOT EXISTS BookStore;
USE BookStore;


CREATE TABLE Author
(
  Id      INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
  Name    VARCHAR(100)           NOT NULL,
  Surname VARCHAR(100)           NOT NULL,
  DOB     DATE                   NOT NULL
);


CREATE TABLE Book
(
  Id          INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
  Name        VARCHAR(255)           NOT NULL,
  Author      INT                    NOT NULL,
  Genre       VARCHAR(100),
  Language    VARCHAR(100),
  PubDate     DATE,
  Pages       INT,
  Price       DECIMAL,
  Description LONGTEXT,
  FOREIGN KEY (Author) REFERENCES Author (Id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE Client
(
  Id       INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
  Name     VARCHAR(100)           NOT NULL,
  Surname  VARCHAR(100)           NOT NULL,
  Phone    VARCHAR(10),
  Address  VARCHAR(200),
  Email    VARCHAR(200) UNIQUE    NOT NULL,
  Password VARCHAR(15) UNIQUE     NOT NULL
);


CREATE TABLE Card
(
  Id       INT     NOT NULL UNIQUE NOT NULL AUTO_INCREMENT,
  IdClient INT     NOT NULL,
  IdBook   INT     NOT NULL,
  Status   BOOLEAN NOT NULL,
  FOREIGN KEY (IdBook) REFERENCES Book (Id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (IdClient) REFERENCES Client (Id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

