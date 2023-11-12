package ua.foxminded.skarb.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class CongratsNgoPage {
    private WebDriver driver;

    public CongratsNgoPage(WebDriver driver) {
        this.driver = driver;
    }

    //Open new tab
    public MailHogPage switchToMailHog() {
        String initHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://skarbmail.foxminded.ua/");
        System.out.println("Mail tab is open");
        return new MailHogPage(driver);

    }

}
