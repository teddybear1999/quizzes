package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Builder
public class QuizQuestionDto {

    @Positive
    private Long id;
    @Positive
    private Long quizId;
    @NotBlank
    private String content;
    @NotBlank
    private String optionA;
    @NotBlank
    private String optionB;
    @NotBlank
    private String optionC;
    @NotBlank
    private String optionD;
    @PositiveOrZero
    private int answer;
}
