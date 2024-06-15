package com.spring.dao;

import com.spring.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String add(Student student) {
        String status="";
        try(Connection connection=dataSource.getConnection())
        {
            PreparedStatement pst=connection.prepareStatement("insert into student values(?,?,?)");
            pst.setString(1,student.getStudentId());
            pst.setString(2,student.getStudentName());
            pst.setString(3,student.getStudentAddress());
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                status="Student Inserted Successfully";
            }
            else {
                status="Student Insertion Failed";
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Student search(String sid) {
        Student student=null;
        try(Connection connection=dataSource.getConnection()){
            PreparedStatement pst=connection.prepareStatement("select * from student where SID=?");
            pst.setString(1,sid);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                student=new Student();
                student.setStudentId(rs.getString("SID"));
                student.setStudentName(rs.getString("SNAME"));
                student.setStudentAddress(rs.getString("SADDR"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students=new ArrayList<>();
        try(Connection connection=dataSource.getConnection()){
            PreparedStatement pst=connection.prepareStatement("select * from student");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                Student student=new Student();
                student.setStudentId(rs.getString("SID"));
                student.setStudentName(rs.getString("SNAME"));
                student.setStudentAddress(rs.getString("SADDR"));
                students.add(student);
            }
            if(students.size()==0)
            {
                students=null;
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return students;
    }



    @Override
    public String update(Student student) {
        String status="";
        try(Connection connection=dataSource.getConnection()){
            PreparedStatement pst=connection.prepareStatement("update student set SNAME=?,SADDR=?where SID=?");
            pst.setString(1,student.getStudentName());
            pst.setString(2,student.getStudentAddress());
            pst.setString(3,student.getStudentId());
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                status="Student Updated Successfully";
            }
            else{
                status="Student Update Failed";
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String delete(String sid) {
        String status="";
        try(Connection connection=dataSource.getConnection()){
            PreparedStatement pst=connection.prepareStatement("delete from student where SID=?");
            pst.setString(1,sid);
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                status="Student Deleted Successfully";
            }
            else{
                status="Student Deletion Failure";
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
