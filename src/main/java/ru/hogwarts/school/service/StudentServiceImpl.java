package ru.hogwarts.school.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl  implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student) {
        logger.debug("Invoked addStudent with student id={}, name={}",
                student.getId(), student.getName());
        logger.info("Adding new student: name={}", student.getName());

        Student saved = studentRepository.save(student);
        logger.info("Successfully added student with id={}", saved.getId());
        return saved;
    }

    public Student findStudent(long id) {
        logger.debug("Invoked findStudent with id={}", id);
        logger.info("Searching for student with id={}", id);

        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            logger.warn("No student found with id={}", id);
        } else {
            logger.debug("Found student: id={}, name={}", student.getId(), student.getName());
        }
        return student;
    }

    public Student editStudent(long id, Student student) {
        logger.debug("Invoked editStudent with id={}, new student name={}", id, student.getName());
        logger.info("Updating student with id={}", id);

        if (!studentRepository.existsById(id)) {
            String msg = "There is no student with id = " + id;
            logger.error(msg);
            return null;
        }

        student.setId(id);
        Student updated = studentRepository.save(student);
        logger.info("Successfully updated student with id={}", updated.getId());
        return updated;
    }

    public void deleteStudent(long id) {
        logger.debug("Invoked deleteStudent with id={}", id);
        logger.info("Deleting student with id={}", id);

        if (!studentRepository.existsById(id)) {
            String msg = "There is no student with id = " + id + " to delete";
            logger.warn(msg);
            return;
        }

        studentRepository.deleteById(id);
        logger.info("Successfully deleted student with id={}", id);
    }

    @Override
    public List<Student> getStudentsByAgeRange(int minAge, int maxAge) {
        logger.debug("Invoked getStudentsByAgeRange with minAge={}, maxAge={}", minAge, maxAge);
        logger.info("Fetching students with age between {} and {}", minAge, maxAge);

        if (minAge < 0 || maxAge < 0 || minAge > maxAge) {
            logger.warn("Invalid age range: minAge={}, maxAge={}. Swapping or correcting values.", minAge, maxAge);
            if (minAge > maxAge) {
                int temp = minAge;
                minAge = maxAge;
                maxAge = temp;
            }
            if (minAge < 0) minAge = 0;
            if (maxAge < 0) maxAge = 0;
        }

        List<Student> students = studentRepository.findByAgeBetween(minAge, maxAge);
        logger.info("Found {} students in age range [{}, {}]", students.size(), minAge, maxAge);
        return students;
    }


    @Override
    public long getTotalStudentsCount() {
        logger.debug("Invoked getTotalStudentsCount");
        logger.info("Fetching total students count");

        long count = studentRepository.countAllStudents();
        logger.info("Total students count: {}", count);
        return count;
    }


    @Override
    public List<Student> getLastFiveStudents() {
        logger.debug("Invoked getLastFiveStudents");
        logger.info("Fetching last 5 students");

        List<Student> students = studentRepository.findLastFiveStudents();
        logger.info("Fetched {} students (last 5)", students.size());
        return students;
    }


    public List<String> getStudentNamesStartingWithA() {
        return studentRepository.findAll().stream()
                .filter(s -> s.getName() != null && s.getName().startsWith("A"))
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }



    @Override
    public Double getAverageAge() {
        logger.debug("Invoked getAverageAge");
        logger.info("Calculating average student age");

        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            logger.info("No students found, returning average age as 0.0");
            return 0.0;
        }

        double avg = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);

        logger.info("Average student age: {}", avg);
        return avg;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}




