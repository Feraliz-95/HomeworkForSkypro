package org.example.exam_questions.serviceExam;
import org.example.exam_questions.questionExam.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}