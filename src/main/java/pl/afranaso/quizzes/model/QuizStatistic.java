package pl.afranaso.quizzes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "quiz_statistic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quiz_id")
    private long quizId;
    @Column(name = "passed_counter")
    private long passedCounter;
    @Column(name = "failed_attempts_counter")
    private long failedAttemptsCounter;
}
