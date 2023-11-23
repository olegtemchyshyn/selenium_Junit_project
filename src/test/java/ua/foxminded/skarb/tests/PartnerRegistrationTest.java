package ua.foxminded.skarb.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.utils.BaseTest;

public class PartnerRegistrationTest extends BaseTest {
    @Test
    public void registerPartner() {
        log.info("Starting register a Partner");

        //Open Home page URL. Click Plus Button
        String homePageUrl = "https://skarb.foxminded.ua/";
        driver.get(homePageUrl);
        Assert.assertEquals("The expected URL doesn't match current URL", driver.getCurrentUrl(), homePageUrl);
        log.info("Page opened");

        new HomePage(driver)
                .clickPlusButton()
                .clickPartnerButton();

        new PartnersSignUpPage(driver)
                .fillRegistrationForm()
                .clickSignUpButton();

        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
        Assert.assertTrue("Success message is not present on the page", successContent.isDisplayed());
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(driver);
        congratsNgoPage.switchToMailHog();

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(driver);
        mailHogPage.recentEmailMessage();
        mailHogPage.clickConfirmationLink();
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(driver);
        newConfirmationPage.switchToLastTab();
        newConfirmationPage.waitForConfirmationMessage();

        //Verification
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
        Assert.assertTrue("Email has not been confirmed", pageSource.contains("Your email confirmed!"));
        log.info("Your email is confirmed. Congratulation!");
    }

}

