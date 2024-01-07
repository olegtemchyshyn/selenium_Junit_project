package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailHogPage extends BasePageObject {

    @FindBy(xpath = "//div[@id='content']//h3[@class='display-3 text-center']")
    private WebElement emailConfirmationContentElement;
    @FindBy(xpath = "//div[@class='msglist-message row ng-scope']//div[contains(text(),'a few seconds ago')]")
    private WebElement recentEmailMessageElement;
    @FindBy(xpath = "//div[@class='tab-pane ng-binding active']//a[@target='_blank']")
    private WebElement confirmationLinkElement;

    public MailHogPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    //Find recently received email
    public void waitForEmail(String emailToWait) {
        WebElement recentEmailMessageElement = null;
        while (recentEmailMessageElement == null) {
            try {
                recentEmailMessageElement = driver.findElement(By.xpath("//div[contains(text(),'" + emailToWait + "')]"));
            } catch (org.openqa.selenium.NoSuchElementException e) {
            }
        }
        // Email message is visible, click on it
        recentEmailMessageElement.click();
        log.info("Driver found registration confirmation email");
    }

    public void clickConfirmationLink() {
        confirmationLinkElement.click();
        log.info("Confirmation link was clicked");
    }

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

