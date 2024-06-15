package com.jdbc.dao;

import com.jdbc.beans.Employee;
import com.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    Connection connection= ConnectionFactory.getConnection();
    @Override
    public String add(Employee employee) {
        String status="";
        try{
            Statement statement=connection.createStatement();
            int rowCount=statement.executeUpdate("insert into emp1 values("+employee.getEno()+",'"+employee.getEname()+"',"+employee.getEsal()+",'"+employee.getEaddr()+"')");
            if(rowCount==1)
            {
                status="SUCCESS";
            }
            else
            {
                status="Failure";
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public Employee search(int eno) {
        Employee employee=null;
        try{
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from emp1 where ENO="+eno);
            boolean b=rs.next();
            if(b==true)
            {
                employee=new Employee();
                employee.setEno(rs.getInt("ENO"));
                employee.setEname(rs.getString("ENAME"));
                employee.setEsal(rs.getFloat("ESAL"));
                employee.setEaddr(rs.getString("EADDR"));
            }
            else{
                employee=null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList=null;
        try{
            employeeList=new ArrayList();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from emp1");
            while(rs.next())
            {
                Employee employee=new Employee();
                employee.setEno(rs.getInt("ENO"));
                employee.setEname(rs.getString("ENAME"));
                employee.setEsal(rs.getFloat("ESAL"));
                employee.setEaddr(rs.getString("EADDR"));
                employeeList.add(employee);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public String update(Employee employee) {
        String status="";
        try{
           Statement st=connection.createStatement();
           int rowCount=st.executeUpdate("update emp1 set ENAME ='"+employee.getEname()+"',ESAL = "+employee.getEsal()+",EADDR = '"+employee.getEaddr()+"' where ENO = "+employee.getEno());
           if(rowCount==1)
           {
               status="SUCCESS";
           }
           else {
               status="FAILURE";
           }
        }
        catch(Exception e)
        {
            status="FAILURE";
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public String delete(int eno) {
        String status="";
        try{
            Statement st=connection.createStatement();
            int rowCount=st.executeUpdate("delete from emp1 where ENO="+eno);
            if(rowCount==1)
            {
                status="SUCESS";
            }
            else {
                status="FAILURE";
            }
        }
        catch(Exception e)
        {
            status="FAILURE";
            e.printStackTrace();
        }
        return status;
    }
}
