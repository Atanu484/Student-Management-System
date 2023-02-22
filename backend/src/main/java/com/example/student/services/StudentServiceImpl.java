package com.example.student.services;

import com.example.student.entity.StudentEntity;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// A class which implements services from the studentServices.
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // All the methods are getting the data and passing it to the controller.
    @Override
    public Student createstudent(Student student) {
        //We have to convert it to save it to database
        StudentEntity studentEntity = new StudentEntity();

        //It copies from student and sends it to studentEntity
        BeanUtils.copyProperties(student, studentEntity);
        studentRepository.save(studentEntity);
        return student;
    }


    //Gets all the students form the database.
    @Override
    public List<Student> getAllstudents() {
        List<StudentEntity> studentEntities
                = studentRepository.findAll();

        //Collected list of students from repository and created a new object. So it could be presented at the UI.
        List<Student> students = studentEntities
                .stream()
                .map(emp -> new Student(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return students;
    }

    //Finds the student by id and deletes it.
    @Override
    public boolean deletestudent(Long id) {
        StudentEntity student = studentRepository.findById(id).get();
        studentRepository.delete(student);
        return true;
    }

    // This method unlike the above, only finds the student by id.
    @Override
    public Student getstudentById(Long id) {
        StudentEntity studentEntity
                = studentRepository.findById(id).get();
        Student student = new Student();
        BeanUtils.copyProperties(studentEntity, student);
        return student;
    }

    // This is the method which only updates the student by its id.
    @Override
    public Student updatestudent(Long id, Student student) {
        StudentEntity studentEntity
                = studentRepository.findById(id).get();
        studentEntity.setEmailId(student.getEmailId());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());

        studentRepository.save(studentEntity);
        return student;
    }
}