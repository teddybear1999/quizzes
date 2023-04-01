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
    @Column(name = "type")
    private QuizType quizType;
    @Column(name = "min_score")
    private int minScore;
    private LocalDateTime created;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_id")
    private List<QuizQuestion> questions;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_id")
    private List<Submission> submissions;
}
