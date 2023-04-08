package pl.afranaso.quizzes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.afranaso.quizzes.model.QuizQuestion;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

    @Override
    <S extends QuizQuestion> List<S> saveAll(Iterable<S> entities);

    void deleteAllByQuizId(Long quizId);

}
