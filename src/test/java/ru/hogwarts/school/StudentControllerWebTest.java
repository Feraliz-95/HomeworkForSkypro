package ru.hogwarts.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerWebTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student testStudent;


    @BeforeEach
    void setUp() {
        testStudent = new Student();
        testStudent.setId(1L);
        testStudent.setName("Harry Potter");
        testStudent.setAge(15);
    }

    @Test
    void testGetStudentInfo_Success() throws Exception {
        when(studentService.findStudent(1L)).thenReturn(testStudent);

        mockMvc.perform(get("/student/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Harry Potter"))
                .andExpect(jsonPath("$.age").value(15));
    }

    @Test
    void testGetStudentInfo_NotFound() throws Exception {
        when(studentService.findStudent(999L)).thenReturn(null);

        mockMvc.perform(get("/student/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateStudent_Success() throws Exception {
        when(studentService.addStudent(any(Student.class))).thenReturn(testStudent);

        String json = """
            {
                "name": "Hermione Granger",
                "age": 14
            }
            """;

        mockMvc.perform(post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Harry Potter"))
                .andExpect(jsonPath("$.age").value(15));
    }

    @Test
    void testEditStudent_Success() throws Exception {
        when(studentService.editStudent(eq(1L), any(Student.class))).thenReturn(testStudent);

        String json = """
            {
                "name": "Ron Weasley",
                "age": 16
            }
            """;

        mockMvc.perform(put("/student/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Harry Potter"))
                .andExpect(jsonPath("$.age").value(15));
    }

    @Test
    void testEditStudent_NotFound() throws Exception {
        when(studentService.editStudent(eq(999L), any(Student.class))).thenReturn(null);

        String json = """
            {
                "name": "Neville Longbottom",
                "age": 17
            }
            """;

        mockMvc.perform(put("/student/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteStudent() throws Exception {
        mockMvc.perform(delete("/student/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
