package ua.foxminded.skarb.config;

import java.sql.*;

public class VolunteerDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String query = "select * from dbo";
        //Driver name
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // DB: url, username, password
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://185.149.40.46:1433;database=SkarbNgoDB;encrypt=false", "sa", "37Y5Nb8uTo2");
        System.out.println("Connection Established successfully");

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        String firstName = result.getString("FirstName");
        String lastName = result.getString("LastName");
        String email = result.getString("Email");
        String password = result.getString("Password");
        System.out.println("Firstname: " + firstName);
        System.out.println("LastName: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        statement.close();
        connection.close();
        System.out.println("Connection Closed");




    }
}
