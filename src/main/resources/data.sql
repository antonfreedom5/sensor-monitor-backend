INSERT INTO users (id, username, password, role)
VALUES (1, 'admin', '{bcrypt}$2a$10$CFGef97bQtt.SmwKv26VueGLwjDo3zgpI75IMcO9ONdOQ6D9E9cUe', 'ADMINISTRATOR'),
       (2, 'user', '{bcrypt}$2a$10$CFGef97bQtt.SmwKv26VueGLwjDo3zgpI75IMcO9ONdOQ6D9E9cUe', 'VIEWER') ON CONFLICT DO NOTHING;

INSERT INTO sensor_type (id, name)
VALUES (1, 'Pressure'),
       (2, 'Voltage'),
       (3, 'Temperature'),
       (4, 'Humidity')  ON CONFLICT DO NOTHING;

INSERT INTO unit_type (id, name)
VALUES (1, 'bar'),
       (2, 'voltage'),
       (3, '°С'),
       (4, '%')  ON CONFLICT DO NOTHING;

INSERT INTO sensors (name, model, location, description, range_value, type_id, unit_id)
VALUES ('Sensor 1', 'PC33-56', 'Room 1', 'Description', '0-16', 1, 1),
       ('Sensor 2', 'EH-567', 'Room 2', 'Description','-25-25', 2, 2),
       ('Sensor 3', 'TER-21', 'Room 3', 'Description', '-70-50', 3, 3),
       ('Sensor 4', 'H94', 'Room 4', 'Description', '0-100', 4, 4),
       ('Sensor 6', 'PC33-21', 'Room 2', 'Description', '-70-50', 3, 3),
       ('Sensor 7', 'EH-21', 'Room 1', 'Description', '-70-50', 2, 1),
       ('Sensor 8', 'H-21', 'Room 3', 'Description', '-70-50', 1, 2) ON CONFLICT DO NOTHING;