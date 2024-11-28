package com.apiDemo.service;

import java.util.List;

public interface StudentService {
    public String createStudent(Student student);
    public String updateStudent(Student student);
    public String deleteStudent(String studentID);
    public Student getStudent(String studentID);
    public List<Student> getAllStudents();

}
