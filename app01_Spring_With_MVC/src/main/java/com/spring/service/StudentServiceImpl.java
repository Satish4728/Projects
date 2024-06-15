package com.spring.service;

import com.spring.beans.Student;
import com.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;

    }

    @Override
    public String addStudent(Student student) {
        String status=studentDao.add(student);
        return status;
    }

    @Override
    public Student searchStudent(String sid) {
        Student student=studentDao.search(sid);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students=studentDao.getAllStudents();
        return students;
    }

    @Override
    public String updateStudent(Student student) {
        String status=studentDao.update(student);
        return status;
    }

    @Override
    public String deleteStudent(String sid) {
        String status=studentDao.delete(sid);
        return status;
    }
}
