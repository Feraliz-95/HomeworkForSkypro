package org.example.exam_questions;

import org.example.exam_questions.exception.ExamException;
import org.example.exam_questions.questionExam.Question;
import org.example.exam_questions.serviceExam.ExaminerServiceImpl;
import org.example.exam_questions.serviceExam.JavaQuestionService;
import org.example.exam_questions.serviceExam.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ExamQuestionsApplicationTests {

	@Test
	void contextLoads() {
	}

}

class JavaQuestionServiceTest {

	private JavaQuestionService service;
	private Question q1;
	private Question q2;
	private Question q3;

	@BeforeEach
	void setUp() {
		service = new JavaQuestionService(); // чистый сервис без дефолтных вопросов
		q1 = new Question("Вопрос 1", "Ответ 1");
		q2 = new Question("Вопрос 2", "Ответ 2");
		q3 = new Question("Вопрос 3", "Ответ 3");
	}

	@Test
	void add_addsQuestionToList() {
		service.add(q1);
		List<Question> all = service.getAll();
		assertEquals(1, all.size());
		assertEquals(q1, all.get(0)); // работает благодаря equals
	}

	@Test
	void remove_removesQuestionById() {
		service.add(q1);
		service.add(q2);

		assertTrue(service.remove(q1.getId()));
		List<Question> all = service.getAll();
		assertEquals(1, all.size());
		assertEquals(q2, all.get(0));

		assertFalse(service.remove("non-existing-id"));
	}

	@Test
	void getAll_returnsCopyOfList() {
		service.add(q1);
		List<Question> result1 = service.getAll();
		List<Question> result2 = service.getAll();

		assertEquals(1, result1.size());
		assertNotSame(result1, result2); // разные экземпляры списков
	}

	@Test
	void getRandomQuestion_returnsNullWhenEmpty() {
		assertNull(service.getRandomQuestion());
	}

	@Test
	void getRandomQuestion_returnsOneOfExistingQuestions() {
		service.add(q1);
		service.add(q2);
		service.add(q3);

		Question random = service.getRandomQuestion();
		assertNotNull(random);
		assertTrue(random.equals(q1) || random.equals(q2) ||  random.equals(q3));
	}
}

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

	@InjectMocks
	private ExaminerServiceImpl examinerService;

	@Mock
	private QuestionService questionService;

	private List<Question> questions;

	@BeforeEach
	void setUp() {
		Question q1 = new Question("Q1", "A1");
		Question q2 = new Question("Q2", "A2");
		Question q3 = new Question("Q3", "A3");
		questions = Arrays.asList(q1, q2, q3);
	}

	@Test
	void getQuestions_returnsUniqueRandomQuestions() {
		when(questionService.getAll()).thenReturn(questions);

		List<Question> result = examinerService.getQuestions(2);

		assertEquals(2, result.size());

		// Уникальность: количество distinct равно размеру списка
		long distinctCount = result.stream().distinct().count();
		assertEquals(result.size(), distinctCount);

		result.forEach(q -> assertTrue(questions.contains(q)));
	}

	@Test
	void getQuestions_throwsWhenAmountExceedsAvailable() {
		when(questionService.getAll()).thenReturn(questions);

		ExamException exception = assertThrows(
				ExamException.class,
				() -> examinerService.getQuestions(10)
		);

		assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
		assertTrue(exception.getMessage().contains("больше вопросов"));
	}

	@Test
	void getQuestions_throwsWhenNoQuestionsAvailable() {
		when(questionService.getAll()).thenReturn(Collections.emptyList());

		ExamException exception = assertThrows(
				ExamException.class,
				() -> examinerService.getQuestions(1)
		);

		assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
	}
	@Test
	void getQuestions_throwsWhenZeroOrNegativeAmount() {
		assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(0));
		assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(-1));
	}

	@Test
	void getQuestions_returnsAllWhenAmountEqualsSize() {
		when(questionService.getAll()).thenReturn(questions);

		List<Question> result = examinerService.getQuestions(3);

		assertEquals(3, result.size());
		assertTrue(result.containsAll(questions));
	}
}
