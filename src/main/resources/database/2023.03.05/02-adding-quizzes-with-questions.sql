--liquibase formatted sql
--changeset teddy-bear1999:3
USE quiz;

INSERT INTO quiz (description, type, min_score, created, updated)
VALUES ('Quiz 1', 'GEOGRAPHY', 1, NOW(), NOW()),
       ('Quiz 2', 'MOVIES', 3, NOW(), NOW()),
       ('Quiz 3', 'MATH', 3, NOW(), NOW()),
       ('Quiz 4', 'IT', 4, NOW(), NOW()),
       ('Quiz 5', 'LITERATURE', 3, NOW(), NOW()),
       ('Quiz 6', 'ART', 2, NOW(), NOW()),
       ('Quiz 7', 'MUSIC', 3, NOW(), NOW()),
       ('Quiz 8', 'MOVIES', 2, NOW(), NOW()),
       ('Quiz 9', 'OTHER', 2, NOW(), NOW()),
       ('Quiz 10', 'HISTORICAL', 4, NOW(), NOW()),
       ('Quiz 11', 'SPORTS', 5, NOW(), NOW());

INSERT INTO quiz_question (quiz_id, content, option_a, option_b, option_c, option_d, answer)
VALUES (1, 'What is the capital of France?', 'Paris', 'London', 'Berlin', 'Madrid', 1),
       (1, 'What is the tallest mountain in the world?', 'Mount Everest', 'Mount Kilimanjaro', 'Mount Denali',
        'Mount Fuji', 1),
       (1, 'What is the largest planet in our solar system?', 'Jupiter', 'Saturn', 'Neptune', 'Uranus', 1),
       (1, 'What is the chemical symbol for gold?', 'Au', 'Ag', 'Cu', 'Fe', 1),
       (1, 'Who painted the Mona Lisa?', 'Leonardo da Vinci', 'Pablo Picasso', 'Vincent van Gogh', 'Michelangelo', 1),
       (2, 'What is the highest grossing movie of all time?', 'Avatar', 'Avengers: Endgame', 'Titanic',
        'Star Wars: The Force Awakens', 2),
       (2, 'Who directed the movie Jaws?', 'Steven Spielberg', 'George Lucas', 'James Cameron', 'Christopher Nolan', 1),
       (2, 'What is the name of the first Harry Potter book?', 'Harry Potter and the Philosopher''s Stone',
        'Harry Potter and the Chamber of Secrets', 'Harry Potter and the Prisoner of Azkaban',
        'Harry Potter and the Goblet of Fire', 1),
       (3, 'What is the square root of 144?', '12', '11', '13', '14', 1),
       (3, 'What is the formula for the area of a circle?', 'pi * r^2', '2 * pi * r', 'pi * d', '2 * pi * d', 1);