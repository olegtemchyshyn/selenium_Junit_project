package ua.foxminded.skarb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    By partnerButton = By.xpath("//button[contains(text(),'Partner')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;

    }

    public PartnersSignUpPage clickPartnerButton() {
        driver.findElement(partnerButton).click();
        return new PartnersSignUpPage(driver);

    }
}
