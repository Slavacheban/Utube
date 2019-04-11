CREATE DATABASE new_schema;
USE new_schema;

CREATE table developers (ID int NOT NULL PRIMARY KEY auto_increment, Name varchar(255) NOT NULL, City varchar(255) NOT NULL, Age int);
CREATE table skills (ID int NOT NULL PRIMARY KEY auto_increment, Area varchar(255) NOT NULL, Skill varchar(255) NOT NULL);
CREATE table projects (ID int NOT NULL PRIMARY KEY auto_increment, Project varchar(255) NOT NULL, area varchar(255));
CREATE table companies (ID int NOT NULL PRIMARY KEY auto_increment, company_name varchar(255) NOT NULL, country varchar(255));
CREATE table customers (ID int NOT NULL PRIMARY KEY auto_increment, customer_name varchar(255) NOT NULL, budget int);

CREATE TABLE new_schema.dev_project (
  id_developer INT NOT NULL,
  id_project INT NOT NULL,
  PRIMARY KEY (id_developer, id_project),
  INDEX id_project_idx (id_project ASC) VISIBLE,
  CONSTRAINT id_developer
    FOREIGN KEY (id_developer)
    REFERENCES new_schema.developers (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT id_project
    FOREIGN KEY (id_project)
    REFERENCES new_schema.projects (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE new_schema.developer_skills (
  id_developer INT NOT NULL,
  id_skill INT NOT NULL,
  PRIMARY KEY (id_developer, id_skill),
  INDEX id_skill_idx (id_skill ASC) VISIBLE,
  CONSTRAINT developer_id
    FOREIGN KEY (id_developer)
    REFERENCES new_schema.developers (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT skill_id
    FOREIGN KEY (id_skill)
    REFERENCES new_schema.skills (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE new_schema.company_project (
  id_company INT NOT NULL,
  id_project INT NOT NULL,
  PRIMARY KEY (id_company),
  INDEX id_project_idx (id_project ASC) VISIBLE,
  CONSTRAINT id_company
    FOREIGN KEY (id_company)
    REFERENCES new_schema.companies (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT project_id
    FOREIGN KEY (id_project)
    REFERENCES new_schema.projects (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE new_schema.customer_project (
  id_customer INT NOT NULL,
  id_project INT NOT NULL,
  PRIMARY KEY (id_customer),
  INDEX project_number_idx (id_project ASC) VISIBLE,
  CONSTRAINT id_customer
    FOREIGN KEY (id_customer)
    REFERENCES new_schema.customers (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT project_number
    FOREIGN KEY (id_project)
    REFERENCES new_schema.projects (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO developers (Name, City, Age) VALUES ('Slava', 'Odessa', 24);
INSERT INTO developers (Name, City, Age) VALUES ('Vasya', 'Odessa', 33);
INSERT INTO developers (Name, City, Age) VALUES ('Petya', 'Kyev', 22);
INSERT INTO developers (Name, City, Age) VALUES ('Alex', 'Lviv', 30);
INSERT INTO developers (Name, City, Age) VALUES ('Ivan', 'Lviv', 26);
INSERT INTO developers (Name, City, Age) VALUES ('Lesya', 'Kyev', 25);

INSERT INTO skills(Area, Skill) VALUES('Java', 'Junior');
INSERT INTO skills(Area, Skill) VALUES('C++', 'Middle');
INSERT INTO skills(Area, Skill) VALUES('Java', 'Senior');
INSERT INTO skills(Area, Skill) VALUES('.NET', 'Junior');
INSERT INTO skills(Area, Skill) VALUES('Python', 'Middle');
INSERT INTO skills(Area, Skill) VALUES('Java', 'Senior');

INSERT INTO projects(Project, area) VALUES('Bank_Provider', 'Finance');
INSERT INTO projects(Project, area) VALUES('Hotel', 'business');
INSERT INTO projects(Project, area) VALUES('Book_analitics', 'knowledge');
INSERT INTO projects(Project, area) VALUES('Auto', 'roads');
INSERT INTO projects(Project, area) VALUES('Robot', 'IT');
INSERT INTO projects(Project, area) VALUES('Hoover', 'IT');

INSERT INTO companies(company_name, country) VALUES('IBM', 'USA');
INSERT INTO companies(company_name, country) VALUES('FaceBook', 'USA');
INSERT INTO companies(company_name, country) VALUES('Yandex', 'Russia');
INSERT INTO companies(company_name, country) VALUES('Google', 'USA');

INSERT INTO customers(customer_name, budget) VALUES('Bil Gates', 100);
INSERT INTO customers(customer_name, budget) VALUES('CRU', 200);
INSERT INTO customers(customer_name, budget) VALUES('NASA', 300);
INSERT INTO customers(customer_name, budget) VALUES('Министерство энергетики', 400);

INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (1, 2);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (2, 5);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (3, 2);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (3, 3);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (4, 5);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (4, 1);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (5, 1);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (5, 2);
INSERT INTO new_schema.dev_project (id_developer, id_project) VALUES (6, 5);

INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (1, 1);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (1, 2);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (1, 3);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (2, 2);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (2, 3);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (3, 4);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (4, 1);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (4, 5);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (5, 2);
INSERT INTO new_schema.developer_skills (id_developer, id_skill) VALUES (6, 6);

INSERT INTO new_schema.company_project (id_company, id_project) VALUES (1, 1);
INSERT INTO new_schema.company_project (id_company, id_project) VALUES (2, 2);
INSERT INTO new_schema.company_project (id_company, id_project) VALUES (3, 3);
INSERT INTO new_schema.company_project (id_company, id_project) VALUES (4, 4);

INSERT INTO new_schema.customer_project (id_customer, id_project) VALUES (1, 1);
INSERT INTO new_schema.customer_project (id_customer, id_project) VALUES (2, 2);
INSERT INTO new_schema.customer_project (id_customer, id_project) VALUES (3, 3);
INSERT INTO new_schema.customer_project (id_customer, id_project) VALUES (4, 4);

ALTER TABLE new_schema.developers
ADD COLUMN salary INT NOT NULL AFTER Age;
UPDATE new_schema.developers SET salary = 400 WHERE (ID = 1);
UPDATE new_schema.developers SET salary = 500 WHERE (ID = 2);
UPDATE new_schema.developers SET salary = 450 WHERE (ID = 3);
UPDATE new_schema.developers SET salary = 300 WHERE (ID = 4);
UPDATE new_schema.developers SET salary = 550 WHERE (ID = 5);
UPDATE new_schema.developers SET salary = 400 WHERE (ID = 6);

SELECT SUM(developers.salary), projects.Project  FROM dev_project
INNER JOIN projects ON dev_project.id_project = projects.ID
INNER JOIN developers ON dev_project.id_developer = developers.ID
group by projects.Project;

SELECT SUM(developers.salary), skills.Area  FROM developer_skills
INNER JOIN skills ON developer_skills.id_skill = skills.ID
INNER JOIN developers ON developer_skills.id_developer = developers.ID
WHERE skills.Area = 'Java';

ALTER TABLE new_schema.projects
ADD COLUMN cost INT NOT NULL AFTER area;
UPDATE new_schema.projects SET cost = 20000 WHERE (ID = 1);
UPDATE new_schema.projects SET cost = 40000 WHERE (ID = 2);
UPDATE new_schema.projects SET cost = 35000 WHERE (ID = 3);
UPDATE new_schema.projects SET cost = 75000 WHERE (ID = 4);
UPDATE new_schema.projects SET cost = 14000 WHERE (ID = 5);
UPDATE new_schema.projects SET cost = 10000 WHERE (ID = 6);

SELECT Project, MIN(cost) FROM projects;

SELECT avg(developers.salary) FROM dev_project
INNER JOIN developers ON dev_project.id_developer = developers.ID
INNER JOIN projects ON dev_project.id_project = projects.ID
HAVING (min(projects.cost));
