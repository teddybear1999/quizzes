package pl.afranaso.quizzes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.repository.QuizQuestionRepository;
import pl.afranaso.quizzes.repository.QuizRepository;
import pl.afranaso.quizzes.repository.SubmissionRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final SubmissionRepository submissionRepository;

    public Page<Quiz> getQuizzes(Pageable pageable) {
        return quizRepository.findAll(pageable);
    }

    public Optional<Quiz> getQuiz(Long id) {
        return quizRepository.findById(id);
    }

    @Transactional
    public Quiz updateQuiz(Quiz quiz) {
        submissionRepository.deleteAllByQuizId(quiz.getId());
        quizQuestionRepository.saveAll(quiz.getQuestions());
        return quizRepository.save(quiz);
    }

    public boolean isQuizExists(Long id) {
        return quizRepository.existsById(id);
    }

    @Transactional
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
