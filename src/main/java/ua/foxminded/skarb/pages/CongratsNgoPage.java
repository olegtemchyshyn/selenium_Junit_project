package ua.foxminded.skarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
public class CongratsNgoPage extends BasePageObject {

    public CongratsNgoPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }

    //Open new tab
    public MailHogPage switchToMailHog() {
        String initHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://skarbmail.foxminded.ua/");
        log.info("Mail tab was open");
        return new MailHogPage(driver, log);
    }

}
