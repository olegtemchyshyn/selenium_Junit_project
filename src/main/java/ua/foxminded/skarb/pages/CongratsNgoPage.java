package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CongratsNgoPage {
    private WebDriver driver;

   /* @FindBy(xpath = "//div[@id='content']//h3[@class='display-3 text-center']")
    private WebElement emailConfirmationContentElement;*/

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

    /*public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(emailConfirmationContentElement));
        return emailConfirmationContentElement.getText();*/


}
