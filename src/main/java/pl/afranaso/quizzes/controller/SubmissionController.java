package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.model.Submission;
import pl.afranaso.quizzes.service.SubmissionService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSingleSubmission(@PathVariable long id) {
        Optional<Submission> submission = submissionService.getSubmission(id);
        return submission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Submission addSubmission(@RequestBody @Valid SingleQuizDto singleQuizDto) {
        return submissionService.createSubmission(singleQuizDto);
    }
}
