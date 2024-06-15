package com.jdbc.factory;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
    private static EmployeeDao employeeDao;
    static{
        employeeDao=new EmployeeDaoImpl();
    }
    public  static EmployeeDao getEmployeeDao()
    {
        return employeeDao;
    }
}
