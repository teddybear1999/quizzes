package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizQuestionDto {

    private long id;
    private long quizId;
    private String content;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int answer;
}
