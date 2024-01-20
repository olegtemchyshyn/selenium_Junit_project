package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {

    @FindBy(id = "login")
    private WebElement inputLoginField;
    @FindBy(id = "password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//button[@name='login-button']")
    private WebElement enterButton;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public void typeLogin(String login) {
        inputLoginField.sendKeys(login);
        log.info("Login field '" + login + "' email was used");
    }

    public void typePassword(String password) {
        inputPasswordField.sendKeys(password);
        log.info("Password field '" + password + "' password was used");
    }

    public void clickEnterButton() {
        enterButton.click();
        log.info("Enter button was clicked.");
        new PrivatePage(driver, log);
    }

    public LoginPage switchToLogin() {
        String loginHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://skarb.foxminded.ua/login");
        log.info("Log In tab was open");
        return new LoginPage(driver, log);
    }
}




