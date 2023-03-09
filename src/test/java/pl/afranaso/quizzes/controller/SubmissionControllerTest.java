package pl.afranaso.quizzes.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.afranaso.quizzes.model.Submission;
import pl.afranaso.quizzes.service.SubmissionService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubmissionControllerTest {

    @Mock
    private SubmissionService submissionService;
    @InjectMocks
    private SubmissionController submissionController;

    @Test
    void shouldReturnSubmissionNotFound() {
        // given
        long submissionId = 1L;
        when(submissionService.getSubmission(submissionId)).thenReturn(Optional.empty());
        // when
        ResponseEntity<Submission> result = submissionController.getSingleSubmission(submissionId);
        // then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}