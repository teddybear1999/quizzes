--liquibase formatted sql
--changeset teddy-bear1999:1
USE quiz;

CREATE TABLE quiz
(
    id                      BIGINT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description             varchar(5000)    NOT NULL,
    type                    varchar(30)      NOT NULL,
    min_score               INT              NOT NULL,
    passed_counter          BIGINT DEFAULT 0 NOT NULL,
    failed_attempts_counter BIGINT DEFAULT 0 NOT NULL,
    created                 DATETIME         NOT NULL,
    updated                 DATETIME         NOT NULL
);

CREATE TABLE quiz_question
(
    id                      BIGINT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quiz_id                 BIGINT           NOT NULL,
    content                 varchar(1000)    NOT NULL,
    passed_counter          BIGINT DEFAULT 0 NOT NULL,
    failed_attempts_counter BIGINT DEFAULT 0 NOT NULL,
    FOREIGN KEY (quiz_id) references quiz (id)
);

CREATE TABLE quiz_answer
(
    id             BIGINT           NOT NULL PRIMARY KEY AUTO_INCREMENT,
    quiz_id        BIGINT           NOT NULL,
    question_id    BIGINT           NOT NULL,
    correct        TINYINT          NOT NULL,
    content        varchar(1000)    NOT NULL,
    chosen_counter BIGINT DEFAULT 0 NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz (id),
    FOREIGN KEY (question_id) REFERENCES quiz_question (id)
);