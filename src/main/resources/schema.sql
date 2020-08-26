CREATE TABLE IF NOT EXISTS Person (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    first_name VARCHAR(50) NOT NULL COMMENT 'Имя',
    age        INTEGER  NOT NULL    COMMENT 'Возраст'
) COMMENT='Человек';

CREATE TABLE IF NOT EXISTS Organization
(
    id       INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    version  INTEGER,
    fullName VARCHAR(50),
    address  VARCHAR(50),
    inn      INTEGER,
    kpp      INTEGER,
    phone    INTEGER,
    isActive BOOLEAN
);

CREATE TABLE IF NOT EXISTS Person_Organization
(
    person_id       INTEGER NOT NULL,
    organization_id INTEGER NOT NULL,

    PRIMARY KEY (person_id, organization_id)
);

ALTER TABLE Person_Organization ADD INDEX (organization_id);
ALTER TABLE Person_Organization
    ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);

ALTER TABLE Person_Organization ADD INDEX (person_id);
ALTER TABLE Person_Organization
    ADD FOREIGN KEY (person_id) REFERENCES Person (id);