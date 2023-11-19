package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.foxminded.skarb.utils.BaseTest;

import java.util.Set;

public class NewConfirmationPage extends BasePageObject {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='alert alert-success']//h3[@class='display-3 text-center']")
    private WebElement confirmationMessage;

    public NewConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public void waitForConfirmationMessage() {
        waitForVisibilityOf(confirmationMessage, 10);
    }


    public void switchToLastTab() {
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindow : allWindows) {
            driver.switchTo().window(currentWindow);
        }
    }
}
