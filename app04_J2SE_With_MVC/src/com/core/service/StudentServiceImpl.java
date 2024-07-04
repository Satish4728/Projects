package com.core.service;

import com.core.factory.StudentRepositoryFactory;
import com.core.repository.StudentRepository;


public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository= StudentRepositoryFactory.getStudentRepository();
    @Override
    public String addStudent() {
        System.out.println("Student Service:addStudent() accessing StudentRepository.add() Method");
        String status=studentRepository.add();
        return status;
    }

    @Override
    public String searchStudent() {
        System.out.println("Student Service:searchStudent() accessing StudentRepository.search() Method");
        String status=studentRepository.search();
        return status;
    }

    @Override
    public String updateStudent() {
        System.out.println("Student Service:updateStudent() accessing StudentRepository.update() Method");
        String status=studentRepository.update();
        return status;
    }

    @Override
    public String deleteStudent() {
        System.out.println("Student Service:deleteStudent() accessing StudentRepository.delete() Method");
        String status=studentRepository.delete();
        return status;
    }
}
