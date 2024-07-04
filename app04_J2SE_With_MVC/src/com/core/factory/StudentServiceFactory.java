package com.core.factory;

import com.core.service.StudentService;
import com.core.service.StudentServiceImpl;

public class StudentServiceFactory {
    private static StudentService studentService;
    static{
        studentService=new StudentServiceImpl();
    }
    public static StudentService getStudentService()
    {
        return studentService;
    }
}
