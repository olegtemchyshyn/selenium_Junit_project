package ua.foxminded.skarb.utils;

import java.util.Random;

public class VolunteerDataGenerator {

    static Random random = new Random();
    public static String generateFirstName() {
        String[] firstNames = {"Oleh", "Pavel", "Emily", "John", "Boho" };
        int randomIndex = random.nextInt(firstNames.length);
        return firstNames[randomIndex];
    }

    public static String generateLastName() {
        String[] lastNames = {"Jones", "Miller", "Garcia", "Williams", "Campbell"};
        int randomIndex = random.nextInt(lastNames.length);
        return lastNames[randomIndex];
    }

    public static String generateEmail() {
        String[] emails = {"john.doe@example.com", "sarah.smith@emailprovider.net", "michael.jones@email.org", "daniel.clark@example.net", "emily.wilson@example.net"};
        int randomIndex = random.nextInt(emails.length);
        return emails[randomIndex];
    }
}
