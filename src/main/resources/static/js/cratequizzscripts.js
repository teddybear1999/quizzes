function addQuestion() {
    let questionsContainer = document.getElementById('questionsContainer');
    let questionCount = questionsContainer.childElementCount;

    let questionDiv = document.createElement('div');
    questionDiv.innerHTML = `
        <h3>Question ${questionCount + 1}</h3>
        <input type="text" name="quizQuestionDtos[${questionCount}].content" placeholder="Question Content"/>
        <input type="text" name="quizQuestionDtos[${questionCount}].optionA" placeholder="Option A"/>
        <input type="text" name="quizQuestionDtos[${questionCount}].optionB" placeholder="Option B"/>
        <input type="text" name="quizQuestionDtos[${questionCount}].optionC" placeholder="Option C"/>
        <input type="text" name="quizQuestionDtos[${questionCount}].optionD" placeholder="Option D"/>
        <input type="text" name="quizQuestionDtos[${questionCount}].answer" placeholder="Answer (e.g. 1 for Option A)"/>
    `;

    questionsContainer.appendChild(questionDiv);
}

function validateQuestionFields(questionDiv) {
    const content = questionDiv.querySelector('input[name$=".content"]');
    const optionA = questionDiv.querySelector('input[name$=".optionA"]');
    const optionB = questionDiv.querySelector('input[name$=".optionB"]');
    const optionC = questionDiv.querySelector('input[name$=".optionC"]');
    const optionD = questionDiv.querySelector('input[name$=".optionD"]');
    const answer = questionDiv.querySelector('input[name$=".answer"]');

    if (!content.value.trim()) return 'Content cannot be blank.';
    if (!optionA.value.trim()) return 'Option A cannot be blank.';
    if (!optionB.value.trim()) return 'Option B cannot be blank.';
    if (!optionC.value.trim()) return 'Option C cannot be blank.';
    if (!optionD.value.trim()) return 'Option D cannot be blank.';

    const answerValue = parseInt(answer.value, 10);
    if (!answerValue || answerValue < 1 || answerValue > 4) return 'Answer should be a number between 1 and 4.';

    return null; // No errors
}

function validateMinScore() {
    const minScoreField = document.getElementById("minScore");
    const minScore = parseInt(minScoreField.value, 10);
    const questionsCount = document.querySelectorAll("#questionsContainer > div").length;

    if (isNaN(minScore) || minScore > questionsCount) {
        return 'The minimum score should not exceed the number of questions.';
    }

    return null;
}

document.addEventListener("DOMContentLoaded", function () {
    const descriptionField = document.getElementById("description");

    descriptionField.addEventListener("blur", function () {
        let errorMessage = '';

        if (this.value.trim() === '') {
            errorMessage = 'Field cannot be blank.';
        } else if (this.value.length < 10) {
            errorMessage = 'Description must be at least 10 characters long.';
        }

        if (errorMessage) {
            alert(errorMessage);
        }
    });

    document.querySelector("form").addEventListener("submit", function (event) {
        const minScoreError = validateMinScore();
        if (minScoreError) {
            alert(minScoreError);
            event.preventDefault(); // prevent the form from submitting
        }

        const questions = document.querySelectorAll("#questionsContainer > div");
        for (let question of questions) {
            const error = validateQuestionFields(question);
            if (error) {
                alert(error);
                event.preventDefault();  // prevent the form from submitting
                return;
            }
        }
    });
});
