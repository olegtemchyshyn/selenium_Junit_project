package ua.foxminded.skarb.utils;

import java.util.Random;

public class DataGenerator {

    static Random random = new Random();

    public static String generateFirstName() {
        String[] firstNames = {"Wayneee", "Igorrr", "Samennn", "Rushabhhh", "Vasylll"};
        int randomIndex = random.nextInt(firstNames.length);
        return firstNames[randomIndex];
    }

    public static String generateLastName() {
        String[] lastNames = {"Downloaper", "Mtcoury", "Ccdhhavi", "Gruaman", "Neinboa"};
        int randomIndex = random.nextInt(lastNames.length);
        return lastNames[randomIndex];
    }

    public static String generateEmail() {
        String[] emails = {"john.doe1@example.com", "sarah.smith1@example.com", "michael.jones1@example.com", "daniel.clark1@example.net", "emily.wilson1@example.net"};
        int randomIndex = random.nextInt(emails.length);
        return emails[randomIndex];
    }

    public static String generatePassword() {
        String[] password = {"TEst@1234", "ABcd!4321", "HJvb&3321", "OPop%7654", "LKgh$5674", "NMzx!2234"};
        int randomIndex = random.nextInt(password.length);
        return password[randomIndex];
    }

    public static String generateOrganizationName() {
        String[] organization = {"CALLI", "HAPPUA", "HSG", "FHGF", "JKJL", "SEDSFDH"};
        int randomIndex = random.nextInt(organization.length);
        return organization[randomIndex];
    }

    public static String domainCorporate() {
        String domain = "@skarb.ngo";
        return domain;

    }
}
