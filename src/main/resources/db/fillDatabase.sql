use challenge;

INSERT INTO client(id, creationTime, updateTime, version, firstName, lastName, vatNumber, email, age, phone)
VALUES (1, TIMESTAMP ''2017-10-10 08:45:56.468'', TIMESTAMP ''2017-10-10 08:45:56.468'', 0, ''João'', ''Correia'', 237355612, ''joaopedro.ccorreia@gmail.com'', 32, 913979117 );

INSERT INTO user(userName, password, active, client_id)
VALUES (''João'', ''pass'', 1, 1);

INSERT INTO item(id, creationTime, updateTime, version, name, type, brand, isActive)
VALUES (1, TIMESTAMP ''2017-10-10 08:45:56.468'', TIMESTAMP ''2017-10-10 08:45:56.468'', 0, ''Mala'', ''Bag'', ''Gucci'', 1);

INSERT INTO client_item(client_id, item_id)
VALUES (1, 1);