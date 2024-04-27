CREATE TABLE IF NOT EXISTS client (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(200) NOT NULL,
    CHECK (LENGTH(name) >= 3)
    );

CREATE TABLE IF NOT EXISTS planet (
                                      id VARCHAR(15) PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CHECK (LENGTH(name) >= 1)
    );

CREATE TABLE IF NOT EXISTS ticket (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      created_at TIMESTAMP NOT NULL,
                                      client_id BIGINT,
                                      from_planet_id VARCHAR(15),
    to_planet_id VARCHAR(15),
    FOREIGN KEY(client_id) REFERENCES client(id),
    FOREIGN KEY(from_planet_id) REFERENCES planet(id),
    FOREIGN KEY(to_planet_id) REFERENCES planet(id)
    );