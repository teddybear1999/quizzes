package pl.afranaso.quizzes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.afranaso.quizzes.dto.QuizQuestionDto;
import pl.afranaso.quizzes.dto.QuizQuestionDtoMapper;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.dto.SingleQuizDtoMapper;
import pl.afranaso.quizzes.model.Quiz;
import pl.afranaso.quizzes.model.QuizQuestion;
import pl.afranaso.quizzes.repository.QuizQuestionRepository;
import pl.afranaso.quizzes.repository.QuizRepository;
import pl.afranaso.quizzes.repository.SubmissionRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final SubmissionRepository submissionRepository;
    private final QuizQuestionDtoMapper quizQuestionDtoMapper;
    private final SingleQuizDtoMapper singleQuizDtoMapper;
    private final Long EMPTY_ID = null;

    public Page<Quiz> getQuizzes(Pageable pageable) {
        return quizRepository.findAll(pageable);
    }

    public Optional<Quiz> getQuiz(Long id) {
        return quizRepository.findById(id);
    }

    public SingleQuizDto createQuiz(SingleQuizDto singleQuizDto) {
        Quiz quiz = quizRepository.save(createQuizFromDto(singleQuizDto));
        List<QuizQuestion> createdQuestions = quizQuestionRepository.saveAll(mapQuestionsDtoListToQuestionEntities(singleQuizDto.getQuizQuestionDtos(), quiz.getId()));
        return singleQuizDtoMapper.mapToDto(
                new Quiz(
                        quiz.getId(),
                        quiz.getDescription(),
                        quiz.getQuizType(),
                        quiz.getMinScore(),
                        quiz.getCreated(),
                        createdQuestions,
                        null
                )
        );
    }

    @Transactional
    public Quiz updateQuiz(Quiz quiz) {
        submissionRepository.deleteAllByQuizId(quiz.getId());
        quizQuestionRepository.saveAll(quiz.getQuestions());
        return quizRepository.save(quiz);
    }

    public boolean isQuizExists(Long id) {
        return quizRepository.existsById(id);
    }

    @Transactional
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    private List<QuizQuestion> mapQuestionsDtoListToQuestionEntities(List<QuizQuestionDto> quizQuestionDtos, Long id) {
        return quizQuestionDtos.stream()
                .map(quizQuestionDto -> quizQuestionDtoMapper.mapDtoToEntity(quizQuestionDto, id))
                .collect(Collectors.toList());
    }


    private Quiz createQuizFromDto(SingleQuizDto singleQuizDto) {
        return new Quiz(
                EMPTY_ID,
                singleQuizDto.getDescription(),
                singleQuizDto.getQuizType(),
                singleQuizDto.getMinScore(),
                LocalDateTime.now(),
                null,
                null
        );
    }
}
