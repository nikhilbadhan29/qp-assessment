package com.apiDemo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "New Student Added";
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Student Updated Successfully";
    }

    @Override
    public String deleteStudent(String studentID) {
        studentRepository.deleteById(studentID);
        return "Deleted";
    }

    @Override
    public Student getStudent(String studentID) {
        return studentRepository.findById(studentID).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }
}
