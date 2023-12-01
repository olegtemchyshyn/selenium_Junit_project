package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class PrivatePage extends BasePageObject {

    public PrivatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
