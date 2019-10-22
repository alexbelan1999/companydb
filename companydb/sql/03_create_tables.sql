USE `companydb`;

CREATE TABLE customers (id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  adress varchar(50) NOT NULL,
  total_pnumber int(10) NOT NULL,
  complet_pnumber int(10) NOT NULL,
  PRIMARY KEY (id)
  ) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE managers (id int (10) NOT NULL AUTO_INCREMENT, 
	surname varchar (25) NOT NULL,
	name varchar (25) NOT NULL, 
	patronymic varchar (25) NULL, 
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE project_data (id int(10) NOT NULL AUTO_INCREMENT,
  customer_id int(10) NOT NULL,
  project_name varchar(50) NOT NULL,
  start_date date NOT NULL,
  plan_end_date date NOT NULL,
  end_date date NULL,
  manager_id int(10) NOT NULL,
  success int(2) NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customers (id),
  FOREIGN KEY (manager_id) REFERENCES managers(id)
 ) ENGINE=INNODB DEFAULT CHARACTER SET utf8;