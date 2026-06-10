package org.example;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    private static final String url="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password="srujanBhat18";
    public static void main(String args[]) {
       // System.out.println("Hello, World!");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
           Connection connection =DriverManager.getConnection(url,username,password);
           Statement statement = connection.createStatement();
           String query= String.format("Insert into students(name,age,marks) values('%s',%o,%f)","Jayasheela",50,75.6);
            int rowsAffected=statement.executeUpdate(query);
            ResultSet result=statement.executeQuery("Select * from students");
           while(result.next()) {
               int id = result.getInt("id");
               String name = result.getString("name");
               int age = result.getInt("age");
               double marks = result.getDouble("marks");
               System.out.println("ID:" + id + " Name:" + name + " age" + age + " Marks:" + marks);
           }
            System.out.println(" ");
             System.out.println("data after updating the database");
               query = String.format("update students set marks=%f where id=%o", 75.5, 1);
               rowsAffected = statement.executeUpdate(query);
               result = statement.executeQuery("Select * from students");
               while (result.next()) {
                   int id = result.getInt("id");
                   String name = result.getString("name");
                   int age = result.getInt("age");
                   double marks = result.getDouble("marks");
                   System.out.println("ID:" + id + " Name:" + name + " age" + age + " Marks:" + marks);

               }

        } catch(SQLException s) {
            s.printStackTrace();
        }
    }
}