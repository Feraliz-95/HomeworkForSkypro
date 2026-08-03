package org.example.exam_questions.serviceExam;

import org.example.exam_questions.exception.ExamException;
import org.example.exam_questions.questionExam.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество вопросов должно быть больше 0");
        }

        List<Question> all = questionService.getAll();

        if (all.isEmpty()) {
            throw new ExamException("Нет доступных вопросов", HttpStatus.BAD_REQUEST);
        }

        if (amount > all.size()) {
            throw new ExamException(
                    "Запрошено больше вопросов (" + amount + "), чем доступно (" + all.size() + ")",
                    HttpStatus.BAD_REQUEST
            );
        }

        // Делаем копию, чтобы не портить исходный список в сервисе
        List<Question> shuffled = new ArrayList<>(all);
        Collections.shuffle(shuffled);

        return shuffled.subList(0, amount);
    }
}