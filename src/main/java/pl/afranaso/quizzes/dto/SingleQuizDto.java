package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import pl.afranaso.quizzes.model.QuizType;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Builder
public class SingleQuizDto {
    private long id;
    @NotBlank
    @Length(min = 10)
    private String description;
    @NotNull
    private QuizType quizType;
    @Positive
    private int minScore;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<QuizQuestionDto> quizQuestionDtos;
}
