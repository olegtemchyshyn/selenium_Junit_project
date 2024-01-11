package ua.foxminded.skarb.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.VolunteersSignUpPage;
import ua.foxminded.skarb.testdata.DataGenerator;
import ua.foxminded.skarb.builder.Volunteer;

public class VolunteerRegistrationTest extends BaseTest {

    @Test
    public void registerVolunteer() {
        log.info("Starting register a Volunteer");

        //open URL
        String url = "https://skarb.foxminded.ua/registration/volunteers";
        driver.get(url);
        //Assertion to check if the current URL is open
        Assertions.assertEquals(driver.getCurrentUrl(), url, "The expected URL doesn't match current URL");
        log.info("Volunteer page was open");

        String firstName = DataGenerator.dataGenerator(5);
        String lastName = DataGenerator.dataGenerator(6);
        String password = DataGenerator.generatePassword();
        String email = firstName + "." + lastName + DataGenerator.domainExample();

        // Use the Volunteer.Builder to create a Volunteer instance
        Volunteer volunteer = new Volunteer.Builder()
                .withEmail(email)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPassword(password)
                .build();

        // Use the volunteer's data to fill in the sign-up page
        VolunteersSignUpPage signUpPage = new VolunteersSignUpPage(driver, log);
        signUpPage.inputEmail(volunteer.getEmail());
        signUpPage.inputFirstName(volunteer.getFirstName());
        signUpPage.inputLastName(volunteer.getLastName());
        signUpPage.inputPasswords(volunteer.getPassword());
        signUpPage.selectProgrammingCategory();
        signUpPage.clickSignUpButton();

        //Verification, new URL verification
        String expectedUrl = "https://skarb.foxminded.ua/registration/result/success";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Actual page URL is not the same as expected");

        // Check success message
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
    }

}
