package ru.hogwarts.school;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.model.Student;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void testGetStudentInfo_Found() {
        // Создаём студента с name и age
        Student initial = new Student();
        initial.setName("Ivan");
        initial.setAge(20);
        Student created = restTemplate.postForObject("/student", initial, Student.class);
        assertNotNull(created);
        Long id = created.getId();

        ResponseEntity<Student> response = restTemplate.getForEntity("/student/" + id, Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ivan", response.getBody().getName());
        assertEquals(20, response.getBody().getAge());
    }

    @Test
    void testGetStudentInfo_NotFound() {
        ResponseEntity<Student> response = restTemplate.getForEntity("/student/999999", Student.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

    }

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Maria");
        student.setAge(19);

        Student result = restTemplate.postForObject("/student", student, Student.class);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("Maria", result.getName());
        assertEquals(19, result.getAge());
    }

    @Test
    void testEditStudent_Success() {
        Student initial = new Student();
        initial.setName("Alex");
        initial.setAge(21);
        Student created = restTemplate.postForObject("/student", initial, Student.class);
        Long id = created.getId();

        Student updatedPayload = new Student();
        updatedPayload.setName("Alexander");
        updatedPayload.setAge(22);

        // Стало (правильно):
        ResponseEntity<Student> response = restTemplate.exchange(
                "/student/" + id,
                org.springframework.http.HttpMethod.PUT,
                new org.springframework.http.HttpEntity<>(updatedPayload),
                Student.class
        );
    }

    @Test
    void testEditStudent_NotFound() {
        Student payload = new Student();
        payload.setName("Nobody");
        payload.setAge(30);

        ResponseEntity<Void> response = restTemplate.exchange(
                "/student/999999",
                org.springframework.http.HttpMethod.PUT,
                new org.springframework.http.HttpEntity<>(payload),
                Void.class
        );
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testDeleteStudent() {
        // 1. Создаём студента
        Student student = new Student();
        student.setName("Harry");
        student.setAge(5555);
        Student created = restTemplate.postForObject("/student", student, Student.class);
        Long id = created.getId();

        // 2. Удаляем
        ResponseEntity<Void> response = restTemplate.exchange(
                "/student/" + id,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        // 3. Проверяем статус
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // 4. Проверяем, что студента больше нет
        ResponseEntity<Student> getResponse = restTemplate.getForEntity(
                "/student/" + id,
                Student.class
        );
        assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
    }
}