package ua.foxminded.skarb.tests.parameterizedTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.VolunteersSignUpPage;
import ua.foxminded.skarb.tests.BaseTest;

public class VolunteerRegistrationParameterizedTest extends BaseTest {
    @ParameterizedTest
    @CsvSource({
            "John, Wow, johnwow23e@example.com, PaSsword123!",
            "Jane, What, janeswhat87@example.com, PassWord123!",
            "Walter, Bella, walterbella95y@example.com, PassWord123!"
    })

    public void registerVolunteer(String firstName, String lastName, String email, String password) {
        log.info("Starting register a Volunteer");

        //open URL
        String url = "https://skarb.foxminded.ua/registration/volunteers";
        driver.get(url);
        //Assertion to check if the current URL is open
        Assertions.assertEquals(driver.getCurrentUrl(), url, "The expected URL doesn't match current URL");
        log.info("Volunteer page was open");

        //Complete the fields on the registration form.
        VolunteersSignUpPage volunteersSignUpPage = new VolunteersSignUpPage(driver, log);
        volunteersSignUpPage.inputFirstName(firstName);
        volunteersSignUpPage.inputLastName(lastName);
        volunteersSignUpPage.inputEmail(email);
        volunteersSignUpPage.inputPasswords(password);
        volunteersSignUpPage.selectProgrammingCategory();
        implicitWait(3);
        volunteersSignUpPage.clickSignUpButton();

        //Verification, new URL verification
        String expectedUrl = "https://skarb.foxminded.ua/registration/result/success";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Actual page URL is not the same as expected");

        // Check success message
        WebElement successContent = driver.findElement(By.id("content"));
        Assertions.assertTrue(successContent.isDisplayed(), "Success message is not present on the page");
    }

}
