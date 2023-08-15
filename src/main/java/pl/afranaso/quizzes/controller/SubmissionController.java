package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.model.Submission;
import pl.afranaso.quizzes.service.SubmissionService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @GetMapping("submission/{id}")
    @ResponseBody
    public ResponseEntity<Submission> getSingleSubmission(@PathVariable long id) {
        Optional<Submission> submission = submissionService.getSubmission(id);
        return submission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/quizz/{id}")
    @ResponseBody
    public Page<Submission> getQuizSubmissions(@PathVariable Long id, Pageable pageable) {
        return submissionService.getQuizSubmissions(id, pageable);
    }

    @PostMapping("/submission/create")
    public String addSubmission(@ModelAttribute @Valid SingleQuizDto singleQuizDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
        }
        Submission submission = submissionService.createSubmission(singleQuizDto);
        long id = submission.getId();
        return "redirect:/submission/" + id;
    }
}
