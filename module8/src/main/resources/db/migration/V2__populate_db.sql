INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
                                                       ('Linus Torvalds', '1969-12-28', 'Trainee', 800),
                                                       ('Guido van Rossum', '1956-01-31', 'Junior', 1200),
                                                       ('Donald Knuth', '1938-01-10', 'Middle', 2500),
                                                       ('Bjarne Stroustrup', '1950-12-30', 'Senior', 4500),
                                                       ('Grace Hopper', '1906-12-09', 'Trainee', 900),
                                                       ('Margaret Hamilton', '1936-08-17', 'Junior', 1300),
                                                       ('Alan Turing', '1912-06-23', 'Middle', 2700),
                                                       ('Ada Lovelace', '1915-12-10', 'Senior', 4800),
                                                       ('John McCarthy', '1927-09-04', 'Trainee', 950),
                                                       ('Dennis Ritchie', '1941-09-09', 'Junior', 1400);

INSERT INTO client (NAME) VALUES
                              ('Google'),
                              ('Microsoft'),
                              ('Apple'),
                              ('Amazon'),
                              ('Facebook');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
                                                             (1, '2023-01-01', '2023-03-15'),
                                                             (2, '2023-02-10', '2023-06-20'),
                                                             (3, '2023-04-05', '2023-07-30'),
                                                             (4, '2023-06-15', '2024-01-10'),
                                                             (5, '2023-08-20', '2024-03-05'),
                                                             (1, '2023-10-10', '2024-02-25'),
                                                             (1, '2024-01-05', '2024-07-20'),
                                                             (1, '2024-03-15', '2024-09-10'),
                                                             (2, '2024-05-20', '2024-11-05'),
                                                             (3, '2024-07-10', '2025-01-20');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 3),
                                                       (3, 4),
                                                       (4, 5),
                                                       (4, 6),
                                                       (4, 7),
                                                       (5, 8),
                                                       (5, 9),
                                                       (5, 10);