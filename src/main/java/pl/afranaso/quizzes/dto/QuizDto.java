package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;
import pl.afranaso.quizzes.model.QuizType;

@Getter
@Builder
public class QuizDto {

    private Long id;
    private String description;
    private QuizType quizType;
    private int minScore;
}
