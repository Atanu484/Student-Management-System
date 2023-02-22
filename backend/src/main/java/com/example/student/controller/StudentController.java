package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
//This is the class where all the APIs will be created and managed
public class StudentController {


    //Calling studentService and creating object; so we could call services from controller and thus calling the repository
    @Autowired
    private final StudentService studentService;

    //So, when an object of an studentController class is created, studentServices will be automatically created and injected
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student createstudent(@RequestBody Student student) {
        return studentService.createstudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllstudents() {
        return  studentService.getAllstudents();
    }

    // It deletes the student by id
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String,Boolean>> deletestudent(@PathVariable Long id) {
        boolean deleted = false; //created a flag
        deleted = studentService.deletestudent(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    //It gets the data by id. So it could be edited
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getstudentById(@PathVariable Long id) {
        Student student = null;
        student = studentService.getstudentById(id);
        return ResponseEntity.ok(student);
    }

    //It updates the data based on id
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updatestudent(@PathVariable Long id,
                                                 @RequestBody Student student) {
        student = studentService.updatestudent(id, student);
        return ResponseEntity.ok(student);
    }

}