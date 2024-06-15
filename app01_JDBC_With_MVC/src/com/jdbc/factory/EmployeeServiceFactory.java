package com.jdbc.factory;

import com.jdbc.service.EmployeeService;
import com.jdbc.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
    private static EmployeeService employeeService;
    static{
        employeeService=new EmployeeServiceImpl();
    }
    public static EmployeeService getEmployeeService()
    {
        return employeeService;
    }

}
