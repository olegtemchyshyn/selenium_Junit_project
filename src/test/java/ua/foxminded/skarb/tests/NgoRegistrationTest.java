package ua.foxminded.skarb.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.utils.DataGenerator;

import java.time.Duration;

public class NgoRegistrationTest extends BaseTest {

    @Test
    public void registerNgo() {
        log.info("Starting register a NGO");

        //open URL
        String ngoUrl = "https://skarb.foxminded.ua/registration/organizations";
        driver.get(ngoUrl);
        //Assertion to check if the current URL is open
        Assertions.assertEquals(ngoUrl, driver.getCurrentUrl());
        log.info("NGO page was open");

        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        String email = firstName + "." + lastName + "@skarb.ngo";
        String password = DataGenerator.generatePassword();

        NgoSignUpPage ngoSignUpPage = new NgoSignUpPage(driver, log);
        ngoSignUpPage.inputEmail(email);
        ngoSignUpPage.inputFirstName(firstName);
        ngoSignUpPage.inputLastName(lastName);
        ngoSignUpPage.clickMaleRondoButon();
        ngoSignUpPage.inputPasswords(password);
        ngoSignUpPage.inputRandomOrganizationName();
        ngoSignUpPage.selectProgrammingCategory();
        ngoSignUpPage.inputPosition("Manager");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        ngoSignUpPage.clickSignUpButton();
        log.info("NGO registration form was filled in");

        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(driver, log);
        congratsNgoPage.switchToMailHog();

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(driver, log);
        mailHogPage.waitForEmail(email);
        mailHogPage.clickConfirmationLink();
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(driver, log);
        newConfirmationPage.switchToLastTab();
        newConfirmationPage.waitForConfirmationMessage();

        //Verification
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
        Assertions.assertTrue(pageSource.contains("Your email confirmed!"), "Email has not been confirmed");
        log.info("Your email was confirmed. Congratulation!");

        newConfirmationPage.switchToLogin();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.typeLogin(email);
        loginPage.typePassword(password);
        loginPage.clickEnterButton();

        //Verification,dashboard URL verification
        String expectedUrl = "https://skarb.foxminded.ua/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
        log.info("User successfully log in!");
    }
}