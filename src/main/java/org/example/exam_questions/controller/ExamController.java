package org.example.exam_questions.controller;
import jakarta.annotation.PostConstruct;
import org.example.exam_questions.questionExam.Question;
import org.example.exam_questions.serviceExam.ExaminerService;
import org.example.exam_questions.serviceExam.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;
    private final JavaQuestionService questionService;

    public ExamController(ExaminerService examinerService, JavaQuestionService questionService) {
        this.examinerService = examinerService;
        this.questionService = questionService;
    }

    /**
     * Получить случайные уникальные вопросы.
     * Путь: GET /exam/get/{amount}
     */
    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
    @PostConstruct
        // Вызовется один раз после создания бина (после конструктора)
    void init() {
        questionService.initializeDefaultQuestions();
    }
}