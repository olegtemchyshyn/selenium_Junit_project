package parameterizedTests;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.foxminded.skarb.pages.VolunteersSignUpPage;
import ua.foxminded.skarb.utils.BaseTest;

import java.time.Duration;

public class VolunteerRegistrationParameterizedTest extends BaseTest {
    @ParameterizedTest
    @CsvSource({
            "John, Doe, johndoe@example.com, PaSsword123!",
            "Jane, Smith, janesmith@example.com, PassWord123!",
            "Walter, Happy, walterhappy@example.com, PassWord123!"
    })
    public void registerVolunteer(String firstName, String lastName, String email, String password) {
        log.info("Starting register a Volunteer");

        //open URL
        String url = "https://skarb.foxminded.ua/registration/volunteers";
        driver.get(url);
        //Assertion to check if the current URL is open
        Assert.assertEquals("The expected URL doesn't match current URL", driver.getCurrentUrl(), url);
        log.info("Volunteer page was open");

        //Complete the fields on the registration form.
        VolunteersSignUpPage volunteersSignUpPage = new VolunteersSignUpPage(driver);
        volunteersSignUpPage.inputFirstName(firstName);
        volunteersSignUpPage.inputLastName(lastName);
        volunteersSignUpPage.inputEmail(email);
        volunteersSignUpPage.inputPasswords(password);
        volunteersSignUpPage.selectProgrammingCategory();
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
