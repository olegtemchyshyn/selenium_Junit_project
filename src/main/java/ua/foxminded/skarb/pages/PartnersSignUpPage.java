package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PartnersSignUpPage extends BasePageObject {

    @FindBy(xpath = "//button[@name='submit']")
    private WebElement signUpButton;
    @FindBy(id = "email")
    private WebElement emailElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "female")
    private WebElement femaleSexRadioButton;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordElement;
    @FindBy(id = "organizationName")
    private WebElement organizationNameElement;
    @FindBy(xpath = "//select[@id='categoryIds']")
    private WebElement categoryElement;
    @FindBy(id = "positionInOrganization")
    private WebElement positionInOrganizationElement;

    public PartnersSignUpPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    // Enter random email
    public void inputRandomEmail(String email) {
        emailElement.sendKeys(email);
        log.info("Email was written: " + email);
    }

    // enter random first name
    public void inputRandomFirstName(String firsName) {
        firstNameElement.sendKeys(firsName);
        log.info("First name was written: " + firsName);
    }

    // enter random last name
    public void inputRandomLastName(String lastName) {
        lastNameElement.sendKeys(lastName);
        log.info("Last name was written: " + lastName);
    }

    // click on "Female" rondo button
    public void clickFemaleRondoButon() {
        femaleSexRadioButton.click();
        log.info("Sex:Female was chosen.");
    }

    // enter password and confirmation
    public void inputRandomPasswords(String password) {
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(password);
        log.info("Password & Confirmation were written.");
    }

    // enter organization random name
    public void inputRandomOrganizationName(String organization) {
        organizationNameElement.sendKeys(organization);
        log.info("Organization name was written: " + organization);
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen.");
    }

    //Type partners' occupation
    public PartnersSignUpPage inputPosition(String position) {
        positionInOrganizationElement.sendKeys(position);
        log.info("Position: " + position + " was written.");
        return this;
    }

    //fill application with one method
    public PartnersSignUpPage fillRegistrationForm(String email, String firstName, String lastName, String password, String organization) {
        inputRandomEmail(email);
        inputRandomFirstName(firstName);
        inputRandomLastName(lastName);
        clickFemaleRondoButon();
        inputRandomPasswords(password);
        inputRandomOrganizationName(organization);
        selectProgrammingCategory();
        return this;
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked");
        return new CongratsNgoPage(driver, log);
    }
}
