package com.core.factory;

import com.core.repository.StudentRepository;
import com.core.repository.StudentRepositoryImp;

public class StudentRepositoryFactory {
    private static StudentRepository studentRepository;
    static{
        studentRepository=new StudentRepositoryImp();
    }
    public static StudentRepository getStudentRepository()
    {
        return studentRepository;
    }
}
