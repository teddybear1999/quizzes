package pl.afranaso.quizzes.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.service.QuizService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class QuizControllerTest {

    @Mock
    private QuizService quizService;
    @InjectMocks
    private QuizController quizController;

    @Test
    void testGetSingleQuizNotFound() {
        // given
        long quizId = 100;
        when(quizService.getQuiz(quizId)).thenReturn(Optional.empty());
        // when
        ResponseEntity<SingleQuizDto> result = quizController.getSingleQuiz(quizId);
        // then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}