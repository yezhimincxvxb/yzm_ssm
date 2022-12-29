CREATE TABLE `account` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `user_id` int(11) NOT NULL COMMENT 'user表的id',
   `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账户名',
   `pay_password` varchar(20) DEFAULT NULL COMMENT '支付密码',
   `total_money` double(20,2) DEFAULT NULL COMMENT '总资金',
  `available_money` double(20,2) DEFAULT NULL COMMENT '可用资金',
  `frozen_money` double(20,2) DEFAULT NULL COMMENT '冻结资金',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='账号资金表';

CREATE DEFINER=`root`@`localhost` TRIGGER `money_change` BEFORE UPDATE ON `account` FOR EACH ROW BEGIN
                                                                SET new.total_money = (new.available_money + new.frozen_money);
END;

insert into account values
(1,1,"佟湘玉","tongxiangyu",100000,100000,0,0,now(),now()),
(2,2,"白展堂","baizhantang",6000,6000,0,0,now(),now()),
(3,3,"莫小贝","moxiaobei",500,500,0,0,now(),now()),
(4,4,"吕轻侯","lvqinghou",9000,9000,0,0,now(),now()),
(5,5,"郭芙蓉","guofurong",2000,2000,0,0,now(),now()),
(6,6,"李秀莲","lixiulian",4000,4000,0,0,now(),now()),
(7,7,"邢育森","laoxing",8000,8000,0,0,now(),now());