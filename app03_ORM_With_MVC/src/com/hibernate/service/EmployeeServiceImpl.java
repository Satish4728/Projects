package com.hibernate.service;

import com.hibernate.beans.Employee;
import com.hibernate.dao.EmployeeDao;
import com.hibernate.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDao employeeDao= EmployeeDaoFactory.getEmployeeDao();
    @Override
    public String addEmployee(Employee employee) {
        String status=employeeDao.add(employee);

        return status;
    }

    @Override
    public Employee searchEmployee(int eno) {
        return null;
    }

    @Override
    public String updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public String deleteEmployee(int eno) {
        return null;
    }
}
