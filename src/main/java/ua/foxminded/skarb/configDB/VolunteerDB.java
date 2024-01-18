package ua.foxminded.skarb.configDB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class VolunteerDB {

    private static Connection connection;

    public static void initializeDbConnection() throws IOException, ClassNotFoundException, SQLException {

        Properties prop = new Properties();
        InputStream input = VolunteerDB.class.getClassLoader().getResourceAsStream("db.properties");

        // Load the properties file
        prop.load(input);

        // Retrieve the property values
        String dbUrl = prop.getProperty("db.url");
        String dbUser = prop.getProperty("db.user");
        String dbPassword = prop.getProperty("db.password");

        // Driver name and connection setup
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        System.out.println("Connection Established successfully");
    }

    public static void insertData(String firstName, String lastName, String email, String password, String sex, String role, String emailConfirmed, String createdDate, String updatedDate, String locale) throws SQLException {

        String queryCheckInfo = "Select * from users where email = " + "'" + email + "'";
        String queryInsertInto = "INSERT INTO users\n" +
                "  (first_name, last_name, email, password, sex, role, status, email_confirmed, owner, created_date, updated_date, locale)\n" +
                "VALUES\n" +
                "  ('Gretta', 'Dozak', 'gretta.kozak@gmail.com', 'TEst@1234', 'MALE', 'ROLE_VOLUNTEER', 'ACTIVE', 'true', 'true', '2024-01-15 02:46:13', '2024-01-15 02:46:19', 'UA');";

        try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsertInto)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, sex);
            preparedStatement.setString(6, role);
            preparedStatement.setString(7, emailConfirmed);
            preparedStatement.setString(8, createdDate);
            preparedStatement.setString(9, updatedDate);
            preparedStatement.setString(10, locale);

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
}
