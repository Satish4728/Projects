package com.core.repository;

public class StudentRepositoryImp implements StudentRepository{
    @Override
    public String add() {
        System.out.println("StudentRepository:Adding Student in database by using JDBC Code");

        return "Student Added Successfully";
    }

    @Override
    public String search() {
        System.out.println("StudentRepository:Searching Student in the database using JDC code");
        return "Student Search Successfully";
    }

    @Override
    public String update() {
        System.out.println("StudentRepository:Updating Student in database buy using JDBC Code");
        return "Student Updated Successfully";
    }

    @Override
    public String delete() {
        System.out.println("StudentRepository :Deleting Student in database by using JDBC Code");
        return "Student Deleted Successfully";
    }
}
