package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static ua.foxminded.skarb.utils.DataGenerator.*;

public class NgoSignUpPage extends BasePageObject {

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
    static String randomFirstName = dataGenerator(5);
    static String randomLastName = dataGenerator(5);
    static String domain = domainExample();
    static String randomEmail = randomFirstName + "." + randomLastName + domain;
    static String randomPassword = generatePassword();
    String randomOrganizationName = companyNameGenerator(6);

    public NgoSignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void inputRandomEmailmail() {
        emailElement.sendKeys(randomEmail);
        log.info("Email was written: " + randomEmail);
    }

    // enter random first name
    public void inputRandomFirstName() {
        firstNameElement.sendKeys(randomFirstName);
        log.info("First name was written: " + randomFirstName);
    }

    // enter random last name
    public void inputRandomLastName() {
        lastNameElement.sendKeys(randomLastName);
        log.info("Last name was written: " + randomLastName);
    }

    // click on "Female" rondo button
    public void clickMaleRondoButon() {
        maleSexRadioButton.click();
        log.info("Sex:Male was chosen.");
    }

    // enter password and confirmation
    public void inputRandomPasswords() {
        passwordElement.sendKeys(randomPassword);
        confirmPasswordElement.sendKeys(randomPassword);
        log.info("Password & Confirmation were written");
    }

    // enter organization random name
    public void inputRandomOrganizationName() {
        organizationNameElement.sendKeys(randomOrganizationName);
        log.info("Organization name was written: " + randomOrganizationName);
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
        return new CongratsNgoPage(driver);
    }
}
