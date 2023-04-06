CREATE DATABASE my_sql;
USE my_sql;
CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR(50),
    telefone VARCHAR(20)
);
INSERT INTO clientes (id, nome, email, telefone)
VALUES (1, 'João da Silva', 'joao.silva@gmail.com', '555-1234'),
       (2, 'Maria Souza', 'maria.souza@gmail.com', '555-5678'),
       (3, 'Carlos Ferreira', 'carlos.ferreira@gmail.com', '555-9012');

