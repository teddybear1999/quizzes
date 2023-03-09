package pl.afranaso.quizzes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long quizId;
    private int correctAnswers;
    private int incorrectAnswers;
    @Column(name = "is_quiz_passed")
    private boolean isQuizPassed;
    private LocalDateTime submissionTime;

}
