package com.hibernate.dao;

import com.hibernate.beans.Employee;
import com.hibernate.factory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class EmployeeDaoImpl implements EmployeeDao{
   SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    @Override
    public String add(Employee employee) {
        String status="";
        try{
           Session session=sessionFactory.openSession();
           Transaction tx=session.beginTransaction();
           int eno=(Integer)session.save(employee);
           tx.commit();
           if(eno== employee.getEno())
           {
               status="SUCCESS";
           }
           else{
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
    public Employee search(int eno) {
        return null;
    }

    @Override
    public String update(Employee employee) {
        return null;
    }

    @Override
    public String delete(int eno) {
        return null;
    }
}
