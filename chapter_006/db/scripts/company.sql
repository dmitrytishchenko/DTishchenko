CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name) VALUES (1, 'Gazprom'), (2, 'Lukoil'), (3, 'TatNeft'), (4, 'RosNeft'),(5, 'BashNeft');
INSERT INTO person (id, name, company_id) VALUES (1, 'Bob', 5), (2, 'Stiv', 4), (3, 'Bran', 3), (4, 'Peter', 2),
 (5, 'Rock', 1), (6, 'Martin', 1), (7, 'Vasia', 2), (8, 'Masha', 3);
/**
  1) Retrieve in a single query:
  -names of all persons that are NOT in the company with id = 5
  -company name for each person
 */
select p.name, c.name from person as p
join company as c
on p.id!=5 and c.id=p.company_p.key;

/**
 -Select the name of the company with the maximum number of persons + number of persons in this company
 */
select c.name, count(p.company_p.key)
from company as c
join person as p
on c.id=p.company_p.key
group by c.name
order by count desc limit 1;