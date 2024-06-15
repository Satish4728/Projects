package com.jdbc.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {


    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","1234");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() {

        return connection;
    }
    public static void cleanup()
    {
        try{
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
