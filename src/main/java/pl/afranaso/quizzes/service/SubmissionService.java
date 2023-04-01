package pl.afranaso.quizzes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.afranaso.quizzes.dto.QuizQuestionDto;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.exceptions.QuizNotFoundException;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.model.QuizQuestion;
import pl.afranaso.quizzes.model.Submission;
import pl.afranaso.quizzes.repository.SubmissionRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final QuizService quizService;

    public Optional<Submission> getSubmission(long id) {
        return submissionRepository.findById(id);
    }

    @Transactional
    public Submission createSubmission(SingleQuizDto singleQuizDto) {
        Optional<Quiz> optionalQuiz = quizService.getQuiz(singleQuizDto.getId());
        if (optionalQuiz.isEmpty()) {
            throw new QuizNotFoundException("Quiz not found with ID: " + singleQuizDto.getId());
        }
        Quiz quiz = optionalQuiz.get();
        int score = getScore(singleQuizDto, quiz);
        Submission submission = new Submission(
                0L,
                singleQuizDto.getId(),
                score,
                quiz.getQuestions().size() - score,
                score >= quiz.getMinScore(),
                LocalDateTime.now()
        );
        return submissionRepository.save(submission);
    }

    protected int getScore(SingleQuizDto singleQuizDto, Quiz quiz) {
        int score = 0;
        List<QuizQuestionDto> quizQuestionDtos = singleQuizDto.getQuizQuestionDtos();
        List<QuizQuestion> quizQuestions = quiz.getQuestions();
        for (int i = 0; i < quizQuestionDtos.size(); ++i) {
            if (quizQuestions.get(i).getAnswer() == quizQuestionDtos.get(i).getAnswer()) {
                ++score;
            }
        }
        return score;
    }
}
