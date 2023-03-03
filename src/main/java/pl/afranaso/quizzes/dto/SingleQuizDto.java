package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;
import pl.afranaso.quizzes.model.QuizType;

import java.util.List;

@Getter
@Builder
public class SingleQuizDto {
    private long id;
    private String description;
    private QuizType quizType;
    private int minScore;
    private List<QuizQuestionDto> quizQuestionDtos;
}
