package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

public class CongratsNgoPage {
    private WebDriver driver;

    public CongratsNgoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
