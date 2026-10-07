package ru.hogwarts.school.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Comparator;
import java.util.List;


@Service
public class FacultyServiceImpl implements FacultyService{

    private static final Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {

        logger.debug("Invoked addFaculty with faculty id={}, name={}",
                faculty.getId(), faculty.getName());
        logger.info("Adding new faculty: name={}", faculty.getName());
        Faculty saved = facultyRepository.save(faculty);
        logger.info("Successfully added faculty with id={}", saved.getId());
        return saved;


    }

    @Override
    public Faculty findFaculty(long id) {

        logger.debug("Invoked findFaculty with id={}", id);
        logger.info("Searching for faculty with id={}", id);

        Faculty faculty = facultyRepository.findById(id).orElse(null);

        if (faculty == null) {
            logger.warn("No faculty found with id={}", id);
        } else {
            logger.debug("Found faculty: id={}, name={}", faculty.getId(), faculty.getName());
        }
        return faculty;
    }

    public Faculty editFaculty(long id, Faculty faculty) {


        logger.debug("Invoked editFaculty with id={}, new faculty name={}", id, faculty.getName());
        logger.info("Updating faculty with id={}", id);
        if (!facultyRepository.existsById(id)) {
            String msg = "There is no faculty with id = " + id;
            logger.error(msg);
            return null;
        }

        faculty.setId(id);
        Faculty updated = facultyRepository.save(faculty);
        logger.info("Successfully updated faculty with id={}", updated.getId());
        return updated;
    }

    public void deleteFaculty(long id) {
        logger.debug("Invoked deleteFaculty with id={}", id);
        logger.info("Deleting faculty with id={}", id);
        if (!facultyRepository.existsById(id)) {
            String msg = "There is no faculty with id = " + id + " to delete";
            logger.warn(msg);
            return;
        }

        facultyRepository.deleteById(id);
        logger.info("Successfully deleted faculty with id={}", id);
    }


    public List<Faculty> searchFaculties(String query) {

        logger.debug("Invoked searchFaculties with query='{}'", query);
        logger.info("Searching faculties with query='{}'", query);
        if (query == null || query.isBlank()) {
            logger.debug("Empty query provided, returning all faculties");
            List<Faculty> all = facultyRepository.findAll();
            logger.info("Returned {} faculties (all)", all.size());
            return all;
        }
        List<Faculty> result = facultyRepository.findByNameContainingIgnoreCaseOrColorContainingIgnoreCase(
                query, query);
        logger.info("Search completed for query='{}', found {} faculties", query, result.size());
        return result;
    }

    @Override
    public String getLongestFacultyName() {
        List<Faculty> faculties = facultyRepository.findAll();
        if (faculties.isEmpty()) return "";
        return faculties.stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
