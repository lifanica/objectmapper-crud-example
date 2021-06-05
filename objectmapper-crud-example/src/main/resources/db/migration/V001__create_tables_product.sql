-- objectmapper_example.product definition

CREATE TABLE `product` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `uuid` varchar(255) NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `description` varchar(225) NOT NULL,
                           `status` int(1) NOT NULL,
                           `created_by` bigint(20) DEFAULT NULL,
                           `creation_time` datetime NOT NULL DEFAULT current_timestamp(),
                           `last_update_by` bigint(20) DEFAULT NULL,
                           `last_update_time` datetime DEFAULT NULL ON UPDATE current_timestamp(),
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;