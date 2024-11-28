package com.apiDemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentServiceImplementation studentServiceImplementation;

    public StudentController(StudentServiceImplementation studentServiceImplementation) {
        this.studentServiceImplementation = studentServiceImplementation;
    }

    @GetMapping("{studentID}")
    public Student getStudent(@PathVariable("studentID") String studentID){
        System.out.println("studentID"+studentID);
        return studentServiceImplementation.getStudent(studentID);
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        return studentServiceImplementation.createStudent(student);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student){
        return studentServiceImplementation.updateStudent(student);
    }

    @DeleteMapping("/delete/{studentID}")
    public String deleteStudent(@PathVariable("studentID") String studentID){
        return studentServiceImplementation.deleteStudent(studentID);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentServiceImplementation.getAllStudents();
    }
}
