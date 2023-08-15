package pl.afranaso.quizzes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.model.Submission;
import pl.afranaso.quizzes.service.SubmissionService;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @GetMapping("submission/{id}")
    public String getSingleSubmission(@PathVariable long id, Model model) {
        Submission submission = submissionService.getSubmission(id).orElseThrow();
        model.addAttribute("submission", submission);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = submission.getSubmissionTime().format(formatter);
        model.addAttribute("formattedDateTime", formattedDateTime);
        return "submission";
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
