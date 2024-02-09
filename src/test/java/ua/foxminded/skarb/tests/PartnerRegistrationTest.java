package ua.foxminded.skarb.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.model.Partner;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.testdata.DataGenerator;

public class PartnerRegistrationTest extends BaseTest {

    Partner randomPartner =  Partner.getRandomPartner();

    @Test
    public void registerPartner() {
        log.info("Starting register a Partner");

        //Open Home page URL. Click Plus Button
        String homePageUrl = "https://skarb.foxminded.ua/";
        driver.get(homePageUrl);
        Assertions.assertEquals(driver.getCurrentUrl(), homePageUrl, "The expected URL doesn't match current URL");
        log.info("Page was opened");

       String email = randomPartner.getEmail();
       String firstName = randomPartner.getFirstName();
       String lastName = randomPartner.getLastName();
       String password = randomPartner.getPassword();
       String organization = randomPartner.getOrganization();

        new HomePage(driver, log)
                .clickPlusButton()
                .clickPartnerButton();

        new PartnersSignUpPage(driver, log)
                .fillRegistrationForm(email, firstName, lastName, password, organization)
                .inputPosition("Manager")
                .clickSignUpButton();
        log.info("Partners registration form was filled in");

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
    }

}

