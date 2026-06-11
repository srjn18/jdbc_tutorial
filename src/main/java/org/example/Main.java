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
           Connection connection =DriverManager.getConnection(url,username,password);//to connect to the database
           Statement statement = connection.createStatement();

         /*  //insert into the database using JDBC
           String query= String.format("Insert into students(name,age,marks) values('%s',%o,%f)","Jayasheela",50,75.6);
            int rowsAffected=statement.executeUpdate(query);//except select all other return integer value

           //to select the data from the database
            ResultSet result=statement.executeQuery("Select * from students");
           while(result.next()) {
               int id = result.getInt("id");
               String name = result.getString("name");
               int age = result.getInt("age");
               double marks = result.getDouble("marks");
               System.out.println("ID:" + id + " Name:" + name + " age" + age + " Marks:" + marks);
           }
            System.out.println(" ");

            //update operation being performed
               System.out.println("data after updating the database");
               query = String.format("update students set marks=%f where id=%o", 75.5, 1);
               rowsAffected = statement.executeUpdate(query); //returns an integer
               result = statement.executeQuery("Select * from students");


               while (result.next()) {
                   int id = result.getInt("id");
                   String name = result.getString("name");
                   int age = result.getInt("age");
                   double marks = result.getDouble("marks");
                   System.out.println("ID:" + id + " Name:" + name + " age" + age + " Marks:" + marks);
               }*/

               //delete operation is being performed
           int rowsAffected=statement.executeUpdate("delete from students where id=2");


        } catch(SQLException s) {
            s.printStackTrace();
        }
    }
}