package ua.foxminded.skarb.tests.parameterizedTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.CongratsNgoPage;
import ua.foxminded.skarb.pages.MailHogPage;
import ua.foxminded.skarb.pages.NewConfirmationPage;
import ua.foxminded.skarb.pages.NgoSignUpPage;
import ua.foxminded.skarb.tests.BaseTest;

import java.time.Duration;

public class NgoRegistrationParameterizedTest extends BaseTest {

    @RepeatedTest(1)
    public void registerNgo() {
        log.info("Starting register a NGO");

        //open URL
        String ngoUrl = "https://skarb.foxminded.ua/registration/organizations?";
        driver.get(ngoUrl);
        //Assertion to check if the current URL is open
        Assertions.assertEquals("The expected URL doesn't match current URL", driver.getCurrentUrl(), ngoUrl);
        log.info("NGO page was open");

        NgoSignUpPage ngoSignUpPage = new NgoSignUpPage(driver, log );
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
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(driver, log);
        congratsNgoPage.switchToMailHog();

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(driver, log);
       // mailHogPage.waitForEmail(); //TODO
        mailHogPage.clickConfirmationLink();
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(driver, log);
        newConfirmationPage.switchToLastTab();
        newConfirmationPage.waitForConfirmationMessage();

        //Verification
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
        Assertions.assertTrue(pageSource.contains("Your email confirmed!"), "Email has not been confirmed");
        log.info("Your email was confirmed. Congratulation!");

        newConfirmationPage.switchToLogin();

//        LoginPage loginPage = new LoginPage(driver, log);
//        loginPage.typeLogin();
//        loginPage.typePassword();
//        loginPage.clickEnterButton();

        //Verification,dashboard URL verification
        String expectedUrl = "https://skarb.foxminded.ua/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals("Actual page URL is not the same as expected", expectedUrl, actualUrl);
        log.info("User successfully log in!");
    }

}
