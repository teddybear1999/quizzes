--liquibase formatted sql
--changeset teddy-bear1999:6

INSERT INTO quiz (description, type, min_score, created) VALUES
('Quiz z informatyki', 'IT', 4, NOW());




