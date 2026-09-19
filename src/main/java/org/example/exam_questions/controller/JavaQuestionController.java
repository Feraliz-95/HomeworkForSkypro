package org.example.exam_questions.controller;
import org.example.exam_questions.questionExam.Question;
import org.example.exam_questions.serviceExam.JavaQuestionService;
import org.example.exam_questions.serviceExam.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /*
            * Добавить вопрос:
            * POST /exam/java/add?question=QuestionText&answer=QuestionAnswer
     */
    @PostMapping("/java/add")
    public ResponseEntity<Question> addQuestion(
            @RequestParam String question,
            @RequestParam String answer) {

        Question q = new Question(question, answer);
        questionService.add(q);
        return ResponseEntity.created(null).body(q);
    }

    /*
            * Удалить вопрос:
            * DELETE /exam/java/remove?question=QuestionText&answer=QuestionAnswer
     */
    @DeleteMapping("/java/remove/{id}")
    public boolean removeQuestion(@PathVariable String id) {
        return questionService.remove(id);
    }

    /**
     * Получить все вопросы:
     * GET /exam/java
     */
    @GetMapping("/java")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> list = questionService.getAll();
        return ResponseEntity.ok(list);
    }
}