package ua.foxminded.skarb.configDB;

import java.sql.*;

public class VolunteerDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String queryCheckInfo = "Select * from users where email = 'betta.kozak@gmail.com'";
        String queryInsertInto = "INSERT INTO users\n" +
                "  (first_name, last_name, email, password, sex, role, status, email_confirmed, owner, created_date, updated_date, locale)\n" +
                "VALUES\n" +
                "  ('Betta', 'Kozak', 'betta.kozak@gmail.com', 'TEst@1234', 'MALE', 'ROLE_VOLUNTEER', 'ACTIVE', 'true', 'true', '2024-01-15 02:46:13', '2024-01-15 02:46:19', 'UA');";
        // Driver name and connection setup
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://185.149.40.46:1433;database=SkarbNgoDB;encrypt=false", "sa", "37Y5Nb8uTo2");
        System.out.println("Connection Established successfully");

        Statement statement = connection.createStatement();

        // Insert data
        int rowsInserted = statement.executeUpdate(queryInsertInto);
        if (rowsInserted > 0) {
            System.out.println("Volunteer inserted into DB successfully");
        }

        // Confirm insertion
        ResultSet resultSet = statement.executeQuery(queryCheckInfo);
        if (resultSet.next()) {
            System.out.println("Confirmed: Data found in DB for email betta.kozak@gmail.com");
        } else {
            System.out.println("No data found for email betta.kozak@gmail.com");
        }

        statement.close();
        connection.close();
        System.out.println("Connection Closed");
    }
}
