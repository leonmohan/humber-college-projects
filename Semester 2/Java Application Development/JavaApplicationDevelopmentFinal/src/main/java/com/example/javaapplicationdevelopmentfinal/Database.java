package com.example.javaapplicationdevelopmentfinal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class Database
{
    //Staff
    public ObservableList<Staff> getStaff()
    {
        ObservableList<Staff> staff = FXCollections.observableArrayList();

        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();

            //Execute SQL query
            ResultSet myRs = myStatement.executeQuery("SELECT * FROM staff");

            //Process the result set
            while (myRs.next())
            {
                staff.add(new Staff(myRs.getInt("id"), myRs.getString("name"), myRs.getString("job")));
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

        return staff;
    }

    public void insertStaff(String name, String job)
    {
        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();
            String sql = "INSERT INTO staff (NAME, JOB) VALUES('"+name+"',"+"'"+job+"')";

            //Execute SQL query
            myStatement.executeUpdate(sql);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public void updateStaff(Integer id, String name, String job)
    {
        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();
            String sql = "UPDATE staff SET name='"+name+"', job='"+job+"'"+" WHERE id="+id;

            //Execute SQL query
            myStatement.executeUpdate(sql);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public void deleteStaff(Integer id)
    {
        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();
            String sql = "DELETE FROM staff WHERE id=" + id;

            //Execute SQL query
            myStatement.executeUpdate(sql);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }


    //Animals
    public ObservableList<Animal> getAnimal()
    {
        ObservableList<Animal> animal = FXCollections.observableArrayList();

        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();

            //Execute SQL query
            ResultSet myRs = myStatement.executeQuery("SELECT * FROM animals");

            //Process the result set
            while (myRs.next())
            {
                animal.add(new Animal(myRs.getInt("id"), myRs.getString("name"), myRs.getString("gender"), myRs.getInt("age"), myRs.getString("animal")));
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

        return animal;
    }

    public void insertAnimal(String name, String gender, Integer age, String animal)
    {
        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();
            String sql = "INSERT INTO animals (NAME, GENDER, AGE, ANIMAL) VALUES('"+name+"',"+"'"+gender+"',"+"'"+age+"',"+"'"+animal+"')";

            //Execute SQL query
            myStatement.executeUpdate(sql);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public void updateAnimal(Integer id, String name, String gender, Integer age, String animal)
    {
        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();
            String sql = "UPDATE animals " +
                    "SET name='"+name+"'," +
                    "gender='"+gender+"', " +
                    "age="+age+"," +
                    "animal='"+animal+"'" +
                    "WHERE id="+id;

            //Execute SQL query
            myStatement.executeUpdate(sql);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public void deleteAnimal(Integer id)
    {
        try
        {
            //Get a connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "1234");

            //Create a statement
            Statement myStatement = myConn.createStatement();
            String sql = "DELETE FROM animals WHERE id=" + id;

            //Execute SQL query
            myStatement.executeUpdate(sql);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
}
