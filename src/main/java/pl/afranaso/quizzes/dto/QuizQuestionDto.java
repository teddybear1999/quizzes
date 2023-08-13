package pl.afranaso.quizzes.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @Min(1)
    @Max(4)
    private int answer;
}
