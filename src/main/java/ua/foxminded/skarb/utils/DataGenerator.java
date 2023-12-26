package ua.foxminded.skarb.utils;

import org.apache.commons.lang.RandomStringUtils;
import java.time.LocalTime;
import java.util.Random;

public class DataGenerator extends BaseTest{
    static Random random = new Random();

    public String generateFirstName() {
        String[] firstNames = {"Wayneee", "Igorrr", "Samennn", "Rushabhhh", "Vasylll"};
        int randomIndex = random.nextInt(firstNames.length);
        return firstNames[randomIndex];
    }

    public String generateLastName() {
        String[] lastNames = {"Downloaper", "Mtcoury", "Ccdhhavi", "Gruaman", "Neinboa"};
        int randomIndex = random.nextInt(lastNames.length);
        return lastNames[randomIndex];
    }

    public String domainExample() {
        String domainExamp = "@example.com";
        return domainExamp;
    }

    public String generatePassword() {
        String[] password = {"TEst@1234", "ABcd!4321", "HJvb&3321", "OPop%7654", "LKgh$5674", "NMzx!2234"};
        int randomIndex = random.nextInt(password.length);
        return password[randomIndex];
    }

    public String generateOrganizationName() {
        String[] organization = {"CALLI", "HAPPUA", "HSG", "FHGF", "JKJL", "SEDSFDH"};
        int randomIndex = random.nextInt(organization.length);
        return organization[randomIndex];
    }

    public String domainCorporate() {
        String domainCorp = "@skarb.ngo";
        return domainCorp;
    }

    public int uniqueSeconds() {
        LocalTime now = LocalTime.now(); // Get the current local time
        /*// generating integer
        Random ran = new Random();
        int nxt = ran.nextInt();*/
        return now.toSecondOfDay(); //+ nxt
    }

    public String rndTest() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String dataGenerator(int length) {
        String randomData = RandomStringUtils.random(length - 1, "abcdefghijklmnopqrstuwvxyz");
        char firstChar = Character.toUpperCase(randomData.charAt(0));
        return firstChar + randomData.substring(1);
    }

    // Organization name data generator
    public String companyNameGenerator(int lenght) {
        return RandomStringUtils.random(lenght, "ABCDEFGHIGKLMNOPQRSTUVWXYZ");
    }

    // Duplicated organization name data generator
    public String simpleGenerator(int lenght) {
        return RandomStringUtils.random(lenght, "ABCDEFGHIGKLMNOPQRSTUVWXYZ");
    }
}
