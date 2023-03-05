--liquibase formatted sql
--changeset teddy-bear1999:2
USE quiz;

DROP TABLE quiz_answer;

ALTER TABLE quiz_question
    ADD COLUMN option_a VARCHAR(1000) NOT NULL AFTER content,
    ADD COLUMN option_b VARCHAR(1000) NOT NULL AFTER option_a,
    ADD COLUMN option_c VARCHAR(1000) NOT NULL AFTER option_b,
    ADD COLUMN option_d VARCHAR(1000) NOT NULL AFTER option_c,
    ADD COLUMN answer   INT           NOT NULL AFTER option_d;

