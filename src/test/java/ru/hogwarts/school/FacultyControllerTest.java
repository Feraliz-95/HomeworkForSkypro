package ru.hogwarts.school;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import ru.hogwarts.school.model.Faculty;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetFacultyInfo_Found() {
        Faculty initial = new Faculty();
        initial.setName("Engineering");
        initial.setColor("blue");
        Faculty created = restTemplate.postForObject("/faculty", initial, Faculty.class);
        assertNotNull(created);
        Long id = created.getId();

        ResponseEntity<Faculty> response = restTemplate.getForEntity("/faculty/" + id, Faculty.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Engineering", response.getBody().getName());
        assertEquals("blue", response.getBody().getColor());
    }

    @Test
    void testGetFacultyInfo_NotFound() {
        ResponseEntity<Faculty> response = restTemplate.getForEntity("/faculty/999999", Faculty.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testCreateFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("Mathematics");
        faculty.setColor("green");

        Faculty result = restTemplate.postForObject("/faculty", faculty, Faculty.class);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("Mathematics", result.getName());
        assertEquals("green", result.getColor());
    }

    @Test
    void testEditFaculty_Success() {
        Faculty initial = new Faculty();
        initial.setName("Physics");
        initial.setColor("red");
        Faculty created = restTemplate.postForObject("/faculty", initial, Faculty.class);
        Long id = created.getId();

        Faculty updatedPayload = new Faculty();
        updatedPayload.setName("Applied Physics");
        updatedPayload.setColor("orange");

        // Act: отправляем PUT-запрос через exchange
        ResponseEntity<Faculty> response = restTemplate.exchange(
                "/faculty/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(updatedPayload, createJsonHeaders()),
                Faculty.class
        );

        // Assert: проверяем результат
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Applied Physics", response.getBody().getName());
        assertEquals("orange", response.getBody().getColor());


    }

    @Test
    void testEditFaculty_NotFound() {
        Faculty payload = new Faculty();
        payload.setName("Unknown Faculty");
        payload.setColor("black");

        ResponseEntity<Void> response = restTemplate.exchange(
                "/faculty/999999",
                org.springframework.http.HttpMethod.PUT,
                new org.springframework.http.HttpEntity<>(payload),
                Void.class
        );
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testDeleteFaculty() {
        Faculty initial = new Faculty();
        initial.setName("Chemistry");
        initial.setColor("purple");
        Faculty created = restTemplate.postForObject("/faculty", initial, Faculty.class);
        Long id = created.getId();

        ResponseEntity<Void> response = restTemplate.exchange(
                "/faculty/" + id,
                org.springframework.http.HttpMethod.DELETE,
                null,
                Void.class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());

        ResponseEntity<Faculty> getAfterDelete = restTemplate.getForEntity("/faculty/" + id, Faculty.class);
        assertEquals(HttpStatus.NOT_FOUND, getAfterDelete.getStatusCode());
    }

    private HttpHeaders createJsonHeaders() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}