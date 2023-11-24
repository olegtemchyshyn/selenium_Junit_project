package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static ua.foxminded.skarb.utils.DataGenerator.*;

public class PartnersSignUpPage extends BasePageObject {
    private WebDriver driver;

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
    String randomFirstName = dataGenerator(6);
    String randomLastName = dataGenerator(7);
    String domain = domainCorporate();
    String randomEmail = randomFirstName + "." + randomLastName + domain;
    String randomPassword = generatePassword();
    String randomOrganizationName = companyNameGenerator(4);

    public PartnersSignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Enter random email
    public void inputRandomEmail() {
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
    public void clickFemaleRondoButon() {
        femaleSexRadioButton.click();
        log.info("Sex:Female was chosen");
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

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen");
    }

    //Type partners' occupation
    public PartnersSignUpPage inputPosition(String position) {
        positionInOrganizationElement.sendKeys(position);
        log.info("Position: " + position + " was written");
        return this;
    }

    //fill application with one method
    public PartnersSignUpPage fillRegistrationForm() {
        inputRandomEmail();
        inputRandomFirstName();
        inputRandomLastName();
        clickFemaleRondoButon();
        inputRandomPasswords();
        inputRandomOrganizationName();
        selectProgrammingCategory();
        return this;
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked.");
        return new CongratsNgoPage(driver);
    }
}
