package ua.foxminded.skarb.model;

import ua.foxminded.skarb.testdata.DataGenerator;

public class Partner {

    private String organization;
    private String firstName;
    private String lastName;
    private String password;
    private String position;
    private String email;

    public static Partner getRandomPartner() {
        Partner getRandomPartner = new Partner();
        getRandomPartner.organization = DataGenerator.companyNameGenerator(3);
        getRandomPartner.firstName = DataGenerator.dataGenerator(4);
        getRandomPartner.lastName = DataGenerator.dataGenerator(6);
        getRandomPartner.password = DataGenerator.generatePassword();
        getRandomPartner.position = DataGenerator.generatePosition();
        getRandomPartner.email= getRandomPartner.firstName + "." + getRandomPartner.lastName + DataGenerator.domainCorporate();
        return getRandomPartner;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPosition() {
        return position;
    }
}
