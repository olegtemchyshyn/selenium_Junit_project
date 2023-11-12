package ua.foxminded.skarb.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.*;
import ua.foxminded.skarb.utils.BasePage;

import java.time.Duration;
public class PartnerRegistrationPage extends BasePage {
    @Test
    public void registerPartner() {
        System.out.println("Starting register a Partner");

        //Open Home page URL. Click Plus Button
        String homePageUrl = "https://skarb.foxminded.ua";
        driver.get(homePageUrl);
        System.out.println("Page opened");
        HomePage homePage = new HomePage(driver);
        homePage.clickPlusButton();

        //click register as "Partner"(instance of RegistrationPage )
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickPartnerButton();

        //Complete the fields on the registration form.
        PartnersSignUpPage partnersSignUpPage = new PartnersSignUpPage(driver);
        partnersSignUpPage.enterEmail();
        partnersSignUpPage.enterFirstName();
        partnersSignUpPage.enterLastName();
        partnersSignUpPage.clickFemaleRondoButon();
        partnersSignUpPage.enterPasswords();
        partnersSignUpPage.enterOrganizationName();
        partnersSignUpPage.selectCategory();
        partnersSignUpPage.enterPossition();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        partnersSignUpPage.clickSignUpButton();

        // Verification
        // Check success message
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
        System.out.println("Your email is confirmed. Congratulation!");
    }
}

