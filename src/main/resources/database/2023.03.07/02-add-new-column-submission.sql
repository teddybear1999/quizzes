--liquibase formatted sql
--changeset teddy-bear1999:6
USE quiz;

ALTER TABLE submission
    ADD COLUMN is_quiz_passed TINYINT(1) NOT NULL AFTER incorrect_answers;