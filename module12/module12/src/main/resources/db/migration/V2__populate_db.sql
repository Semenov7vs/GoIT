INSERT INTO client(name)
VALUES
    ('Taras Shevchenko'),
    ('Nikolai Gogol'),
    ('Mykhailo Kotsiubynsky'),
    ('Ivan Franko'),
    ('Mykhailo Skrypnyk'),
    ('Leonid Leskiv'),
    ('Oksana Zabuzhko'),
    ('Olha Stefanyk'),
    ('Panteleimon Kulish'),
    ('Ivan Panasenko');

INSERT INTO planet(id, name)
VALUES
    ('NEP', 'Neptune'),
    ('URA', 'Uranus'),
    ('EAR', 'Earth'),
    ('PLU', 'Pluto'),
    ('SAT', 'Saturn');

INSERT INTO ticket(created_at, client_id, from_planet_id, to_planet_id)
VALUES
    ('2024-04-27 10:30:00', 1, 'EAR', 'NEP'),
    ('2024-04-27 11:45:00', 2, 'EAR', 'URA'),
    ('2024-04-27 12:15:00', 3, 'EAR', 'PLU'),
    ('2024-04-27 13:20:00', 4, 'EAR', 'SAT'),
    ('2024-04-27 14:55:00', 5, 'NEP', 'SAT'),
    ('2024-04-27 10:35:00', 1, 'NEP', 'EAR'),
    ('2024-04-27 11:50:00', 2, 'URA', 'EAR'),
    ('2024-04-27 12:20:00', 3, 'PLU', 'EAR'),
    ('2024-04-27 13:25:00', 4, 'SAT', 'EAR'),
    ('2024-04-27 14:58:00', 5, 'SAT', 'NEP');