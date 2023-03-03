package pl.afranaso.quizzes.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QuizQuestionDto {

    private long id;
    private long quizId;
    private String content;
    private List<QuizAnswerDto> quizAnswerDtos;
}
