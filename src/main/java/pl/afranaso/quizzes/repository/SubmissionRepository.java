package pl.afranaso.quizzes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.afranaso.quizzes.model.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    void deleteAllByQuizId(Long quizId);
}
