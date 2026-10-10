package ru.hogwarts.school.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import java.util.List;



@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/count")
    public ResponseEntity<Long> getTotalStudentsCount() {
        return ResponseEntity.ok(studentService.getTotalStudentsCount());
    }

    @GetMapping("/average-age")
    public ResponseEntity<Double> getAverageAge() {
        return ResponseEntity.ok(studentService.getAverageAge());
    }

    @GetMapping("/last-five")
    public ResponseEntity<List<Student>> getLastFiveStudents() {
        return ResponseEntity.ok(studentService.getLastFiveStudents());
    }


    @GetMapping("/names/startsWithA")
    public ResponseEntity<List<String>> getStudentNamesStartingWithA() {
        List<String> names = studentService.getStudentNamesStartingWithA();
        return ResponseEntity.ok(names);
    }


    @GetMapping("/students/print-parallel")
    public ResponseEntity<String> printParallel() {
        List<Student> allStudents = studentService.getAllStudents();
        // Берём максимум 6, чтобы не выйти за границы при малом количестве студентов
        List<Student> students = allStudents.stream()
                .limit(6)
                .toList();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return ResponseEntity.ok("No students to print.");
        }

        // 1. Первые два имени — в основном потоке
        System.out.println(students.get(0).getName());
        if (students.size() > 1) {
            System.out.println(students.get(1).getName());
        }

        // 2. Третье и четвёртое — в отдельном потоке
        if (students.size() > 2) {
            Thread t1 = new Thread(() -> {
                System.out.println(students.get(2).getName());
                if (students.size() > 3) {
                    System.out.println(students.get(3).getName());
                }
            });
            t1.start();
        }

        // 3. Пятое и шестое — в ещё одном отдельном потоке
        if (students.size() > 4) {
            Thread t2 = new Thread(() -> {
                System.out.println(students.get(4).getName());
                if (students.size() > 5) {
                    System.out.println(students.get(5).getName());
                }
            });
            t2.start();
        }

        return ResponseEntity.ok("Parallel print initiated.");
    }

    @GetMapping("/print-synchronized")
    public ResponseEntity<String> printSynchronized() {

        List<Student> allStudents = studentService.getAllStudents();
        List<Student> students = allStudents.stream().limit(6).toList();

        if (students.isEmpty()) {
            synchronizedPrint(null); // просто чтобы показать вызов
            return ResponseEntity.ok("No students to print.");
        }


        synchronizedPrint(students.get(0).getName());
        if (students.size() > 1) {
            synchronizedPrint(students.get(1).getName());
        }


        if (students.size() > 2) {
            Thread t1 = new Thread(() -> {
                synchronizedPrint(students.get(2).getName());
                if (students.size() > 3) {
                    synchronizedPrint(students.get(3).getName());
                }
            });
            t1.start();
        }


        if (students.size() > 4) {
            Thread t2 = new Thread(() -> {
                synchronizedPrint(students.get(4).getName());
                if (students.size() > 5) {
                    synchronizedPrint(students.get(5).getName());
                }
            });
            t2.start();
        }

        return ResponseEntity.ok("Synchronized print initiated.");
    }

    //Отдельный синхронизированный метод для безопасного вывода в консоль.
    private synchronized void synchronizedPrint(String name) {
        if (name == null) {
            System.out.println("[null]");
            return;
        }
        System.out.println(name);
    }


}





