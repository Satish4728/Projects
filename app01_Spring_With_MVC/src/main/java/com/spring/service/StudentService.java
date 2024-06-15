package com.spring.service;

import com.spring.beans.Student;

import java.util.List;

public interface StudentService {
    public String addStudent(Student student);
    public Student searchStudent(String sid);
    public List<Student> getAllStudents();
    public String updateStudent(Student student);
    public String deleteStudent(String sid);


}
