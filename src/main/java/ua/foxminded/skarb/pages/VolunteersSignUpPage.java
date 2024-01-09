package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VolunteersSignUpPage extends BasePageObject {

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
    @FindBy(id = "categories")
    private WebElement categoryElement;
    @FindBy(xpath = "//button[@name='submit']")
    private WebElement signUpButton;

    public VolunteersSignUpPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    public static class Builder {
        private String email;
        private String firstName;
        private String lastName;
        private String password;
        private WebDriver driver;
        private Logger log;

        public Builder(WebDriver driver, Logger log) {
            this.driver = driver;
            this.log = log;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public VolunteersSignUpPage build() {
            VolunteersSignUpPage volunteer = new VolunteersSignUpPage(driver, log);
            volunteer.inputEmail(this.email);
            volunteer.inputFirstName(this.firstName);
            volunteer.inputLastName(this.lastName);
            volunteer.inputPasswords(this.password);
            volunteer.selectProgrammingCategory();
            return volunteer;
        }
    }

    public void inputEmail(String email) {
        emailElement.sendKeys(email);
        log.info("Email was written: " + email);
    }

    // enter first name
    public void inputFirstName(String firstName) {
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        log.info("First name was written: " + firstName);
    }

    // enter last name
    public void inputLastName(String lastName) {
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
        log.info("Last name was written: " + lastName);
    }

    // enter password and confirmation
    public void inputPasswords(String password) {
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(password);
        log.info("Password & Confirmation were written");
    }

    // Select category "Programming"
    public void selectProgrammingCategory() {
        Select select = new Select(categoryElement);
        select.selectByIndex(4);
        select.selectByVisibleText("Programming");
        log.info("'Programming' category was chosen");
    }

    // Complete registration. Click Sign Up
    public CongratsNgoPage clickSignUpButton() {
        signUpButton.click();
        log.info("Sign Up button was clicked.");
        return new CongratsNgoPage(driver, log);
    }
}
