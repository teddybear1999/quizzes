--liquibase formatted sql
--changeset teddy-bear1999:4
USE quiz;

DELETE FROM quiz_question;
DELETE FROM quiz;

ALTER TABLE quiz
    DROP COLUMN passed_counter,
    DROP COLUMN failed_attempts_counter,
    DROP COLUMN updated;

ALTER TABLE quiz_question
    DROP COLUMN passed_counter,
    DROP COLUMN failed_attempts_counter;

CREATE TABLE quiz_statistic
(
    id                      BIGINT AUTO_INCREMENT PRIMARY KEY,
    quiz_id                 BIGINT NOT NULL,
    passed_counter          BIGINT NOT NULL DEFAULT 0,
    failed_attempts_counter BIGINT NOT NULL DEFAULT 0,
    FOREIGN KEY (quiz_id) REFERENCES quiz (id)
);

CREATE TABLE submission
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    quiz_id           BIGINT   NOT NULL,
    correct_answers   INT      NOT NULL,
    incorrect_answers INT      NOT NULL,
    submission_time   DATETIME NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz (id)
);

