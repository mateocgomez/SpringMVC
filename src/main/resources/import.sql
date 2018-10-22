INSERT INTO programas (codigo, nombre, apellido, promedio, materia, creditos, programa, precio) VALUES('624992', 'Mateo', 'Castaño', '71', 'JavaScript', '22', 'pregrado', '500000');


INSERT INTO monitorias (nombre, salon, horario, create_at) VALUES ('JavaScript', '101', '09:00 am - 10:00 am', '2019-01-10');
INSERT INTO monitorias (nombre, salon, horario, create_at) VALUES ('Arquitectura de Software', '101', '09:00 am - 10:00 am', '2019-01-10');
INSERT INTO monitorias (nombre, salon, horario, create_at) VALUES ('Spring Boot', '101', '09:00 am - 10:00 am', '2019-01-10');
INSERT INTO monitorias (nombre, salon, horario, create_at) VALUES ('Redes Convergentes', '101', '11:00 am - 1:00 pm', '2019-01-10');

INSERT INTO `users` (username, password, enabled) VALUES ('624992', '$2a$10$P/TNh5Mr5kkbKAPO9ebOAeiMO.cnxY0OVh4w4.7JKQcnFXkKpwvS2', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin', '$2a$10$gKVymW6Y4UoTE9n55odA0erBYKk0VMmidtOvbeNJXXUAjzYyLt8p6', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('504974', '$2a$10$Y6/NMix7nXegZgOubK35Mehd7kttaUPIB6jBcvq.KCnO2kyuMXNnO', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('625023', '$2a$10$1jU.fiXa.y4MgPQYSIBRYeQvdN/hItGUwhPakyfTk90JvkVWvmAa2', 1);

INSERT INTO `authorities` (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2, 'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (3, 'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (4, 'ROLE_USER');