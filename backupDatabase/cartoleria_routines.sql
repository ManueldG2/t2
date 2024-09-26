
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `article-all` ()  NO SQL SELECT article.title, article.description, article.characteristic, category.name AS Categoria, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `article-id` (IN `getid` INT)   SELECT article.title, article.description, article.characteristic, category.name as category, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  
FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id
AND article.id=getid$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `warehouse-all` ()  NO SQL SELECT article.title, article.description, article.characteristic, category.name AS Categoria, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `warehouse-id` (IN `getid` INT)   SELECT article.title, article.description, article.characteristic, category.name AS Categoria, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article 
JOIN warehouse ON article.warehouse_id = warehouse.id
JOIN category ON article.category = category.id AND warehouse.id = getid$$

DELIMITER ;
