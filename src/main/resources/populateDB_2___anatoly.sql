
-- Добавить разработчикам поле (salary - зарплата) 


ALTER TABLE developers ADD COLUMN salary integer;


UPDATE developers SET salary = 38000
WHERE id = 1;

UPDATE developers SET salary = 25000
WHERE id = 2;

UPDATE developers SET salary = 33000
WHERE id = 3;

UPDATE developers SET salary = 50000
WHERE id = 4;

UPDATE developers SET salary = 32000
WHERE id = 5;



-- Добавить поле (cost - стоимость) в таблицу Projects


ALTER TABLE projects ADD COLUMN cost integer;


UPDATE projects SET cost = 250000
WHERE id = 1;

UPDATE projects SET cost = 500000
WHERE id = 2;

UPDATE projects SET cost = 180000
WHERE id = 3;

UPDATE projects SET cost = 70000
WHERE id = 4;

UPDATE projects SET cost = 25000
WHERE id = 5;




-- Добавить поле (date - дата) в таблицу Projects


ALTER TABLE projects ADD COLUMN date date;


UPDATE projects SET date = '19-08-25'
WHERE id = 1;

UPDATE projects SET date = '18-11-02'
WHERE id = 2;

UPDATE projects SET date = '19-10-30'
WHERE id = 3;

UPDATE projects SET date = '18-05-11'
WHERE id = 4;

UPDATE projects SET date = '17-02-19'
WHERE id = 5;




----  Заполнить данными промежуточные таблицы  developers_skills,  developers_projects

INSERT INTO developers_skills (developers_id, skills_id) VALUES (1, 1);
INSERT INTO developers_skills (developers_id, skills_id) VALUES (2, 2);
INSERT INTO developers_skills (developers_id, skills_id) VALUES (3, 3);
INSERT INTO developers_skills (developers_id, skills_id) VALUES (4, 4);
INSERT INTO developers_skills (developers_id, skills_id) VALUES (5, 5);


--  Разработчики работают на многих проектах одновременно 

INSERT INTO developers_projects (projects_id, developers_id) VALUES (1, 1);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (2, 1);

INSERT INTO developers_projects (projects_id, developers_id) VALUES (3, 2);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (4, 2);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (5, 2);

INSERT INTO developers_projects (projects_id, developers_id) VALUES (1, 3);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (2, 3);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (3, 3);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (4, 3);

INSERT INTO developers_projects (projects_id, developers_id) VALUES (1, 4);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (5, 4);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (3, 4);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (4, 4);

INSERT INTO developers_projects (projects_id, developers_id) VALUES (2, 5);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (4, 5);
INSERT INTO developers_projects (projects_id, developers_id) VALUES (5, 5);



