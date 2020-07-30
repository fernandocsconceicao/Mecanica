-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 30-Jul-2020 às 02:02
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mecanica_app`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `celular`, `cnpj`, `cpf`, `email`, `nome`, `telefone`) VALUES
(1, 'teste', NULL, '547935703497', 'fernando@bol.com', 'Fernando', '969644235'),
(2, 'teste', NULL, '87435703497', 'marcia@bol.com', 'Marcia', '318644235');

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `id` int(11) NOT NULL,
  `cor` varchar(255) DEFAULT NULL,
  `detalhes` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `tipo_veiculo` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`id`, `cor`, `detalhes`, `marca`, `modelo`, `tipo_veiculo`, `cliente_id`) VALUES
(1, 'Azul', 'carro com 3 portas', 'Volkswagen', 'Fusca', 'Carro', 1),
(2, 'Prata', 'potente', 'BMW', 'B600', 'Moto', 2),
(3, 'Preto', 'Tunado', 'Chevrolet', 'Celta', 'Carro', 2),
(4, 'Prata', 'Bem conservado', 'Volvo', 'v20', 'Caminhao', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `visita`
--

CREATE TABLE `visita` (
  `id` int(11) NOT NULL,
  `data_agendamento` datetime DEFAULT NULL,
  `data_visita` datetime DEFAULT NULL,
  `detalhes` varchar(255) DEFAULT NULL,
  `estado_pagamento` bit(1) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `veiculo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `visita`
--

INSERT INTO `visita` (`id`, `data_agendamento`, `data_visita`, `detalhes`, `estado_pagamento`, `cliente_id`, `veiculo_id`) VALUES
(1, '2015-04-26 12:00:00', '2015-05-01 15:00:00', 'Trocada a parafuseta', b'1', 2, 2),
(2, '2020-04-26 12:00:00', '2021-05-01 15:00:00', '', b'0', 1, 4),
(3, '2019-04-26 12:00:00', '2019-09-15 15:00:00', 'Trocada a bomba de combustivel', b'1', 2, 2),
(4, '2020-02-12 12:00:00', '2020-10-05 15:00:00', 'Trocada a parafuseta', b'1', 1, 1),
(5, '2020-02-12 12:00:00', '2020-10-05 15:00:00', 'Teste', b'1', 1, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_cmxo70m08n43599l3h0h07cc6` (`email`);

--
-- Índices para tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKny7f0cx7lnl40poaqcijjxyao` (`cliente_id`);

--
-- Índices para tabela `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4mbwg3oy1su3f2myoes4ityqx` (`cliente_id`),
  ADD KEY `FKc257skab8otnpeqkmwy4eq6ve` (`veiculo_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `visita`
--
ALTER TABLE `visita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `FKny7f0cx7lnl40poaqcijjxyao` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

--
-- Limitadores para a tabela `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `FK4mbwg3oy1su3f2myoes4ityqx` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKc257skab8otnpeqkmwy4eq6ve` FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
