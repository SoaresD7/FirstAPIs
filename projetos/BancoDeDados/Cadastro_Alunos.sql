create database cadastro_Alunos;
use Cadastro_Alunos;

-- Criação da tabela aluno
CREATE TABLE alunos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);