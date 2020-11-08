-- PostgreSQL version: 12.0

CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');
CREATE TYPE level AS ENUM ('JUNIOR', 'MIDDLE', 'SENIOR');

drop table if exists developers;
CREATE TABLE developers (
	id serial NOT NULL,
	name character varying(200),
	gender gender,
	age int2,
	CONSTRAINT id1 PRIMARY KEY (id)

);

drop table if exists projects;
CREATE TABLE projects (
	id serial NOT NULL,
	projects_name character varying(200),
	CONSTRAINT id2 PRIMARY KEY (id)

);

drop table if exists companies;
CREATE TABLE companies (
	id serial NOT NULL,
	company_name character varying(200),
	CONSTRAINT id3 PRIMARY KEY (id)

);

drop table if exists customers;
CREATE TABLE customers (
	id serial NOT NULL,
	name character varying(200),
	CONSTRAINT id4 PRIMARY KEY (id)

);

drop table if exists skills;
CREATE TABLE skills (
	id serial NOT NULL,
	language character varying(200),
	level level,
	CONSTRAINT id5 PRIMARY KEY (id)

);

drop table if exists customers_projects;
CREATE TABLE customers_projects (
	id serial NOT NULL,
	projects_id serial,
	customers_id serial,
	CONSTRAINT id6 PRIMARY KEY (id)

);

ALTER TABLE customers_projects ADD CONSTRAINT projects_fk FOREIGN KEY (id_projects)
REFERENCES projects (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE customers_projects ADD CONSTRAINT customers_fk FOREIGN KEY (id_customers)
REFERENCES customers (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

drop table if exists companies_projects;
CREATE TABLE companies_projects (
	id serial NOT NULL,
	projects_id serial,
	companies_id serial,
	CONSTRAINT id7 PRIMARY KEY (id)

);

ALTER TABLE companies_projects ADD CONSTRAINT projects_fk FOREIGN KEY (id_projects)
REFERENCES projects (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE companies_projects ADD CONSTRAINT companies_fk FOREIGN KEY (id_companies)
REFERENCES companies (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

drop table if exists developers_skills;
CREATE TABLE developers_skills (
	id serial NOT NULL,
	developers_id serial,
	skills_id serial,
	CONSTRAINT id8 PRIMARY KEY (id)

);

drop table if exists developers_projects;
CREATE TABLE developers_projects (
	id serial NOT NULL,
	projects_id serial,
	developers_id serial,
	CONSTRAINT id9 PRIMARY KEY (id)

);

ALTER TABLE developers_projects ADD CONSTRAINT projects_fk FOREIGN KEY (id_projects)
REFERENCES projects (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE developers_projects ADD CONSTRAINT developers_fk FOREIGN KEY (id_developers)
REFERENCES developers (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE developers_skills ADD CONSTRAINT skills_fk FOREIGN KEY (id_skills)
REFERENCES skills (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE developers_skills ADD CONSTRAINT developers_fk FOREIGN KEY (id_developers)
REFERENCES developers (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE customers_projects ADD CONSTRAINT projects_id FOREIGN KEY (projects_id)
REFERENCES projects (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE customers_projects ADD CONSTRAINT customers_id FOREIGN KEY (customers_id)
REFERENCES customers (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE companies_projects ADD CONSTRAINT projects_id FOREIGN KEY (projects_id)
REFERENCES projects (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE companies_projects ADD CONSTRAINT companies_id FOREIGN KEY (companies_id)
REFERENCES companies (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE developers_skills ADD CONSTRAINT developers_id FOREIGN KEY (developers_id)
REFERENCES developers (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE developers_skills ADD CONSTRAINT skills_id FOREIGN KEY (skills_id)
REFERENCES skills (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE developers_projects ADD CONSTRAINT projects_id FOREIGN KEY (projects_id)
REFERENCES projects (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE developers_projects ADD CONSTRAINT developers_id FOREIGN KEY (developers_id)
REFERENCES developers (id) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;

-- end --


