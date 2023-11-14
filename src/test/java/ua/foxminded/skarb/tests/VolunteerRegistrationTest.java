package ua.foxminded.skarb.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.VolunteersSignUpPage;
import ua.foxminded.skarb.utils.BasePage;

import java.time.Duration;

public class VolunteerRegistrationTest extends BasePage {
    @Test
    public void registerVolunteer() {
        System.out.println("Starting register a Volunteer");

        //open URL
        String url = "https://skarb.foxminded.ua/registration/volunteers";
        driver.get(url);
        //Assertion to check if the current URL is open
        Assert.assertEquals(driver.getCurrentUrl(), url, "The expected URL doesn't match current URL");
        System.out.println("Volunteer page is open");

        //Complete the fields on the registration form.
        VolunteersSignUpPage volunteersSignUpPage = new VolunteersSignUpPage(driver);
        volunteersSignUpPage.enterFirstName();
        volunteersSignUpPage.enterLastName();
        volunteersSignUpPage.enterEmail();
        volunteersSignUpPage.enterPasswords();
        volunteersSignUpPage.selectCategory();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        volunteersSignUpPage.clickSignUpButton();

        //Verification, new URL verification
        String expectedUrl = "https://skarb.foxminded.ua/registration/result/success";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Actual page URL is not the same as expected", expectedUrl, actualUrl);

        // Check success message
        WebElement successContent = driver.findElement(By.id("content"));
        Assert.assertTrue("Success message is not present on the page", successContent.isDisplayed());

    }

}
