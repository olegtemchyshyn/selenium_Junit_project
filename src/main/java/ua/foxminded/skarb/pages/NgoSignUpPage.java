package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ua.foxminded.skarb.utils.DataGenerator;

public class NgoSignUpPage extends BasePageObject {

    public String randomEmail;
    public String randomPassword;

    @FindBy(id = "email")
    private WebElement emailElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordElement;
    @FindBy(id = "categoryIds")
    private WebElement categoryElement;
    @FindBy(xpath = "//button[@name='submit']")
    private WebElement signUpButton;
    @FindBy(id = "male")
    private WebElement maleSexRadioButton;
    @FindBy(id = "organizationName")
    private WebElement organizationNameElement;
    @FindBy(id = "positionInOrganization")
    private WebElement positionInOrganizationElement;

    public NgoSignUpPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    // click on "Female" rondo button
    public void clickMaleRondoButon() {
        maleSexRadioButton.click();
        log.info("Sex:Male was chosen.");
    }

    // enter organization random name
    public void inputRandomOrganizationName(String organization) {
        organizationNameElement.sendKeys(organization);
        log.info("Organization name was written: " + organization);
    }

    //Type partners' occupation
    public NgoSignUpPage inputPosition(String position) {
        positionInOrganizationElement.sendKeys(position);
        log.info("Position: " + position + " was written.");
        return this;
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen");
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked.");
        return new CongratsNgoPage(driver, log);
    }

    public void inputEmail(String email) {
        emailElement.sendKeys(email);
        log.info("Email was written: " + email);
    }

    public void inputFirstName(String firstName) {
        firstNameElement.sendKeys(firstName);
        log.info("First name was written: " + firstName);
    }

    public void inputLastName(String lastName) {
        lastNameElement.sendKeys(lastName);
        log.info("Last name was written: " + lastName);
    }

    public void inputPasswords(String password) {
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(password);
        log.info("Password & Confirmation were written");
    }
}
