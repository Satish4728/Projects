package com.core.controller;

import com.core.factory.StudentServiceFactory;
import com.core.service.StudentService;

public class StudentControllerImpl implements StudentController {
    StudentService studentService= StudentServiceFactory.getStudentService();
    public String addStudent()
    {
        System.out.println("StudentController:addStudent is accessing StudentService.addStudent()");
        String status=studentService.addStudent();
        return status;

    }
    public String searchStudent()
    {
        System.out.println("StudentController:searchStudent is accessing StudentService.searchStudent()");
        String status=studentService.searchStudent();
        return status;
    }
    public String updateStudent()
    {
        System.out.println("StudentController:updateStudent is accessing StudentService.updateStudent()");
        String status=studentService.updateStudent();
        return status;
    }
    public String deleteStudent()
    {
        System.out.println("StudentController:deleteStudent is accessing StudentService.deleteStudent()");
        String status=studentService.deleteStudent();
        return status;
    }
}
