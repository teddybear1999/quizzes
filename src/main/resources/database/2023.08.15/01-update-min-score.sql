-- liquibase formatted sql
-- changeset teddy-bear1999:10

UPDATE quiz
SET min_score = 5
WHERE min_score > 5;