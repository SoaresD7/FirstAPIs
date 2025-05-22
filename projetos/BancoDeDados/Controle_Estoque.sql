CREATE DATABASE Controle_Estoque;
USE Controle_Estoque;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    endereco VARCHAR(100),
    setor VARCHAR(50)
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    quantidade INT,
    status VARCHAR(20)
);

CREATE TABLE saida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE,
    id_usuario INT,
    id_produto INT,
    quantidade_saida INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id)
);
