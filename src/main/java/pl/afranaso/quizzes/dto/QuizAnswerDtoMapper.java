package pl.afranaso.quizzes.dto;

import org.springframework.stereotype.Component;
import pl.afranaso.quizzes.model.QuizAnswer;

@Component
public class QuizAnswerDtoMapper implements Mapper<QuizAnswer, QuizAnswerDto> {

    @Override
    public QuizAnswerDto mapToDto(QuizAnswer quizAnswer) {
        return QuizAnswerDto.builder()
                .id(quizAnswer.getId())
                .quizId(quizAnswer.getId())
                .questionId(quizAnswer.getQuestionId())
                .correct(false)
                .content(quizAnswer.getContent())
                .build();
    }
}
