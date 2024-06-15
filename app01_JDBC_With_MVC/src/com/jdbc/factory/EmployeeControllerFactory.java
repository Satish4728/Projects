package com.jdbc.factory;

import com.jdbc.controller.EmployeeController;

public class EmployeeControllerFactory {
    private static EmployeeController employeeController;
    static{
        employeeController=new EmployeeController();

    }
    public static EmployeeController getEmployeeController()
    {
        return employeeController;
    }

}
