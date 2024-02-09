package ua.foxminded.skarb.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.model.Volunteer;
import ua.foxminded.skarb.pages.VolunteersSignUpPage;
import ua.foxminded.skarb.builder.VolunteerBuilder;

import java.net.MalformedURLException;

public class VolunteerRegistrationTest extends BaseTest {

    Volunteer randomVolunteer = Volunteer.getRandomVolunteer();

    @Test
    public void registerVolunteer() throws MalformedURLException {
        log.info("Starting register a Volunteer");

        //open URL
        String url = "https://skarb.foxminded.ua/registration/volunteers";
        driver.get(url);
        //Assertion to check if the current URL is open
        Assertions.assertEquals(driver.getCurrentUrl(), url, "The expected URL doesn't match current URL");
        log.info("Volunteer page was open");

        String firstName = randomVolunteer.getFirstName();
        String lastName = randomVolunteer.getLastName();
        String password = randomVolunteer.getPassword();
        String email = randomVolunteer.getEmail();

        // Use the Volunteer.Builder to create a Volunteer instance
        VolunteerBuilder volunteerBuilder = new VolunteerBuilder.Builder()
                .withEmail(email)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPassword(password)
                .build();
        log.info("Registration form completed");

        // Use the volunteer's data to fill in the sign-up page
        VolunteersSignUpPage signUpPage = new VolunteersSignUpPage(driver, log);
        signUpPage.inputEmail(volunteerBuilder.getEmail());
        signUpPage.inputFirstName(volunteerBuilder.getFirstName());
        signUpPage.inputLastName(volunteerBuilder.getLastName());
        signUpPage.inputPasswords(volunteerBuilder.getPassword());
        signUpPage.selectProgrammingCategory();
        signUpPage.clickSignUpButton();
        log.info("Registration form completed");

        //Verification, new URL verification
        String expectedUrl = "https://skarb.foxminded.ua/registration/result/success";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Actual page URL is not the same as expected");

        // Check success message
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
        log.info("Assertions successfully validated");
    }

}
