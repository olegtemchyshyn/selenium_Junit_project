package ua.foxminded.skarb.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static ua.foxminded.skarb.utils.DataGenerator.*;

public class RegistrationPartnerTest {
    @Test
    public void registerPartner() {
        System.out.println("Starting register a Partner");

        // Create driver WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        //open URL
        String url = "https://skarb.foxminded.ua/registration/partners?";
        driver.get(url);
        System.out.println("Partner page is open");

        //Email
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        String randomEmail = generateEmail();
        email.sendKeys(randomEmail);
        System.out.println("Email is written: " + randomEmail);

        //First name
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        String randomFirstName = generateFirstName();
        firstName.sendKeys(randomFirstName);
        System.out.println("First name is written: " + randomFirstName);

        //Last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        String randomLastName = generateLastName();
        lastName.sendKeys(randomLastName);
        System.out.println("Last name is written: " + randomLastName);

        //Sex radio button
        WebElement sex = driver.findElement(By.xpath("//input[@id='female']"));
        sex.click();
        System.out.println("Sex is chosen");

        //Password & Confirmation
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        String randomPassword = generatePassword();
        password.sendKeys(randomPassword);
        confirmPassword.sendKeys(randomPassword);
        System.out.println("Password & Confirmation are written");

        //Organization full name
        WebElement organizationName = driver.findElement(By.xpath("//input[@id='organizationName']"));
        String randomOrganizationName = generateOrganizationName();
        organizationName.sendKeys(randomOrganizationName);
        System.out.println("Organization name is written: " + randomOrganizationName);

        //Select category
        WebElement category = driver.findElement(By.xpath("//select[@id='categoryIds']"));
        Select select = new Select(category);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        System.out.println("Category is chosen");

        //Type partners' occupation
        WebElement position = driver.findElement(By.xpath("//input[@name='positionInOrganization']"));
        position.sendKeys("manager");
        System.out.println("Position is written");

        sleep(2000);

        // Complete registration. Click Sign Up
        WebElement signUpButton = driver.findElement(By.xpath("//button[@name='submit']"));
        signUpButton.click();

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

