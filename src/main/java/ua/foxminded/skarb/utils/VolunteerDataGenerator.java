package ua.foxminded.skarb.utils;

import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;
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

    public static String generatePassword() {
        String[] password = {"TEst@1234", "ABcd!4321", "HJvb&3321", "OPop%7654", "LKgh$5674", "NMzx!2234"};
        int randomIndex = random.nextInt(password.length);
        return password[randomIndex];
    }
}
