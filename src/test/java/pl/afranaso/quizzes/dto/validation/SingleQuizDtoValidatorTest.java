package pl.afranaso.quizzes.dto.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.afranaso.quizzes.dto.QuizQuestionDto;
import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.exceptions.InvalidQuizParametersException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleQuizDtoValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidQuizParams")
    void shouldThrowInvalidQuizParametersException(SingleQuizDto singleQuizDto) {
        // when and then
        assertThatThrownBy(() -> SingleQuizDtoValidator.validateSingleQuizDtoMinPoints(singleQuizDto))
                .isInstanceOf(InvalidQuizParametersException.class)
                .hasMessage("The minimum number of points required to pass the test is " +
                        "higher than the number of points possible to obtain.");
    }

    @ParameterizedTest
    @MethodSource("validQuizParams")
    void shouldNotThrowExceptionAndReturnTrue(SingleQuizDto singleQuizDto) {
        // when and then
        assertThatCode(() -> SingleQuizDtoValidator.validateSingleQuizDtoMinPoints(singleQuizDto)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> invalidQuizParams() {
        long id = 0L;

        return Stream.of(
                arguments(SingleQuizDto.builder().id(id).minScore(3).quizQuestionDtos(createListWithSize(2)).build()),
                arguments(SingleQuizDto.builder().id(id).minScore(4).quizQuestionDtos(createListWithSize(3)).build()),
                arguments(SingleQuizDto.builder().id(id).minScore(5).quizQuestionDtos(createListWithSize(1)).build()),
                arguments(SingleQuizDto.builder().id(id).minScore(6).quizQuestionDtos(createListWithSize(5)).build())
        );
    }

    private static Stream<Arguments> validQuizParams() {
        Long id = 1L;

        return Stream.of(
                arguments(SingleQuizDto.builder().id(id).minScore(1).quizQuestionDtos(createListWithSize(1)).build()),
                arguments(SingleQuizDto.builder().id(id).minScore(19).quizQuestionDtos(createListWithSize(30)).build()),
                arguments(SingleQuizDto.builder().id(id).minScore(6).quizQuestionDtos(createListWithSize(10)).build()),
                arguments(SingleQuizDto.builder().id(id).minScore(5).quizQuestionDtos(createListWithSize(11)).build())

        );
    }

    private static List<QuizQuestionDto> createListWithSize(int size) {
        List<QuizQuestionDto> quizQuestionDtos = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            quizQuestionDtos.add(QuizQuestionDto.builder().build());
        }
        return quizQuestionDtos;
    }
}