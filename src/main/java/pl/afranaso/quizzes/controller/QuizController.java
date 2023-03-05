package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.afranaso.quizzes.dto.QuizDto;
import pl.afranaso.quizzes.dto.QuizDtoMapper;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.dto.SingleQuizDtoMapper;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.service.QuizService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final QuizDtoMapper quizDtoMapper;
    private final SingleQuizDtoMapper singleQuizDtoMapper;

    @GetMapping("/quizzes")
    public Page<QuizDto> getQuizzes(Pageable pageable) {
        return quizService.getQuizzes(pageable)
                .map(quizDtoMapper::mapToDto);
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<SingleQuizDto> getSingleQuiz(@PathVariable long id) {
        Optional<Quiz> quiz = quizService.getQuiz(id);
        return quiz.map(value -> ResponseEntity.ok(singleQuizDtoMapper.mapToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
