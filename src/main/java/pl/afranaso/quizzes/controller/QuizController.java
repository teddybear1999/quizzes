package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Value("${spring.data.web.pageable.default-page-size}")
    private int defaultPageSize;
    @Value("${spring.data.web.pageable.max-page-size}")
    private int maxPageSize;

    @GetMapping
    public String getHomePage() {
        return "homepage";
    }

    @GetMapping("/quizzes")
    public String getQuizzes(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(name = "size", defaultValue = "10") int size) {
        size = Math.min(size, maxPageSize);
        Pageable pageable = PageRequest.of(page, size);
        Page<QuizDto> quizzesPage = quizService.getQuizzes(pageable).map(quizDtoMapper::mapToDto);
        model.addAttribute("quizzesPage", quizzesPage);
        return "quizzes";
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
