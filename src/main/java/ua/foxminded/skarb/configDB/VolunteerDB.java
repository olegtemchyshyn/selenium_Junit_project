package ua.foxminded.skarb.configDB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class VolunteerDB {

    private static Statement statement;
    private static Connection connection = null;

    // Synchronize the method to prevent race conditions in a multi-threaded environment
    public static synchronized Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            // Load your database properties
            Properties prop = new Properties();
            InputStream input = VolunteerDB.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(input);

            String dbUrl = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPassword = prop.getProperty("db.password");

            // Establish the database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }
        return connection;
    }

    public static void insertData(String firstName, String lastName, String email, String password, String sex, String role, String emailConfirmed, String createdDate, String updatedDate, String locale) throws SQLException, IOException, ClassNotFoundException {
        String queryInsertInto = "INSERT INTO users " +
                "(first_name, last_name, email, password, sex, role, status, email_confirmed, owner, created_date, updated_date, locale) " +
                "VALUES (?, ?, ?, ?, ?, ?, 'ACTIVE', ?, 'true', ?, ?, ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(queryInsertInto)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, sex);
            preparedStatement.setString(6, role);
            preparedStatement.setBoolean(7, Boolean.parseBoolean(emailConfirmed));
            preparedStatement.setString(8, createdDate);
            preparedStatement.setString(9, updatedDate);
            preparedStatement.setString(10, locale);
            // Active and true are hardcoded

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Volunteer inserted into DB successfully");
            }
        }
    }

    // Confirmation email Update in db as 'true'
    public static void confirmRegistration(String email) throws SQLException, IOException, ClassNotFoundException {
        String updateConfirmation = "UPDATE users SET email_confirmed = ? WHERE email = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(updateConfirmation)) {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, email);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Email confirmation updated successfully for " + email);
            } else {
                System.out.println("No record was updated for " + email);
            }
        }
    }

    public static void finishConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connection Closed");
        }
    }
}

