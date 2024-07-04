package com.core.factory;

import com.core.controller.StudentController;
import com.core.controller.StudentControllerImpl;

public class StudentControllerFactory {
    private static StudentController studentController;
    static{
        studentController=new StudentControllerImpl();
    }
    public static StudentController getStudentController()
    {
        return studentController;
    }
}
