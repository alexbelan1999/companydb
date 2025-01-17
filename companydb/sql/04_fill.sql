INSERT INTO customers VALUES (1,'EPAM','ul. Academician Kuprevich, 1, k. 1', 2, 0),
  (2,'ASWardag','ul. Brovki 4B, office 63',1, 1),
  (3,'Mainsoft','ul. Communist, 16',1, 1),
  (4,'Game Factory','ul. Chkalov 56a',1, 0),
  (5,'ArtVebBay','ul. Of Truth, 46-17',1, 1),
  (6,'Redline','Frunze 81, 33a, office 511',1, 1),
  (7,'iTechArt','ul. Tolstoy, 10',1, 1),
  (8,'GoodSoft','Prospect Chernyakhovsky, 44 of.216',1, 1),
  (9,'ConnectOne','Frunze 77/2',1, 1),
  (10,'PCB Vitebsk','ul. Zamkovaya, 4-3, cab. 304',1, 0),
  (11,'LACIT','st. Lazo 149,',1, 1);

INSERT INTO managers VALUES (1,'Ivanov','Ivan','Ivanovich'),
  (2,'Petrov','Peter','Petrovich'),
  (3,'Sidorov','Sidor','Sidorovich'),
  (4,'Sergeev','Sergei','Sergeevich'),
  (5,'Alekseev','Alexey','Alexeyevich'),
  (6,'Yeleseev','Elisha','Eleseevich'),
  (7,'Egorov','Egor','Egorovich'),
  (8,'Dimitrov','Dmitriy','Dmitrievich'),
  (9,'Andreev','Andrei','Andreevich'),
  (10,'Antonov','Anton','Antonovich'),
  (11,'Pavlov','Pavel','Pavlovich'),
  (12,'Borisov','Boris','Borisovich');

INSERT INTO project_data VALUES (1,1,'Test program','2012-12-12','2013-02-01',NULL,1,0),
  (2,1,'Database','2014-12-16','2015-06-17',NULL,2,0),
  (3,2,'Website','2015-06-10','2015-09-15','2015-08-25',3,1),
  (4,3,'Internet banking','2015-10-15','2016-02-15','2016-01-13',4,1),
  (5,4,'Half Life 3','2016-06-16','2026-06-17',NULL,5,0),
  (6,5,'Graphics editor','2016-07-18','2016-11-12','2016-11-23',6,1),
  (7,6,'Text editor','2017-01-09','2017-03-12','2017-03-05',7,1),
  (8,7,'Engineering calculator','2017-02-08','2017-05-09','2017-05-05',8,1),
  (9,8,'Mail client','2017-03-11','2017-08-27','2017-07-17',9,1),
  (10,9,'New browser','2017-07-13','2017-10-09','2017-11-19',10,1),
  (11,10,'Hello world','2016-02-21','2018-07-01','2018-04-04',11,0),
  (12,11,'OpenCV','2018-06-24','2018-06-27','2018-06-27',12,1);

insert into `roles`(id,`role`) VALUES 
	('1','admin'),
	('2','manager'),
	('3','user');

insert into `users`(id,`login`,`password`,`role_id`) VALUES 
	('1','admin','12345',1),
	('2','manager','1234',2),
	('3','user','123',3);