package ua.foxminded.skarb.tests.DbTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.configDB.VolunteerDB;
import ua.foxminded.skarb.pages.LoginPage;
import ua.foxminded.skarb.pages.NewConfirmationPage;
import ua.foxminded.skarb.pages.VolunteersSignUpPage;
import ua.foxminded.skarb.testdata.DataGenerator;
import ua.foxminded.skarb.tests.BaseTest;

import java.io.IOException;
import java.sql.SQLException;

public class VolunteerDbRegistration extends BaseTest {

    @Test
    public void Volunteer() throws SQLException, IOException, ClassNotFoundException {
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

        //Complete the fields on the registration form.
        VolunteersSignUpPage volunteersSignUpPage = new VolunteersSignUpPage(driver, log);
        volunteersSignUpPage.inputFirstName(firstName);
        volunteersSignUpPage.inputLastName(lastName);
        volunteersSignUpPage.inputEmail(email);
        volunteersSignUpPage.inputPasswords(password);
        volunteersSignUpPage.selectProgrammingCategory();
        implicitWait(3);
        volunteersSignUpPage.clickSignUpButton();

        implicitWait(3);

        //Verification, new URL verification
        String expectedUrl = "https://skarb.foxminded.ua/registration/result/success";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Actual page URL is not the same as expected");

        // Check success message
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");

        try {
            VolunteerDB.getConnection(); // Establish the connection if not already established.
            VolunteerDB.confirmRegistration(email); // Confirm the registration.
        } finally {
            VolunteerDB.finishConnection(); // Ensure the connection is closed.
        }
        log.info("Email has been confirmed in the database and verified.");

        // Now navigate to the login page
        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.switchToLogin();
        loginPage.typeLogin(email);
        loginPage.typePassword(password);
        loginPage.clickEnterButton();
        log.info("Volunteer clicked the login button");

        //Verification,dashboard URL verification
        String secondExpectedUrl = "https://skarb.foxminded.ua/";
        String secondActualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(secondExpectedUrl, secondActualUrl, "Volunteer failed log in!");
        log.info("User successfully log in!");
    }
}
