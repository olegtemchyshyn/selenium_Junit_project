package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {

    @FindBy(xpath = "//a[@href='/registration']//i")
    private WebElement registrationPlusButton;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickPlusButton() {
        registrationPlusButton.click();
        return new RegistrationPage(driver, log);
    }

}
