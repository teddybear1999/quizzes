package pl.afranaso.quizzes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "quiz_answer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quiz_id")
    private long quizId;
    @Column(name = "question_id")
    private long questionId;
    private boolean correct;
    private String content;
    @Column(name = "chosen_counter")
    private long chosenCounter;
}
