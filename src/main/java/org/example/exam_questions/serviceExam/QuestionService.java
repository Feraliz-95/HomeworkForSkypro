package org.example.exam_questions.serviceExam;

import org.example.exam_questions.questionExam.Question;

import java.util.List;

public interface QuestionService {
    void add(Question question);

    boolean remove(String id);

    List<Question> getAll();

    Question getRandomQuestion();
}