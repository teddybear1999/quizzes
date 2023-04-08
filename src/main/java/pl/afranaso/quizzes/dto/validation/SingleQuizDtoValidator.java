package pl.afranaso.quizzes.dto.validation;

import pl.afranaso.quizzes.dto.SingleQuizDto;
import pl.afranaso.quizzes.exceptions.InvalidQuizParametersException;

public class SingleQuizDtoValidator {

    public static void validateSingleQuizDtoMinPoints(SingleQuizDto singleQuizDto) {
        if (singleQuizDto.getMinScore() > singleQuizDto.getQuizQuestionDtos().size()) {
            throw new InvalidQuizParametersException("The minimum number of points required to pass the test is " +
                    "higher than the number of points possible to obtain.");
        }
    }
}
