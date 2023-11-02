package ua.foxminded.skarb.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
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
        String url = "https://skarb.foxminded.ua";
        driver.get(url);
        System.out.println("Home page is open");

        //click registration button on the page
        WebElement registrationIcon = driver.findElement(By.xpath("//i[@class='fa fa-user-plus fa-3x text-dark-red']"));
        registrationIcon.click();

        //click register as "Partner"
        WebElement partnerButton = driver.findElement(By.xpath("//button[contains(text(),'Partner')]"));
        partnerButton.click();
        System.out.println("Register as 'Partner' is chosen");

        //generate random first name and last name
        String randomFirstName = generateFirstName();
        String randomLastName = generateLastName();

        //Email
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        String domain = domainCorporate();
        String randomEmail = randomFirstName + "." + randomLastName + domain;
        email.sendKeys(randomEmail);
        System.out.println("Email is written: " + randomEmail);

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //First name
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(randomFirstName);
        System.out.println("First name is written: " + randomFirstName);

        //Last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
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

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Complete registration. Click Sign Up
        WebElement signUpButton = driver.findElement(By.xpath("//button[@name='submit']"));
        signUpButton.click();
        System.out.println("Sign Up button is clicked.");

        sleep(6000);

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Open new tab
        String initHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://skarbmail.foxminded.ua/");
        System.out.println("Mail tab is open");

        //Refresh the page
        driver.navigate().refresh();

        //Refresh the page
        driver.navigate().refresh();

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sleep(10000);

        //Click on recently recived email   //randomEmail
        WebElement emailMessage = driver.findElement(By.xpath("//div[@class='msglist-message row ng-scope']//div[contains(text(),'a few seconds ago')]"));
        //driver.findElement(By.linkText(randomEmail));
        emailMessage.click();
        System.out.println("Email is found");

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Looking for confirmation link
        WebElement confirmationLink = driver.findElement(By.xpath("//div[@class='tab-pane ng-binding active']//a[@target='_blank']"));
        confirmationLink.click();

        //Implicit waite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //sweech to main window
        driver.switchTo().window(initHandle);

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

