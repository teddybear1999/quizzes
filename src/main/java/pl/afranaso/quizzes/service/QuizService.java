package pl.afranaso.quizzes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.repository.QuizRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public Page<Quiz> getQuizzes(Pageable pageable) {
        return quizRepository.findAll(pageable);
    }

    public Optional<Quiz> getQuiz(Long id) {
        return quizRepository.findById(id);
    }
}
