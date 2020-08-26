CREATE TABLE IF NOT EXISTS Person
(
    id         INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    version    INTEGER     NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    age        INTEGER     NOT NULL
);

CREATE TABLE IF NOT EXISTS Organization
(
    id       INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
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

CREATE INDEX IF NOT EXISTS IX_Person_Organization_Id ON Person_Organization (organization_id);
ALTER TABLE Person_Organization
    ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);

CREATE INDEX IF NOT EXISTS IX_Organization_Person_Id ON Person_Organization (person_id);
ALTER TABLE Person_Organization
    ADD FOREIGN KEY (person_id) REFERENCES Person (id);