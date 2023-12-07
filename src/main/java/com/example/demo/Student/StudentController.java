package com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.save(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            // Handle the exception and return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getStudents(){
        return studentService.findAll();
    }


}
