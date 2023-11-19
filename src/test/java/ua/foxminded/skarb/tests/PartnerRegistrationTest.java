package ua.foxminded.skarb.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.utils.BaseTest;

import java.time.Duration;

public class PartnerRegistrationTest extends BaseTest {
    @Test
    public void registerPartner() {
        System.out.println("Starting register a Partner");

        //Open Home page URL. Click Plus Button
        String homePageUrl = "https://skarb.foxminded.ua/";
        driver.get(homePageUrl);
        //Assertion to check if the current URL is open
        Assert.assertEquals("The expected URL doesn't match current URL", driver.getCurrentUrl(), homePageUrl);
        System.out.println("Page opened");
        HomePage homePage = new HomePage(driver);
        homePage.clickPlusButton();

        //click register as "Partner"(instance of RegistrationPage )
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickPartnerButton();

        //Complete the fields on the registration form.
        PartnersSignUpPage partnersSignUpPage = new PartnersSignUpPage(driver);
        partnersSignUpPage.inputRandomEmail();
        partnersSignUpPage.inputRandomFirstName();
        partnersSignUpPage.inputRandomLastName();
        partnersSignUpPage.clickFemaleRondoButon();
        partnersSignUpPage.inputRandomPasswords();
        partnersSignUpPage.inputRandomOrganizationName();
        partnersSignUpPage.selectProgrammingCategory();
        partnersSignUpPage.enterPossition();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        partnersSignUpPage.clickSignUpButton();

        // Verification
        WebElement successContent = driver.findElement(By.id("content"));
        Assert.assertTrue("Success message is not present on the page", successContent.isDisplayed());
        CongratsNgoPage congratsNgoPage = new CongratsNgoPage(driver);
        congratsNgoPage.switchToMailHog();

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Clicking on confirmation link. Congratulation message!
        MailHogPage mailHogPage = new MailHogPage(driver);
        mailHogPage.recentEmailMessage();
        mailHogPage.clickConfirmationLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        NewConfirmationPage newConfirmationPage = new NewConfirmationPage(driver);
        newConfirmationPage.switchToLastTab();
        String pageSource = newConfirmationPage.getConfirmationMessage().getText();
        Assert.assertTrue("Email has not been confirmed", pageSource.contains("Your email confirmed!"));
        System.out.println("Your email is confirmed. Congratulation!");
    }

}

