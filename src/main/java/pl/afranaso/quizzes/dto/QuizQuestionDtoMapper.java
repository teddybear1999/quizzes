package pl.afranaso.quizzes.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.afranaso.quizzes.model.QuizQuestion;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuizQuestionDtoMapper implements Mapper<QuizQuestion, QuizQuestionDto> {

    private final QuizAnswerDtoMapper quizAnswerDtoMapper;

    @Override
    public QuizQuestionDto mapToDto(QuizQuestion quizQuestion) {
        return QuizQuestionDto.builder()
                .id(quizQuestion.getId())
                .quizId(quizQuestion.getQuizId())
                .content(quizQuestion.getContent())
                .quizAnswerDtos(
                        quizQuestion.getQuizAnswers()
                                .stream()
                                .map(quizAnswerDtoMapper::mapToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
