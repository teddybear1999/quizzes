--liquibase formatted sql
--changeset teddy-bear1999:7

INSERT INTO quiz_question (quiz_id, content, option_a, option_b, option_c, option_d, answer)
VALUES (12, 'Co oznacza skrót HTML?', 'Hyper Text Markup Language', 'High Tech Markup Language',
        'Hypertext Media Language', 'Hyperlink Text Markup Language', 1),
       (12, 'Który język programowania został stworzony najpierw?', 'C++', 'Java', 'Python', 'Fortran', 4),
       (12, 'Co to jest algorytm?', 'Komputerowy program', 'Kolekcja klas i funkcji',
        'Sekwencja kroków prowadzących do rozwiązania problemu', 'Kolekcja zmiennych i stałych', 3),
       (12, 'Co oznacza skrót CPU?', 'Central Processing Unit', 'Computer Processing Unit', 'Core Processing Unit',
        'Central Power Unit', 1),
       (12, 'Co to jest chmura obliczeniowa?', 'System operacyjny', 'Internet', 'Serwer',
        'Wirtualna przestrzeń, w której dane i aplikacje są przechowywane i udostępniane przez internet', 4),
       (12, 'Który z podanych systemów operacyjnych jest typu open source?', 'Windows', 'macOS', 'Linux', 'iOS', 3),
       (12, 'Co oznacza skrót VPN?', 'Virtual Private Network', 'Virtual Public Network', 'Virtual Personal Network',
        'Virtual Professional Network', 1),
       (12, 'Co to jest program antywirusowy?', 'Program, który chroni komputer przed wirusami i innymi zagrożeniami',
        'Program, który przyspiesza działanie komputera', 'Program, który służy do edycji plików tekstowych',
        'Program, który wyświetla animowane obrazki na pulpicie', 1);

ALTER TABLE quiz.quiz_question
    MODIFY quiz_id bigint NULL;

ALTER TABLE quiz.submission
    MODIFY COLUMN quiz_id bigint NULL;

ALTER TABLE quiz.quiz
DROP
COLUMN passed_counter,
DROP
COLUMN failed_attempts_counter;