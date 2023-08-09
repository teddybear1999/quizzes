package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.QuizDto;
import pl.afranaso.quizzes.dto.QuizDtoMapper;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.dto.SingleQuizDtoMapper;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.service.QuizService;

import javax.validation.Valid;
import java.util.Optional;

import static pl.afranaso.quizzes.dto.validation.SingleQuizDtoValidator.validateSingleQuizDtoMinPoints;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final QuizDtoMapper quizDtoMapper;
    private final SingleQuizDtoMapper singleQuizDtoMapper;

    @GetMapping
    public String getHomePage() {
        return "homepage";
    }

    @GetMapping("/quizzes")
    @ResponseBody
    public Page<QuizDto> getQuizzes(Pageable pageable) {
        return quizService.getQuizzes(pageable)
                .map(quizDtoMapper::mapToDto);
    }

    @GetMapping("/quizzes/{id}")
    @ResponseBody
    public ResponseEntity<SingleQuizDto> getSingleQuiz(@PathVariable long id) {
        Optional<Quiz> quiz = quizService.getQuiz(id);
        return quiz.map(value -> ResponseEntity.ok(singleQuizDtoMapper.mapToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/quizzes")
    @ResponseBody
    public SingleQuizDto createQuiz(@RequestBody @Valid SingleQuizDto singleQuizDto) {
        validateSingleQuizDtoMinPoints(singleQuizDto);
        return quizService.createQuiz(singleQuizDto);
    }

    @PutMapping("/quizzes/{id}")
    @ResponseBody
    public ResponseEntity<SingleQuizDto> updateQuiz(@RequestBody @Valid SingleQuizDto singleQuizDto, @PathVariable Long id) {
        if (!quizService.isQuizExists(id) || !id.equals(singleQuizDto.getId())) {
            return ResponseEntity.notFound().build();
        }
        validateSingleQuizDtoMinPoints(singleQuizDto);
        return ResponseEntity.ok(quizService.updateQuiz(singleQuizDto));
    }

    @DeleteMapping("/quizzes/{id}")
    @ResponseBody
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

}
