-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 11 Juillet 2018 à 22:07
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tron`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_record` (IN `color` VARCHAR(255), IN `time` FLOAT)  NO SQL
INSERT INTO tron.scores (joueur, temps) VALUES (color, time)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `scores`
--

CREATE TABLE `scores` (
  `id` int(255) NOT NULL,
  `joueur` varchar(255) NOT NULL,
  `temps` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `scores`
--

INSERT INTO `scores` (`id`, `joueur`, `temps`) VALUES
(1, 'rouge', 2.409),
(2, 'rouge', 2.342),
(3, 'bleu', 2.687),
(4, 'rouge', 2.319),
(5, 'rouge', 2.305),
(6, 'rouge', 2.351),
(7, 'rouge', 3.096),
(8, 'bleu', 2.227),
(9, 'rouge', 2.174),
(10, 'rouge', 2.268),
(11, 'bleu', 2.578),
(12, 'rouge', 2.204),
(13, 'rouge', 1.31),
(14, 'rouge', 0.762),
(15, 'rouge', 1.258),
(16, 'rouge', 1.268),
(17, 'rouge', 1.237),
(18, 'rouge', 1.211);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `scores`
--
ALTER TABLE `scores`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
