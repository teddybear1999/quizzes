package pl.afranaso.quizzes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.afranaso.quizzes.model.QuizStatistic;

@Repository
public interface QuizStatisticRepository extends JpaRepository<QuizStatistic, Long> {
}
