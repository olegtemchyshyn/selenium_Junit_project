package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {
    private String randomEmail;
    private String randomPassword;

    @FindBy(id = "login")
    private WebElement inputLoginField;
    @FindBy(id = "password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//button[@name='login-button']")
    private WebElement enterButton;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        NgoSignUpPage ngoSignUpPage = new NgoSignUpPage(driver, log);
        PageFactory.initElements(driver, this);
        this.randomEmail = randomEmail;
        this.randomPassword = randomPassword;
    }

    public void typeLogin() {
        inputLoginField.sendKeys( randomEmail);
        log.info("Login field '" + randomEmail + "' email was used");
    }

    public void typePassword() {
        inputPasswordField.sendKeys(randomPassword);
        log.info("Password field '" + randomPassword + "' password was used");
    }

    public PrivatePage clickEnterButton() {
        enterButton.click();
        log.info("Enter button was clicked.");
        return new PrivatePage(driver, log);
    }
}


