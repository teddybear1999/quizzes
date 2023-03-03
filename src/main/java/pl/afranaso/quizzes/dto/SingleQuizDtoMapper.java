package pl.afranaso.quizzes.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.afranaso.quizzes.model.Quiz;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SingleQuizDtoMapper implements Mapper<Quiz, SingleQuizDto> {

    private final QuizQuestionDtoMapper quizQuestionDtoMapper;

    @Override
    public SingleQuizDto mapToDto(Quiz quiz) {
        return SingleQuizDto.builder()
                .id(quiz.getId())
                .description(quiz.getDescription())
                .quizType(quiz.getQuizType())
                .minScore(quiz.getMinScore())
                .quizQuestionDtos(
                        quiz.getQuestions()
                                .stream()
                                .map(quizQuestionDtoMapper::mapToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
