package ua.foxminded.skarb.model;

import ua.foxminded.skarb.testdata.DataGenerator;

public class NGO {

    String organization;
    String firstName;
    String lastName;
    String password;
    String position;
    String email;

    public static NGO getRandomNGO() {
        NGO randomNGO = new NGO();
        randomNGO.organization = DataGenerator.companyNameGenerator(4);
        randomNGO.firstName = DataGenerator.dataGenerator(5);
        randomNGO.lastName = DataGenerator.dataGenerator(6);
        randomNGO.password = DataGenerator.generatePassword();
        randomNGO.position = DataGenerator.generatePosition();
        randomNGO.email= randomNGO.firstName + "." + randomNGO.lastName + DataGenerator.domainExample();
        return randomNGO;
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

