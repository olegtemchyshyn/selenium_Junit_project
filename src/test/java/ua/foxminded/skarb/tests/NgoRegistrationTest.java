package ua.foxminded.skarb.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.testdata.DataGenerator;

public class NgoRegistrationTest extends BaseTest {
    String organization = DataGenerator.companyNameGenerator(4);
    String firstName = DataGenerator.dataGenerator(5);
    String lastName = DataGenerator.dataGenerator(6);
    String password = DataGenerator.generatePassword();
    String position = DataGenerator.generatePosition();
    String email = firstName + "." + lastName + DataGenerator.domainExample();

    @Test
    public void registerNgo() {
        log.info("Starting register a NGO");

        openRegistrationPage("https://skarb.foxminded.ua/registration/organizations");
        fillingInForm();
        verifySuccessMessageDisplayed();
        confirmEmail();
        logInNgo();
    }

    @Step("Opening registration page")
    private void openRegistrationPage(String ngoUrl) {
        driver.get(ngoUrl);
        Assertions.assertEquals(ngoUrl, driver.getCurrentUrl());
        log.info("NGO page was open");
    }

    @Step("Filing in the NGO registration form")
    private void fillingInForm() {
        NgoSignUpPage ngoSignUpPage = new NgoSignUpPage(driver, log);
        ngoSignUpPage.inputEmail(email);
        ngoSignUpPage.inputFirstName(firstName);
        ngoSignUpPage.inputLastName(lastName);
        ngoSignUpPage.clickMaleRondoButon();
        ngoSignUpPage.inputPasswords(password);
        ngoSignUpPage.inputRandomOrganizationName(organization);
        ngoSignUpPage.selectProgrammingCategory();
        ngoSignUpPage.inputPosition(position);
        implicitWait(3);
        ngoSignUpPage.clickSignUpButton();
        log.info("NGO registration form was filled in");
    }

    @Step("Verifying Success message")
    private void verifySuccessMessageDisplayed() {
        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
    }

    @Step("Confirming email")
    private void confirmEmail() {
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
    }

    @Step("Logging in with registered user credentials")
    private void logInNgo() {
        NewConfirmationPage.switchToLogin();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.typeLogin(email);
        loginPage.typePassword(password);
        loginPage.clickEnterButton();
        log.info("Login button was clicked");

        //Verification,dashboard URL verification
        String expectedUrl = "https://skarb.foxminded.ua/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
        log.info("User successfully log in!");
    }
}