package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.QuizDto;
import pl.afranaso.quizzes.dto.QuizDtoMapper;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.dto.SingleQuizDtoMapper;
import pl.afranaso.quizzes.model.QuizType;
import pl.afranaso.quizzes.service.QuizService;

import javax.validation.Valid;

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
    public String getSingleQuiz(@PathVariable long id, Model model) {
        SingleQuizDto singleQuizDto = singleQuizDtoMapper.mapToDto(quizService.getQuiz(id).orElseThrow());
        model.addAttribute("singleQuizDto", singleQuizDto);
        return "quiz";
    }

    @GetMapping("/quizzes/create")
    public String createQuizForm(Model model) {
        model.addAttribute("allQuizTypes", QuizType.values());
        model.addAttribute("singleQuizDto", new SingleQuizDto());
        return "createQuiz";
    }

    @PostMapping("/quizzes/create")
    public String createQuizSubmit(@ModelAttribute @Valid SingleQuizDto singleQuizDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/quizzes/create";
        }
        validateSingleQuizDtoMinPoints(singleQuizDto);
        quizService.createQuiz(singleQuizDto);
        return "redirect:/quizzes";
    }

    @DeleteMapping("/quizzes/delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return "redirect:/quizzes";
    }

}
