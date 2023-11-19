package ua.foxminded.skarb.utils;

import org.apache.commons.lang.RandomStringUtils;

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

    public static String domainExample() {
        String domainExamp = "@example.com" ;
        return domainExamp;
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
        String domainCorp = "@skarb.ngo";
        return domainCorp;
    }

    public static String dataGenerator(int length) {
        String randomData = RandomStringUtils.random(length -1, "abcdefghijklmnopqrstuwvxyz");
        char firstChar = Character.toUpperCase(randomData.charAt(0));
        return firstChar + randomData.substring(1);
    }

    public static String companyNameGenerator(int lenght) {
        return RandomStringUtils.random(lenght,"ABCDEFGHIGKLMNOPQRSTUVWXYZ");

    }

}
