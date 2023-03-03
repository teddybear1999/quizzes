package pl.afranaso.quizzes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.afranaso.quizzes.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
