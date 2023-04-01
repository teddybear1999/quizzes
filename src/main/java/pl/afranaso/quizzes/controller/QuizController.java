package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.*;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.service.QuizService;
import pl.afranaso.quizzes.service.SubmissionService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final SubmissionService submissionService;
    private final QuizDtoMapper quizDtoMapper;
    private final SingleQuizDtoMapper singleQuizDtoMapper;
    private final QuizQuestionDtoMapper quizQuestionDtoMapper;

    @GetMapping
    public Page<QuizDto> getQuizzes(Pageable pageable) {
        return quizService.getQuizzes(pageable)
                .map(quizDtoMapper::mapToDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleQuizDto> getSingleQuiz(@PathVariable long id) {
        Optional<Quiz> quiz = quizService.getQuiz(id);
        return quiz.map(value -> ResponseEntity.ok(singleQuizDtoMapper.mapToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SingleQuizDto> updateQuiz(@RequestBody @Valid SingleQuizDto singleQuizDto) {
        if (!quizService.isQuizExists(singleQuizDto.getId())) {
            return ResponseEntity.notFound().build();
        }
        Quiz quiz = createQuizFromDtoToUpdate(singleQuizDto);
        return ResponseEntity.ok(singleQuizDtoMapper.mapToDto(quizService.updateQuiz(quiz)));
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

    private Quiz createQuizFromDtoToUpdate(SingleQuizDto singleQuizDto) {
        return new Quiz(
                singleQuizDto.getId(),
                singleQuizDto.getDescription(),
                singleQuizDto.getQuizType(),
                singleQuizDto.getMinScore(),
                LocalDateTime.now(),
                singleQuizDto.getQuizQuestionDtos().stream()
                        .map(quizQuestionDtoMapper::mapDtoToEntity)
                        .collect(Collectors.toList()),
                new ArrayList<>()
        );
    }
}
