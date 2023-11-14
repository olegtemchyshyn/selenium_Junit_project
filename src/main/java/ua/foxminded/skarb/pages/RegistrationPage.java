package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Partner')]")
    WebElement partnerButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PartnersSignUpPage clickPartnerButton() {
        partnerButton.click();
        return new PartnersSignUpPage(driver);
    }
}
