package ua.foxminded.skarb.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.utils.BaseTest;

import java.time.Duration;

public class NgoRegistrationTest extends BaseTest {

    @Test
    public void registerNgo() {
        log.info("Starting register a NGO");

        //open URL
        String ngoUrl = "https://skarb.foxminded.ua/registration/organizations?";
        driver.get(ngoUrl);
        //Assertion to check if the current URL is open
        Assert.assertEquals("The expected URL doesn't match current URL", driver.getCurrentUrl(), ngoUrl);
        log.info("NGO page was open");

        NgoSignUpPage ngoSignUpPage = new NgoSignUpPage(driver, log);
        ngoSignUpPage.inputRandomEmailmail();
        ngoSignUpPage.inputRandomFirstName();
        ngoSignUpPage.inputRandomLastName();
        ngoSignUpPage.clickMaleRondoButon();
        ngoSignUpPage.inputRandomPasswords();
        ngoSignUpPage.inputRandomOrganizationName();
        ngoSignUpPage.selectProgrammingCategory();
        ngoSignUpPage.inputPosition("Manager");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        ngoSignUpPage.clickSignUpButton();
        log.info("NGO registration form was filled in");

        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
        Assert.assertTrue("Success message is not present on the page", successContent.isDisplayed());
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(driver, log);
        congratsNgoPage.switchToMailHog();

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(driver, log);
        mailHogPage.recentEmailMessage();
        mailHogPage.clickConfirmationLink();
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(driver, log);
        newConfirmationPage.switchToLastTab();
        newConfirmationPage.waitForConfirmationMessage();

        //Verification
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
        Assert.assertTrue("Email has not been confirmed", pageSource.contains("Your email confirmed!"));
        log.info("Your email was confirmed. Congratulation!");

        newConfirmationPage.switchToLogin();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.typeLogin();
        loginPage.typePassword();
        loginPage.clickEnterButton();

        //Verification,dashboard URL verification
        String expectedUrl = "https://skarb.foxminded.ua/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Actual page URL is not the same as expected", expectedUrl, actualUrl);
        log.info("User successfully log in!");
    }

}
