package pl.afranaso.quizzes.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import pl.afranaso.quizzes.model.QuizType;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SingleQuizDto {
    private Long id;
    @NotBlank
    @Length(min = 10)
    private String description;
    @NotNull
    private QuizType quizType;
    @Positive
    @Max(100)
    private int minScore;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<QuizQuestionDto> quizQuestionDtos;
}
