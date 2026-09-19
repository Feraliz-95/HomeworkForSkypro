package org.example.exam_questions.questionExam;
import java.util.Objects;
import java.util.UUID;
import static java.awt.SystemColor.text;

public class Question {
    private final String id;
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.id = UUID.randomUUID().toString();
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question that = (Question) o;
        // Сравниваем по question и answer, потому что id всегда разный
        return Objects.equals(question, that.question) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

}