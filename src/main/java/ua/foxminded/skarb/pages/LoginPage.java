package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {

    @FindBy(id = "login")
    private WebElement inputLoginField;
    @FindBy(id = "password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//button[@name='login-button']")
    private WebElement enterButton;
    String randomEmail = NgoSignUpPage.randomEmail;
    String randomPassword = NgoSignUpPage.randomPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeLogin() {
        inputLoginField.sendKeys(randomEmail);
        log.info("Login field '" + randomEmail + "' email was used");
    }

    public void typePassword() {
        inputPasswordField.sendKeys(randomPassword);
        log.info("Password field '" + randomPassword + "' password was used");
    }

    public PrivatePage clickEnterButton() {
        enterButton.click();
        return new PrivatePage(driver);
    }
}


