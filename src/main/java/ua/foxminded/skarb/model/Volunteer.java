package ua.foxminded.skarb.model;

import ua.foxminded.skarb.testdata.DataGenerator;

public class Volunteer {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public static Volunteer getRandomVolunteer() {
        Volunteer getRandomVolunteer = new Volunteer();
        getRandomVolunteer.firstName = DataGenerator.dataGenerator(4);
        getRandomVolunteer.lastName = DataGenerator.dataGenerator(6);
        getRandomVolunteer.password = DataGenerator.generatePassword();
        getRandomVolunteer.email= getRandomVolunteer.firstName + "." + getRandomVolunteer.lastName + DataGenerator.domainCorporate();
        return getRandomVolunteer;
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
}
