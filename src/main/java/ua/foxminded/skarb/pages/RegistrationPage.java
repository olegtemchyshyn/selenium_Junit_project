package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePageObject {
    private WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Partner')]")
    WebElement partnerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PartnersSignUpPage clickPartnerButton() {
        partnerButton.click();
        return new PartnersSignUpPage(driver);
    }
}
