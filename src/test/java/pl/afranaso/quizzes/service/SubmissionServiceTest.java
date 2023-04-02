package pl.afranaso.quizzes.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.afranaso.quizzes.dto.QuizQuestionDtoMapper;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.exceptions.QuizNotFoundException;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.model.QuizQuestion;
import pl.afranaso.quizzes.model.QuizType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubmissionServiceTest {

    @Mock
    private QuizService quizService;
    @InjectMocks
    private SubmissionService submissionService;
    private final QuizQuestionDtoMapper quizQuestionDtoMapper = new QuizQuestionDtoMapper();

    @Test
    void shouldThrowNoSuchElementRuntimeException() {
        // given
        long id = 10L;
        SingleQuizDto singleQuizDto = SingleQuizDto.builder().id(id).build();
        // when
        when(quizService.getQuiz(id)).thenReturn(Optional.empty());
        // then
        assertThatThrownBy(() -> submissionService.createSubmission(singleQuizDto))
                .isInstanceOf(QuizNotFoundException.class)
                .hasMessage("Quiz not found with ID: " + id);
    }

    @Test
    void shouldReturnCorrectScore() {
        // given

        long id = 13L;
        int minScore = 2;
        long passedCounter = 9L, failedAttemptsCounter = 10;
        QuizType quizType = QuizType.IT;
        String description = "description";
        LocalDateTime localDateTime = LocalDateTime.now();
        List<QuizQuestion> questions = List.of(
                new QuizQuestion(1L, id, "", "", "", "", "", 1),
                new QuizQuestion(2L, id, "", "", "", "", "", 2),
                new QuizQuestion(3L, id, "", "", "", "", "", 3),
                new QuizQuestion(4L, id, "", "", "", "", "", 4)
        );
        List<QuizQuestion> answers = List.of(
                new QuizQuestion(1L, id, "", "", "", "", "", 1),
                new QuizQuestion(2L, id, "", "", "", "", "", 4),
                new QuizQuestion(3L, id, "", "", "", "", "", 2),
                new QuizQuestion(4L, id, "", "", "", "", "", 4)
        );

        Quiz quiz = null;

        SingleQuizDto singleQuizDto = SingleQuizDto.builder()
                .id(id)
                .description(description)
                .quizType(quizType)
                .minScore(minScore)
                .quizQuestionDtos(
                        answers
                                .stream()
                                .map(quizQuestionDtoMapper::mapToDtoWithAnswers)
                                .collect(Collectors.toList())
                )
                .build();

        // when
        int score = submissionService.getScore(singleQuizDto, quiz);
        // then
        assertThat(score).isEqualTo(2);
    }
}