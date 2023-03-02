package pl.afranaso.quizzes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private QuizType QuizType;
    @Column(name = "min_score")
    private int minScore;
    @Column(name = "passed_counter")
    private long passedCounter;
    @Column(name = "failed_attempts_counter")
    private int failedAttemptsCounter;
    private LocalDateTime created;
    private LocalDateTime updated;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_id", updatable = false, insertable = false)
    private List<QuizQuestion> questions;
}
