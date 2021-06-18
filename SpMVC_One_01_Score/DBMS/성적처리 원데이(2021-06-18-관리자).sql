CREATE DATABASE scScore;
CREATE USER scUser@localhost
IDENTIFIED BY '1234';

USE MYSQL;
SHOW GRANTS FOR scUser@localhost;

GRANT ALL PRIVILEGES ON *.* TO scUser@localhost;

DROP USER scUser@localhost;
