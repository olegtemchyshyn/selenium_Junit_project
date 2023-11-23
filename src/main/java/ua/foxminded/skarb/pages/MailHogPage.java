package ua.foxminded.skarb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.foxminded.skarb.utils.BaseTest;
import java.util.logging.Logger;

public class MailHogPage extends BaseTest {
    private WebDriver driver;
    private Logger log;

    @FindBy(xpath = "//div[@id='content']//h3[@class='display-3 text-center']")
    private WebElement emailConfirmationContentElement;
    @FindBy(xpath = "//div[@class='msglist-message row ng-scope']//div[contains(text(),'a few seconds ago')]")
    private WebElement recentEmailMessageElement;
    @FindBy(xpath = "//div[@class='tab-pane ng-binding active']//a[@target='_blank']")
    private WebElement confirmationLinkElement;

    public MailHogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Find recently received email
    public void recentEmailMessage() {
        WebElement recentEmailMessageElement = null;
        while (recentEmailMessageElement == null) {
            try {
                recentEmailMessageElement = driver.findElement(By.xpath("//div[@class='msglist-message row ng-scope']//div[contains(text(),'a few seconds ago')]"));
            } catch (org.openqa.selenium.NoSuchElementException e) {
                driver.navigate().refresh();
            }
        }
        // Email message is visible, click on it
        recentEmailMessageElement.click();
        log.info("Driver found registration confirmation email");
    }

    public void clickConfirmationLink() {
        confirmationLinkElement.click();
        log.info("Confirmation link clicked");
    }
}

