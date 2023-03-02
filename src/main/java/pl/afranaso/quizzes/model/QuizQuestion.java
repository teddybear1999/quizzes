package pl.afranaso.quizzes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz_question")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quiz_id")
    private long quizId;
    private String content;
    @Column(name = "passed_counter")
    private long passedCounter;
    @Column(name = "failed_attempts_counter")
    private long failedAttemptsCounter;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    List<QuizAnswer> quizAnswers;
}
