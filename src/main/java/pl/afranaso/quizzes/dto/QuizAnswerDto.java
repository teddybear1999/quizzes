package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizAnswerDto {

    private long id;
    private long quizId;
    private long questionId;
    private boolean correct;
    private String content;
}
