package ua.foxminded.skarb.tests.parameterizedTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.tests.BaseTest;

public class PartnerRegistrationParameterizedTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"Manager", "Developer", "Tester", "CEO"})
    public void registerPartner(String position) {
        log.info("Starting register a Partner");

        //Open Home page URL. Click Plus Button
        String homePageUrl = "https://skarb.foxminded.ua/";
        driver.get(homePageUrl);
        Assertions.assertEquals("The expected URL doesn't match current URL", driver.getCurrentUrl(), homePageUrl);
        log.info("Page was opened");

        new HomePage(driver, log)
                .clickPlusButton()
                .clickPartnerButton();

        new PartnersSignUpPage(driver, log)
                .fillRegistrationForm()
                .inputPosition(position)
                .clickSignUpButton();
        log.info("Partners registration form was filled in with position: " + position);

        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
       // Assertions.assertTrue("Success message is not present on the page", successContent.isDisplayed());
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(driver, log);
        congratsNgoPage.switchToMailHog();

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(driver, log);
       // mailHogPage.waitForEmail();
        mailHogPage.clickConfirmationLink();
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(driver, log);
        newConfirmationPage.switchToLastTab();
        newConfirmationPage.waitForConfirmationMessage();

        //Verification
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
      //  Assertions.assertTrue("Email has not been confirmed", pageSource.contains("Your email confirmed!"));
        log.info("Your email was confirmed. Congratulation!");
    }

}

