--liquibase formatted sql
--changeset teddy-bear1999:5
USE quiz;

DROP TABLE quiz_statistic;

ALTER TABLE quiz.quiz
    ADD COLUMN passed_counter bigint DEFAULT 0 NOT NULL AFTER min_score,
    ADD COLUMN failed_attempts_counter bigint DEFAULT 0 NOT NULL AFTER passed_counter;
