package ua.foxminded.skarb.utils;
import org.apache.commons.lang.RandomStringUtils;
import java.time.LocalTime;
import java.util.Random;

public class DataGenerator {

    private String organizationName;
    private static String firstName;
    private static String lastName;
    private String email = firstName + "." + lastName;

   /* // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getOrganizationName() { return organizationName; }
    public String getEmail() { return email; }

    public static DataGenerator testData() {
        return Instancio.of(DataGenerator.class)
                .generate(field(DataGenerator::getFirstName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(DataGenerator::getLastName), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(DataGenerator::getOrganizationName), gen -> gen.text().pattern("#C#c#c#c#c#c#c#c#c"))
                .generate(field(DataGenerator::getEmail), gen -> gen.text().pattern("#c#c#c#c#c#c@skarb.ngo"))
                .create();
    }*/

    static Random random = new Random();
    public static String generateFirstName() {
        String[] firstNames = {"Wayneee", "Igorrr", "Samennn", "Rushabhhh", "Vasylll"};
        int randomIndex = random.nextInt(firstNames.length);
        return firstNames[randomIndex];
    }

    public static String generatePosition() {
        String[] position = {"Developer", "Engineer", "Product Manager", "Analyst", "Systems Administrator"};
        int randomIndex = random.nextInt(position.length);
        return position[randomIndex];
    }

    public static String generateLastName() {
        String[] lastNames = {"Downloaper", "Mtcoury", "Ccdhhavi", "Gruaman", "Neinboa"};
        int randomIndex = random.nextInt(lastNames.length);
        return lastNames[randomIndex];
    }

    public static String domainExample() {
        String domainExamp = "@example.com";
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

    public static int uniqueSeconds() {
        LocalTime now = LocalTime.now(); // Get the current local time
        return now.toSecondOfDay(); //+ nxt
    }

    public static String rndTest() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String dataGenerator(int length) {
        String randomData = RandomStringUtils.random(length - 1, "abcdefghijklmnopqrstuwvxyz");
        char firstChar = Character.toUpperCase(randomData.charAt(0));
        return firstChar + randomData.substring(1);
    }

    // Organization name data generator
    public static String companyNameGenerator(int lenght) {
        return RandomStringUtils.random(lenght, "ABCDEFGHIGKLMNOPQRSTUVWXYZ");
    }

    // Duplicated organization name data generator
    public static String simpleGenerator(int lenght) {
        return RandomStringUtils.random(lenght, "ABCDEFGHIGKLMNOPQRSTUVWXYZ");
    }
}
