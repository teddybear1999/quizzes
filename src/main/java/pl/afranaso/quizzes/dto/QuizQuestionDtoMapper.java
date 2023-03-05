package pl.afranaso.quizzes.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.afranaso.quizzes.model.QuizQuestion;

@Component
@RequiredArgsConstructor
public class QuizQuestionDtoMapper implements Mapper<QuizQuestion, QuizQuestionDto> {

    @Override
    public QuizQuestionDto mapToDto(QuizQuestion quizQuestion) {
        return QuizQuestionDto.builder()
                .id(quizQuestion.getId())
                .quizId(quizQuestion.getQuizId())
                .content(quizQuestion.getContent())
                .optionA(quizQuestion.getOptionA())
                .optionB(quizQuestion.getOptionB())
                .optionC(quizQuestion.getOptionC())
                .optionD(quizQuestion.getOptionD())
                .answer(0)
                .build();
    }
}
