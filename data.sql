
DELETE
FROM zooanimals;

DELETE
FROM animals;

DELETE
FROM telephones;

DELETE
FROM zoos;

INSERT INTO zoos (zooid, zooname, created_by, created_date, last_modified_by, last_modified_date)
         VALUES (1, 'Gladys Porter Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (2, 'Point Defiance Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (3, 'San Diego Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (4, 'San Antonio Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 'Smithsonian National Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO telephones (phoneid, phonetype, phonenumber, zooid, created_by, created_date, last_modified_by, last_modified_date)
         VALUES (1, 'MAIN', '555-555-5555', 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (2, 'EDUCATION', '555-555-1234', 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (3, 'MEMBERSHIP', '555-555-4321', 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (4, 'MAIN', '123-555-5555', 4, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 'MAIN', '555-123-5555', 3, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO animals (animalid, animaltype, created_by, created_date, last_modified_by, last_modified_date)
         VALUES (1, 'lion', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (2, 'bear', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (3, 'monkey', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (4, 'penguin', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 'tiger', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (6, 'llama',  'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (7, 'turtle', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO zooanimals (zooid, animalid, incomingzoo, created_by, created_date, last_modified_by, last_modified_date)
         VALUES (1, 1, 'Point Defiance Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (2, 2, 'Gladys Porter Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (1, 2, 'Point Defiance Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 7, 'San Diego Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 6, 'Gladys Porter Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 5, 'Gladys Porter Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (5, 1, 'Gladys Porter Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (3, 1, 'Gladys Porter Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP),
                (3, 2, 'Point Defiance Zoo', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

/*
We must tell hibernate the ids that have already been used.
The number must be larger than the last used id.
10 > 7 so we are good!
 */

alter sequence hibernate_sequence restart with 10;