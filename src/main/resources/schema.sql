CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(128) NOT NULL,
    role VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS sensor_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS unit_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS sensors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    model VARCHAR(15) NOT NULL,
    location VARCHAR(40),
    description VARCHAR(200),
    range_value VARCHAR(50),
    type_id INTEGER NOT NULL,
    unit_id INTEGER NOT NULL,
    FOREIGN KEY (type_id) REFERENCES sensor_type(id),
    FOREIGN KEY (unit_id) REFERENCES unit_type(id)
);