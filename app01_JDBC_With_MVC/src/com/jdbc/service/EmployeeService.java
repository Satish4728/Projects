package com.jdbc.service;

import com.jdbc.beans.Employee;
import java.util.List;

public interface EmployeeService {
    public String addEmployee(Employee employee);
    public Employee searchEmployee(int eno);
    public List<Employee> getAllEmployee();
    public String updateEmployee(Employee employee);
    public String deleteEmployee(int eno);

}
