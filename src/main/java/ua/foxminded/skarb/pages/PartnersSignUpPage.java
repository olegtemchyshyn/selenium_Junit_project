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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Enter random email
    public PartnersSignUpPage inputRandomEmail() {
        emailElement.sendKeys(randomEmail);
        System.out.println("Email is written: " + randomEmail);
        return this;
    }

    // enter random first name
    public PartnersSignUpPage inputRandomFirstName() {
        firstNameElement.sendKeys(randomFirstName);
        System.out.println("First name is written: " + randomFirstName);
        return this;
    }

    // enter random last name
    public PartnersSignUpPage inputRandomLastName() {
        lastNameElement.sendKeys(randomLastName);
        System.out.println("Last name is written: " + randomLastName);
        return this;
    }

    // click on "Female" rondo button
    public PartnersSignUpPage clickFemaleRondoButon() {
        femaleSexRadioButton.click();
        System.out.println("Sex:Female is chosen");
        return this;
    }

    // enter password and confirmation
    public PartnersSignUpPage inputRandomPasswords() {
        passwordElement.sendKeys(randomPassword);
        confirmPasswordElement.sendKeys(randomPassword);
        System.out.println("Password & Confirmation are written");
        return this;
    }

    // enter organization random name
    public PartnersSignUpPage inputRandomOrganizationName() {
        organizationNameElement.sendKeys(randomOrganizationName);
        System.out.println("Organization name is written: " + randomOrganizationName);
        return this;
    }

    // Select category "Programming"
    public PartnersSignUpPage selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(5);
        select.selectByVisibleText("Programming");
        System.out.println("'Programming' category is chosen");
        return this;
    }

    //Type partners' occupation
    public PartnersSignUpPage enterPossition() {
        positionInOrganizationElement.sendKeys("Manager");
        System.out.println("Position 'Manager' is written");
        return this;
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        System.out.println("Sign Up button is clicked.");
        return new CongratsNgoPage(driver);
    }
}
