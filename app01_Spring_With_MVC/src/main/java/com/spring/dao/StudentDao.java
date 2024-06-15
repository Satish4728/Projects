package com.spring.dao;

import com.spring.beans.Student;

import java.util.List;

public interface StudentDao {
    public String add(Student student);
    public Student search(String sid);
    public List<Student> getAllStudents();
    public String update(Student student);
    public String delete(String sid);
}
