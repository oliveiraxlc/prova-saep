
CREATE TABLE psicologo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    descricao VARCHAR(20) NOT NULL
);

CREATE TABLE responsaveis (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone INT NOT NULL
);

CREATE TABLE criancas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    responsavel_id INT NOT NULL,

    FOREIGN KEY (responsavel_id)
        REFERENCES responsaveis(id) 
);

CREATE TABLE agendamentos (
    id SERIAL PRIMARY KEY,
    data_atendimento DATE NOT NULL,
    horario TIME NOT NULL,
    crianca_id INT NOT NULL,
    psicologo_id INT NOT NULL,

    FOREIGN KEY (crianca_id)
        REFERENCES criancas(id),

    FOREIGN KEY (psicologo_id)
        REFERENCES psicologo(id)
);




INSERT INTO psicologo (nome, login, senha, descricao) VALUES
('Administrador Principal', 'admin', 'admin123', 'ADMIN'),
('João Silva', 'jsilva', 'senha123', 'OPERADOR'),
('Maria Souza', 'msouza', 'senha123', 'OPERADOR');

INSERT INTO responsaveis (nome, login, senha, telefone) VALUES
('Administrador Principal', 'admin', 'admin123', '23423423'),
('João Silva', 'jsilva', 'senha123', '45454545'),
('Maria Souza', 'msouza', 'senha123', '7676767');

INSERT INTO criancas ( nome, responsavel_id, data_nascimento) VALUES
('jonas', 1, '2023-10-01 10:00:00'),
('gabriel' ,2, '2023-10-02 14:30:00' ),
('lucas', 3, '2023-10-05 09:15:00');

INSERT INTO agendamentos (
    data_atendimento,
    horario,
    crianca_id,
    psicologo_id
) VALUES
('2026-10-01', '08:00', 1, 1),
('2026-10-02', '09:00', 2, 2),
('2026-10-03', '10:00', 3, 3);


select * from agendamentos




