package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.*;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.service.QuizService;

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

    @PostMapping
    public SingleQuizDto createQuiz(@RequestBody @Valid SingleQuizDto singleQuizDto) {
        return quizService.createQuiz(singleQuizDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody @Valid SingleQuizDto singleQuizDto, @PathVariable Long id) {
        if (!quizService.isQuizExists(id) || !id.equals(singleQuizDto.getId())) {
            return ResponseEntity.notFound().build();
        }
        Quiz quiz = createQuizFromDtoToCreateOrUpdate(singleQuizDto, id);
        return ResponseEntity.ok(quizService.updateQuiz(quiz));
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

    private Quiz createQuizFromDtoToCreateOrUpdate(SingleQuizDto singleQuizDto, Long id) {
        return new Quiz(
                id,
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
