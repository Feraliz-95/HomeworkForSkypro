package ru.hogwarts.school.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;


@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        if (!facultyRepository.existsById(id)) {
            return null;
        }
        faculty.setId(id);
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> searchFaculties(String query) {
        if (query == null || query.isBlank()) {
            return facultyRepository.findAll();
        }
        return facultyRepository.findByNameContainingIgnoreCaseOrColorContainingIgnoreCase(
                query, query);
    }
}
