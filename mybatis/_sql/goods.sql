CREATE TABLE `goods` (
     `id` bigint NOT NULL AUTO_INCREMENT,
     `name` varchar(20) NOT NULL DEFAULT '' COMMENT '商品名',
     `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
     `left_num` int DEFAULT '0' COMMENT '库存',
     `version` int DEFAULT '0' COMMENT '版本',
     `update_date` datetime DEFAULT NULL COMMENT '更新时间',
     `create_date` datetime DEFAULT NULL COMMENT '创建时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品表';