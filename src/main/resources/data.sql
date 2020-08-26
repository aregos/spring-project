INSERT INTO Organization (id, version, name, address) VALUES (1, 0, 'Sony', 'ул.Цюрупы, 16');

INSERT INTO Organization (id, version, name, address) VALUES (2, 0, 'Apple', 'ул.Лунина, 7');

INSERT INTO Person (id, version, first_name, age) VALUES (1, 0, 'Пётр', 20);

INSERT INTO Person (id, version, first_name, age) VALUES (2, 0, 'John', 25);

INSERT INTO Person_Organization (person_id, organization_id) VALUES (1, 1);

INSERT INTO Person_Organization (person_id, organization_id) VALUES (2, 2);