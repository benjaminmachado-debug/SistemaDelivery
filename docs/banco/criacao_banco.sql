CREATE DATABASE IF NOT EXISTS db_delivery;
USE db_delivery;


-- Tabela: tb_cliente

CREATE TABLE IF NOT EXISTS tb_cliente (
    id_cliente  INT AUTO_INCREMENT PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    telefone    VARCHAR(20)  NOT NULL,
    endereco    VARCHAR(150) NOT NULL
);


-- Tabela: tb_categoria

CREATE TABLE IF NOT EXISTS tb_categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome         VARCHAR(60) NOT NULL
);


-- Tabela: tb_produto

CREATE TABLE IF NOT EXISTS tb_produto (
    id_produto   INT AUTO_INCREMENT PRIMARY KEY,
    nome         VARCHAR(100) NOT NULL,
    preco        DECIMAL(10,2) NOT NULL,
    id_categoria INT NOT NULL,
    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (id_categoria) REFERENCES tb_categoria(id_categoria)
);


-- Tabela: tb_pedido

CREATE TABLE IF NOT EXISTS tb_pedido (
    id_pedido        INT AUTO_INCREMENT PRIMARY KEY,
    data_pedido      DATE NOT NULL,
    forma_pagamento  VARCHAR(30) NOT NULL,
    status           VARCHAR(30) NOT NULL DEFAULT 'ABERTO',
    total            DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    id_cliente       INT NOT NULL,
    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente)
);


-- Tabela: tb_item_pedido

CREATE TABLE IF NOT EXISTS tb_item_pedido (
    id_item_pedido  INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido       INT NOT NULL,
    id_produto      INT NOT NULL,
    quantidade      INT NOT NULL,
    preco_unitario  DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_item_pedido
        FOREIGN KEY (id_pedido) REFERENCES tb_pedido(id_pedido),
    CONSTRAINT fk_item_produto
        FOREIGN KEY (id_produto) REFERENCES tb_produto(id_produto)
);


-- DADOS DE EXEMPLO (para testar o sistema)


INSERT INTO tb_cliente (nome, telefone, endereco) VALUES
('Joao Silva', '(51) 99999-1111', 'Rua das Flores, 123'),
('Maria Souza', '(51) 99999-2222', 'Av. Central, 456');

INSERT INTO tb_categoria (nome) VALUES
('Lanches'),
('Bebidas'),
('Sobremesas');

INSERT INTO tb_produto (nome, preco, id_categoria) VALUES
('X-Burguer', 18.90, 1),
('X-Salada', 20.50, 1),
('Refrigerante Lata', 6.00, 2),
('Suco Natural', 7.50, 2),
('Pudim', 9.00, 3);

INSERT INTO tb_pedido (data_pedido, forma_pagamento, status, total, id_cliente) VALUES
(CURDATE(), 'PIX', 'ABERTO', 0.00, 1);

INSERT INTO tb_item_pedido (id_pedido, id_produto, quantidade, preco_unitario) VALUES
(1, 1, 2, 18.90),
(1, 3, 2, 6.00);

-- Atualiza o total do pedido de exemplo (2x18.90 + 2x6.00 = 49.80)
UPDATE tb_pedido SET total = 49.80 WHERE id_pedido = 1;
