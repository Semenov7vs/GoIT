CREATE TABLE IF NOT EXISTS worker (
                                      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000),
    BIRTHDAY DATE CHECK (YEAR(BIRTHDAY) > 1900),
    LEVEL VARCHAR(20) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    SALARY INTEGER NOT NULL CHECK (SALARY >= 100 AND SALARY <= 100000)
    );

CREATE TABLE IF NOT EXISTS client (
                                      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
    );

CREATE TABLE IF NOT EXISTS project (
                                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       CLIENT_ID BIGINT REFERENCES client(ID),
    START_DATE DATE,
    FINISH_DATE DATE
    );

CREATE TABLE IF NOT EXISTS project_worker (
                                              PROJECT_ID BIGINT REFERENCES project(ID),
    WORKER_ID BIGINT REFERENCES worker(ID),
    PRIMARY KEY (PROJECT_ID, WORKER_ID)
    );
