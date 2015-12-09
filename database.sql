-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: 
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `EscolaPingoDeGenteDB`
--

CREATE DATABASE IF NOT EXISTS `EscolaPingoDeGenteDB` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `EscolaPingoDeGenteDB`;

DROP TABLE IF EXISTS `Album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Album` (
  `PK_Album` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`PK_Album`),
  UNIQUE (`titulo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `Imagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Imagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagem` mediumblob NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FK_Album` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Album` (`FK_Album`),
  CONSTRAINT `FK_Album` FOREIGN KEY (`FK_Album`) REFERENCES `Album` (`PK_Album`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Album`
--


--
-- Dumping data for table `Album`
--

LOCK TABLES `Album` WRITE;
/*!40000 ALTER TABLE `Album` DISABLE KEYS */;
INSERT INTO `Album` VALUES (1,'Álbum1','Descrição do álbum');
/*!40000 ALTER TABLE `Album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Imagem`
--




--
-- Table structure for table `Inicio`
--

DROP TABLE IF EXISTS `Inicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Inicio` (
  `quemSomos` varchar(254) DEFAULT NULL,
  `qualidade` varchar(254) DEFAULT NULL,
  `estrutura` varchar(254) DEFAULT NULL,
  `missao` varchar(254) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inicio`
--

LOCK TABLES `Inicio` WRITE;
/*!40000 ALTER TABLE `Inicio` DISABLE KEYS */;
INSERT INTO `Inicio` VALUES ('Fundada em 2003, a Escola de Educação Infantil Pingo de Gente está a 11 anos fornecendo serviços educacionais para crianças de 4 meses aos 5 anos em 11 meses.','As crianças são atendidas por profissionais qualificados e capacitados, de acordo com as normas existentes, operando sempre com um número pequeno de alunos por turma.','Conheça nossa estrutura física  e organizacional a disposição do seu filho.','Disponibilizar diferenciais educacionais praticando o ato de educar com qualidade, através de uma organização com princípios e valores adequados as necessidades dos clientes.',1);
/*!40000 ALTER TABLE `Inicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Noticias`
--

DROP TABLE IF EXISTS `Noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `texto` text NOT NULL,
  `imagem` blob,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Noticias`
--

LOCK TABLES `Noticias` WRITE;
/*!40000 ALTER TABLE `Noticias` DISABLE KEYS */;
INSERT INTO `Noticias` VALUES (9,'Segunda Notícia','<span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;A certificação de metodologias que nos auxiliam a lidar com a necessidade de renovação processual possibilita uma melhor visão global das condições financeiras e administrativas exigidas. Neste sentido, a complexidade dos estudos efetuados oferece uma interessante oportunidade para verificação dos conhecimentos estratégicos para atingir a excelência. No mundo atual, a determinação clara de objetivos exige a precisão e a definição do sistema de participação geral. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a mobilidade dos capitais internacionais auxilia a preparação e a composição das posturas dos órgãos dirigentes com relação às suas atribuições. Do mesmo modo, o novo modelo estrutural aqui preconizado garante a contribuição de um grupo importante na determinação das novas proposições.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A prática cotidiana prova que o entendimento das metas propostas nos obriga à análise do retorno esperado a longo prazo. É claro que a constante divulgação das informações estimula a padronização de todos os recursos funcionais envolvidos. As experiências acumuladas demonstram que a estrutura atual da organização faz parte de um processo de gerenciamento do processo de comunicação como um todo. Por outro lado, o surgimento do comércio virtual estende o alcance e a importância das diretrizes de desenvolvimento para o futuro.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No entanto, não podemos esquecer que o consenso sobre a necessidade de qualificação acarreta um processo de reformulação e modernização das regras de conduta normativas. É importante questionar o quanto a consulta aos diversos militantes desafia a capacidade de equalização das condições inegavelmente apropriadas. Percebemos, cada vez mais, que a consolidação das estruturas não pode mais se dissociar de alternativas às soluções ortodoxas. Pensando mais a longo prazo, o fenômeno da Internet apresenta tendências no sentido de aprovar a manutenção das diversas correntes de pensamento.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O que temos que ter sempre em mente é que a adoção de políticas descentralizadoras agrega valor ao estabelecimento do impacto na agilidade decisória. Gostaria de enfatizar que o acompanhamento das preferências de consumo prepara-nos para enfrentar situações atípicas decorrentes das formas de ação. Ainda assim, existem dúvidas a respeito de como o aumento do diálogo entre os diferentes setores produtivos maximiza as possibilidades por conta dos relacionamentos verticais entre as hierarquias.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todavia, a crescente influência da mídia é uma das consequências da gestão inovadora da qual fazemos parte. Podemos já vislumbrar o modo pelo qual a percepção das dificuldades talvez venha a ressaltar a relatividade dos modos de operação convencionais. O incentivo ao avanço tecnológico, assim como o desafiador cenário globalizado pode nos levar a considerar a reestruturação do sistema de formação de quadros que corresponde às necessidades.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o julgamento imparcial das eventualidades representa uma abertura para a melhoria dos procedimentos normalmente adotados. Acima de tudo, é fundamental ressaltar que a revolução dos costumes promove a alavancagem dos métodos utilizados na avaliação de resultados. Assim mesmo, o comprometimento entre as equipes deve passar por modificações independentemente do fluxo de informações. O empenho em analisar a expansão dos mercados mundiais aponta para a melhoria do orçamento setorial.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A nível organizacional, a contínua expansão de nossa atividade facilita a criação dos níveis de motivação departamental. Por conseguinte, a hegemonia do ambiente político cumpre um papel essencial na formulação dos paradigmas corporativos. Evidentemente, a valorização de fatores subjetivos causa impacto indireto na reavaliação do levantamento das variáveis envolvidas.</span>',NULL,'2015-12-06 00:32:59'),(10,'Terceira notícia','<span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;A certificação de metodologias que nos auxiliam a lidar com a necessidade de renovação processual possibilita uma melhor visão global das condições financeiras e administrativas exigidas. Neste sentido, a complexidade dos estudos efetuados oferece uma interessante oportunidade para verificação dos conhecimentos estratégicos para atingir a excelência. No mundo atual, a determinação clara de objetivos exige a precisão e a definição do sistema de participação geral. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a mobilidade dos capitais internacionais auxilia a preparação e a composição das posturas dos órgãos dirigentes com relação às suas atribuições. Do mesmo modo, o novo modelo estrutural aqui preconizado garante a contribuição de um grupo importante na determinação das novas proposições.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A prática cotidiana prova que o entendimento das metas propostas nos obriga à análise do retorno esperado a longo prazo. É claro que a constante divulgação das informações estimula a padronização de todos os recursos funcionais envolvidos. As experiências acumuladas demonstram que a estrutura atual da organização faz parte de um processo de gerenciamento do processo de comunicação como um todo. Por outro lado, o surgimento do comércio virtual estende o alcance e a importância das diretrizes de desenvolvimento para o futuro.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No entanto, não podemos esquecer que o consenso sobre a necessidade de qualificação acarreta um processo de reformulação e modernização das regras de conduta normativas. É importante questionar o quanto a consulta aos diversos militantes desafia a capacidade de equalização das condições inegavelmente apropriadas. Percebemos, cada vez mais, que a consolidação das estruturas não pode mais se dissociar de alternativas às soluções ortodoxas. Pensando mais a longo prazo, o fenômeno da Internet apresenta tendências no sentido de aprovar a manutenção das diversas correntes de pensamento.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O que temos que ter sempre em mente é que a adoção de políticas descentralizadoras agrega valor ao estabelecimento do impacto na agilidade decisória. Gostaria de enfatizar que o acompanhamento das preferências de consumo prepara-nos para enfrentar situações atípicas decorrentes das formas de ação. Ainda assim, existem dúvidas a respeito de como o aumento do diálogo entre os diferentes setores produtivos maximiza as possibilidades por conta dos relacionamentos verticais entre as hierarquias.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todavia, a crescente influência da mídia é uma das consequências da gestão inovadora da qual fazemos parte. Podemos já vislumbrar o modo pelo qual a percepção das dificuldades talvez venha a ressaltar a relatividade dos modos de operação convencionais. O incentivo ao avanço tecnológico, assim como o desafiador cenário globalizado pode nos levar a considerar a reestruturação do sistema de formação de quadros que corresponde às necessidades.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o julgamento imparcial das eventualidades representa uma abertura para a melhoria dos procedimentos normalmente adotados. Acima de tudo, é fundamental ressaltar que a revolução dos costumes promove a alavancagem dos métodos utilizados na avaliação de resultados. Assim mesmo, o comprometimento entre as equipes deve passar por modificações independentemente do fluxo de informações. O empenho em analisar a expansão dos mercados mundiais aponta para a melhoria do orçamento setorial.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A nível organizacional, a contínua expansão de nossa atividade facilita a criação dos níveis de motivação departamental. Por conseguinte, a hegemonia do ambiente político cumpre um papel essencial na formulação dos paradigmas corporativos. Evidentemente, a valorização de fatores subjetivos causa impacto indireto na reavaliação do levantamento das variáveis envolvidas.</span>',NULL,'2015-12-06 00:33:04'),(11,'Quarta notícia','<span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;A certificação de metodologias que nos auxiliam a lidar com a necessidade de renovação processual possibilita uma melhor visão global das condições financeiras e administrativas exigidas. Neste sentido, a complexidade dos estudos efetuados oferece uma interessante oportunidade para verificação dos conhecimentos estratégicos para atingir a excelência. No mundo atual, a determinação clara de objetivos exige a precisão e a definição do sistema de participação geral. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a mobilidade dos capitais internacionais auxilia a preparação e a composição das posturas dos órgãos dirigentes com relação às suas atribuições. Do mesmo modo, o novo modelo estrutural aqui preconizado garante a contribuição de um grupo importante na determinação das novas proposições.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A prática cotidiana prova que o entendimento das metas propostas nos obriga à análise do retorno esperado a longo prazo. É claro que a constante divulgação das informações estimula a padronização de todos os recursos funcionais envolvidos. As experiências acumuladas demonstram que a estrutura atual da organização faz parte de um processo de gerenciamento do processo de comunicação como um todo. Por outro lado, o surgimento do comércio virtual estende o alcance e a importância das diretrizes de desenvolvimento para o futuro.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No entanto, não podemos esquecer que o consenso sobre a necessidade de qualificação acarreta um processo de reformulação e modernização das regras de conduta normativas. É importante questionar o quanto a consulta aos diversos militantes desafia a capacidade de equalização das condições inegavelmente apropriadas. Percebemos, cada vez mais, que a consolidação das estruturas não pode mais se dissociar de alternativas às soluções ortodoxas. Pensando mais a longo prazo, o fenômeno da Internet apresenta tendências no sentido de aprovar a manutenção das diversas correntes de pensamento.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O que temos que ter sempre em mente é que a adoção de políticas descentralizadoras agrega valor ao estabelecimento do impacto na agilidade decisória. Gostaria de enfatizar que o acompanhamento das preferências de consumo prepara-nos para enfrentar situações atípicas decorrentes das formas de ação. Ainda assim, existem dúvidas a respeito de como o aumento do diálogo entre os diferentes setores produtivos maximiza as possibilidades por conta dos relacionamentos verticais entre as hierarquias.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todavia, a crescente influência da mídia é uma das consequências da gestão inovadora da qual fazemos parte. Podemos já vislumbrar o modo pelo qual a percepção das dificuldades talvez venha a ressaltar a relatividade dos modos de operação convencionais. O incentivo ao avanço tecnológico, assim como o desafiador cenário globalizado pode nos levar a considerar a reestruturação do sistema de formação de quadros que corresponde às necessidades.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o julgamento imparcial das eventualidades representa uma abertura para a melhoria dos procedimentos normalmente adotados. Acima de tudo, é fundamental ressaltar que a revolução dos costumes promove a alavancagem dos métodos utilizados na avaliação de resultados. Assim mesmo, o comprometimento entre as equipes deve passar por modificações independentemente do fluxo de informações. O empenho em analisar a expansão dos mercados mundiais aponta para a melhoria do orçamento setorial.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A nível organizacional, a contínua expansão de nossa atividade facilita a criação dos níveis de motivação departamental. Por conseguinte, a hegemonia do ambiente político cumpre um papel essencial na formulação dos paradigmas corporativos. Evidentemente, a valorização de fatores subjetivos causa impacto indireto na reavaliação do levantamento das variáveis envolvidas.</span>',NULL,'2015-12-06 00:33:08'),(14,'Primeira notícia','<span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;A certificação de metodologias que nos auxiliam a lidar com a necessidade de renovação processual possibilita uma melhor visão global das condições financeiras e administrativas exigidas. Neste sentido, a complexidade dos estudos efetuados oferece uma interessante oportunidade para verificação dos conhecimentos estratégicos para atingir a excelência. No mundo atual, a determinação clara de objetivos exige a precisão e a definição do sistema de participação geral. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a mobilidade dos capitais internacionais auxilia a preparação e a composição das posturas dos órgãos dirigentes com relação às suas atribuições. Do mesmo modo, o novo modelo estrutural aqui preconizado garante a contribuição de um grupo importante na determinação das novas proposições.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A prática cotidiana prova que o entendimento das metas propostas nos obriga à análise do retorno esperado a longo prazo. É claro que a constante divulgação das informações estimula a padronização de todos os recursos funcionais envolvidos. As experiências acumuladas demonstram que a estrutura atual da organização faz parte de um processo de gerenciamento do processo de comunicação como um todo. Por outro lado, o surgimento do comércio virtual estende o alcance e a importância das diretrizes de desenvolvimento para o futuro.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No entanto, não podemos esquecer que o consenso sobre a necessidade de qualificação acarreta um processo de reformulação e modernização das regras de conduta normativas. É importante questionar o quanto a consulta aos diversos militantes desafia a capacidade de equalização das condições inegavelmente apropriadas. Percebemos, cada vez mais, que a consolidação das estruturas não pode mais se dissociar de alternativas às soluções ortodoxas. Pensando mais a longo prazo, o fenômeno da Internet apresenta tendências no sentido de aprovar a manutenção das diversas correntes de pensamento.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O que temos que ter sempre em mente é que a adoção de políticas descentralizadoras agrega valor ao estabelecimento do impacto na agilidade decisória. Gostaria de enfatizar que o acompanhamento das preferências de consumo prepara-nos para enfrentar situações atípicas decorrentes das formas de ação. Ainda assim, existem dúvidas a respeito de como o aumento do diálogo entre os diferentes setores produtivos maximiza as possibilidades por conta dos relacionamentos verticais entre as hierarquias.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todavia, a crescente influência da mídia é uma das consequências da gestão inovadora da qual fazemos parte. Podemos já vislumbrar o modo pelo qual a percepção das dificuldades talvez venha a ressaltar a relatividade dos modos de operação convencionais. O incentivo ao avanço tecnológico, assim como o desafiador cenário globalizado pode nos levar a considerar a reestruturação do sistema de formação de quadros que corresponde às necessidades.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se o julgamento imparcial das eventualidades representa uma abertura para a melhoria dos procedimentos normalmente adotados. Acima de tudo, é fundamental ressaltar que a revolução dos costumes promove a alavancagem dos métodos utilizados na avaliação de resultados. Assim mesmo, o comprometimento entre as equipes deve passar por modificações independentemente do fluxo de informações. O empenho em analisar a expansão dos mercados mundiais aponta para a melhoria do orçamento setorial.&nbsp;</span><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><br style=\"font-family: \'Times New Roman\'; font-size: medium;\"><span style=\"font-family: \'Times New Roman\'; font-size: medium; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A nível organizacional, a contínua expansão de nossa atividade facilita a criação dos níveis de motivação departamental. Por conseguinte, a hegemonia do ambiente político cumpre um papel essencial na formulação dos paradigmas corporativos. Evidentemente, a valorização de fatores subjetivos causa impacto indireto na reavaliação do levantamento das variáveis envolvidas.</span>',NULL,'2015-12-06 00:32:34');
/*!40000 ALTER TABLE `Noticias` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `Calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Calendario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(80) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Calendario`
--

LOCK TABLES `Calendario` WRITE;
/*!40000 ALTER TABLE `Calendario` DISABLE KEYS */;
INSERT INTO `Calendario` VALUES (15,'titulo','desc','2015-12-23'),(16,'evento','desc','2015-12-30'),(17,'e','d','2016-01-12'),(18,'titulo evento','descricao evento','2016-05-04');
/*!40000 ALTER TABLE `Calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contato`
--

DROP TABLE IF EXISTS `Contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contato` (
  `endereco` varchar(254) DEFAULT NULL,
  `fone1` varchar(200) DEFAULT NULL,
  `fone2` varchar(200) DEFAULT NULL,
  `fone3` varchar(200) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contato`
--

LOCK TABLES `Contato` WRITE;
/*!40000 ALTER TABLE `Contato` DISABLE KEYS */;
INSERT INTO `Contato` VALUES ('Rua Nelson Ehlers, 379','054 3015-1155','054 9225-6713','054 9953-0084',1);
/*!40000 ALTER TABLE `Contato` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `Sobre`
--

DROP TABLE IF EXISTS `Sobre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sobre` (
  `quemSomos` text DEFAULT NULL,
  `historia` text DEFAULT NULL,
  `estrutura` text DEFAULT NULL,
  `missao` varchar(254) DEFAULT NULL,
  `visao` varchar(254) DEFAULT NULL,
  `valores` varchar(254) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sobre`
--

LOCK TABLES `Sobre` WRITE;
/*!40000 ALTER TABLE `Sobre` DISABLE KEYS */;
INSERT INTO `Sobre` VALUES ('Pingo de Gente','Fundada em...','Salas e Parquinho','Ensinar','Ensinar','Ensinar',1);
/*!40000 ALTER TABLE `Sobre` ENABLE KEYS */;
UNLOCK TABLES;
