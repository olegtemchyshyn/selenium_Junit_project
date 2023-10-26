package ua.foxminded.skarb.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static ua.foxminded.skarb.utils.VolunteerDataGenerator.*;

public class RegistrationVolunteerTest {

    @Test
    public void registerVolunteer() {
        System.out.println("Starting register a Volunteer");

        // Create driver WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        //open URL
        String url = "https://skarb.foxminded.ua/registration/volunteers";
        driver.get(url);
        System.out.println("Page is open");

        //First name
        WebElement firstName = driver.findElement(By.id("firstName"));
        String randomFirstName = generateFirstName();
        firstName.sendKeys("randomFirstName");
        System.out.println("First name is written: " + randomFirstName);

        //Last name
        WebElement lastName = driver.findElement(By.id("lastName"));
        String randomLastName = generateLastName();
        lastName.sendKeys("randomLastName");
        System.out.println("Last name is written: " + randomLastName);

        //Email
        WebElement email = driver.findElement(By.id("email"));
        String randomEmail = generateEmail();
        email.sendKeys("randomEmail");
        System.out.println("Email is written: " + randomEmail);

        //Password & Confirmation
        WebElement password = driver.findElement(By.id("password"));
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        password.sendKeys("TEst@1234");
        confirmPassword.sendKeys("TEst@1234");
        System.out.println("Password & Confirmation are written");

        //Select category
        WebElement category = driver.findElement(By.id("categories"));
        Select select = new Select(category);
        select.selectByIndex(4);
        select.selectByVisibleText("Programming");
        System.out.println("Category is chosen");

        //Sleep
        sleep(2000);

        // Complete registration. Click Sign Up
        WebElement signUpButton = driver.findElement(By.name("submit"));
        signUpButton.click();

        //Sleep
        sleep(2000);

        // Check success message
        WebElement successContent = driver.findElement(By.id("content"));
        if (successContent.getText().contains("Congratulation!")) {
            System.out.println("Registration was successful!");
        } else {
            System.out.println("Registration failed!");
        }

        //Close browser
        driver.quit();

    }

    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
