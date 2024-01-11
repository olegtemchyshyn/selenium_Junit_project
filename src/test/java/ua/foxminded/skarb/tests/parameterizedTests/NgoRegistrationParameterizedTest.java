package ua.foxminded.skarb.tests.parameterizedTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.tests.BaseTest;
import ua.foxminded.skarb.testdata.DataGenerator;

public class NgoRegistrationParameterizedTest extends BaseTest {

    @RepeatedTest(2)
    public void registerNgo() {
        log.info("Starting register a NGO");

        //open URL
        String ngoUrl = "https://skarb.foxminded.ua/registration/organizations?";
        driver.get(ngoUrl);
        //Assertion to check if the current URL is open
        Assertions.assertEquals(driver.getCurrentUrl(), ngoUrl, "The expected URL doesn't match current URL");
        log.info("NGO page was open");

        String organization = DataGenerator.companyNameGenerator(4);
        String firstName = DataGenerator.dataGenerator(5);
        String lastName = DataGenerator.dataGenerator(6);
        String password = DataGenerator.generatePassword();
        String position = DataGenerator.generatePosition();
        String email = firstName + "." + lastName + DataGenerator.domainCorporate();

        NgoSignUpPage ngoSignUpPage = new NgoSignUpPage(driver, log);
        ngoSignUpPage.inputEmail(email);
        ngoSignUpPage.inputFirstName(firstName);
        ngoSignUpPage.inputLastName(lastName);
        ngoSignUpPage.clickMaleRondoButon();
        sleep(2000);
        ngoSignUpPage.inputPasswords(password);
        ngoSignUpPage.inputRandomOrganizationName(organization);
        ngoSignUpPage.selectProgrammingCategory();
        ngoSignUpPage.inputPosition(position);
        implicitWait(4);
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
        Assertions.assertEquals(expectedUrl, actualUrl, "Actual page URL is not the same as expected");
        log.info("User successfully log in!");
    }

}
