package ru.hogwarts.school;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FacultyController.class)
public class FacultyControllerWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    private Faculty testFaculty;



    @BeforeEach
    void setUp() {
        testFaculty = new Faculty();
        testFaculty.setId(1L);
        testFaculty.setName("Gryffindor");
        testFaculty.setColor("red");
    }

    @Test
    void testGetFaculty_Success() throws Exception {
        when(facultyService.findFaculty(1L)).thenReturn(testFaculty);

        mockMvc.perform(get("/faculty/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gryffindor"))
                .andExpect(jsonPath("$.color").value("red"));
    }

    @Test
    void testGetFaculty_NotFound() throws Exception {
        when(facultyService.findFaculty(999L)).thenReturn(null);

        mockMvc.perform(get("/faculty/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateFaculty_Success() throws Exception {
        when(facultyService.addFaculty(any(Faculty.class))).thenReturn(testFaculty);

        String json = """
            {
                "name": "Slytherin",
                "color": "green"
            }
            """;

        mockMvc.perform(post("/faculty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gryffindor"))
                .andExpect(jsonPath("$.color").value("red"));
    }

    @Test
    void testEditFaculty_Success() throws Exception {
        when(facultyService.editFaculty(eq(1L), any(Faculty.class))).thenReturn(testFaculty);

        String json = """
            {
                "name": "Ravenclaw",
                "color": "blue"
            }
            """;

        mockMvc.perform(put("/faculty/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gryffindor"))
                .andExpect(jsonPath("$.color").value("red"));
    }

    @Test
    void testEditFaculty_NotFound() throws Exception {
        when(facultyService.editFaculty(eq(999L), any(Faculty.class))).thenReturn(null);

        String json = """
            {
                "name": "Hufflepuff",
                "color": "yellow"
            }
            """;

        mockMvc.perform(put("/faculty/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteFaculty() throws Exception {
        mockMvc.perform(delete("/faculty/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}

