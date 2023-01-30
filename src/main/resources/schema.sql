DROP TABLE IF EXISTS pessoa, endereco;

CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL, 
    pessoa_id INT,
    principal BOOLEAN,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
