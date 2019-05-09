DELETE
FROM zooanimals;

DELETE
FROM animal;

DELETE
FROM telephone;

DELETE
FROM zoo;

INSERT INTO zoo (zooid, zooname)
         VALUES (1, 'Gladys Porter Zoo'),
                (2, 'Point Defiance Zoo'),
                (3, 'San Diego Zoo'),
                (4, 'San Antonio Zoo'),
                (5, 'Smithsonian National Zoo');

INSERT INTO telephone(phoneid, phonetype, phonenumber, zooid)
         VALUES (1, 'main', '555-555-5555', 1),
                (2, 'education', '555-555-1234', 1),
                (3, 'membership', '555-555-4321', 1),
                (4, 'main', '123-555-5555', 4),
                (5, 'main', '555-123-5555', 3);

INSERT INTO animal (animalid, animaltype)
         VALUES (1, 'lion'),
                (2, 'bear'),
                (3, 'monkey'),
                (4, 'penguin'),
                (5, 'tiger'),
                (6, 'bear'),
                (7, 'turtle');

INSERT INTO zooanimals (zooid, animalid)
         VALUES (1, 1),
                (2, 2),
                (1, 2),
                (5, 7),
                (5, 6),
                (5, 5),
                (5, 1),
                (3, 1),
                (3, 2);

alter sequence hibernate_sequence restart with 10;
