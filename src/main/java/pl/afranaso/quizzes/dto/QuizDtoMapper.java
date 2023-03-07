package pl.afranaso.quizzes.dto;

import org.springframework.stereotype.Component;
import pl.afranaso.quizzes.model.Quiz;

@Component
public class QuizDtoMapper implements Mapper<Quiz, QuizDto> {

    @Override
    public QuizDto mapToDto(Quiz quiz) {
        return QuizDto.builder()
                .id(quiz.getId())
                .description(quiz.getDescription())
                .quizType(quiz.getQuizType())
                .minScore(quiz.getMinScore())
                .build();
    }
}
