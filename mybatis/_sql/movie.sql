CREATE TABLE `movie` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电影名',
 `director` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导演',
 `score` double(2,1) DEFAULT 0.0 COMMENT '评分',
  `show_date` varchar(20) DEFAULT '' COMMENT '上映时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出演电影表';

insert into movie values
(1,'武林外传','尚敬',9.0,'2006'),
(2,'捉妖记','许诚毅',5.2,'2015'),
(3,'北风那个吹','安建',7.2,'2008'),
(4,'王的盛宴','陆川',8.4,'2012'),
(5,'送我上青云','滕丛丛',8.0,'2019'),
(6,'大秦帝国之纵横','丁黑',6.8,'2013'),
(7,'余生请多指教','易术',7.1,'2018'),
(8,'小兵张嗄','徐光耀',9.1,'2004'),
(9,'炊事班的故事','尚敬',8.2,'2002');

CREATE TABLE `user_movie` (
  `user_id` int(11) NOT NULL COMMENT 'user表的id',
  `movie_id` int(11) NOT NULL COMMENT 'movie表的id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='演员电影表';

insert into user_movie values
(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(1,2),
(1,3),(2,4),(5,5),(4,6),(4,7),(3,8),(2,9),(6,9),(7,9);