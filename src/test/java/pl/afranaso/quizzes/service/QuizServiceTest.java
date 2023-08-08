package pl.afranaso.quizzes.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.afranaso.quizzes.dto.QuizQuestionDtoMapper;
import pl.afranaso.quizzes.dto.SingleQuizDtoMapper;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.repository.QuizQuestionRepository;
import pl.afranaso.quizzes.repository.QuizRepository;
import pl.afranaso.quizzes.repository.SubmissionRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizServiceTest {

    @InjectMocks
    private QuizService quizService;

    @Mock
    private QuizRepository quizRepository;
    @Mock
    private QuizQuestionRepository quizQuestionRepository;
    @Mock
    private SubmissionRepository submissionRepository;
    @Mock
    private QuizQuestionDtoMapper quizQuestionDtoMapper;
    @Mock
    private SingleQuizDtoMapper singleQuizDtoMapper;

    @Test
    void shouldReturnPageOfQuizzes() {
        Page<Quiz> mockPage = mock(Page.class);
        Pageable mockPageable = mock(Pageable.class);

        when(quizRepository.findAll(mockPageable)).thenReturn(mockPage);

        Page<Quiz> result = quizService.getQuizzes(mockPageable);

        verify(quizRepository, times(1)).findAll(mockPageable);
        assertEquals(mockPage, result);
    }

    @Test
    void shouldReturnExistingQuiz() {
        Quiz quiz = new Quiz();
        Long id = 10L;

        when(quizRepository.findById(id)).thenReturn(Optional.of(quiz));

        Optional<Quiz> result = quizService.getQuiz(id);
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    void shouldReturnEmptyOptional() {
        Long id = 10L;

        when(quizRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Quiz> result = quizService.getQuiz(id);
        assertThat(result.isPresent()).isFalse();
    }
}