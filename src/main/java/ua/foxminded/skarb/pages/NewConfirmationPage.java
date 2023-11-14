package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ua.foxminded.skarb.utils.BasePage;

public class NewConfirmationPage extends BasePage{

    private WebDriver driver;

    public NewConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
