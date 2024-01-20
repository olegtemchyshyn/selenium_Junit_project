package ua.foxminded.skarb.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    protected static WebDriver driver;
    protected static Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
    }

    //Get title of current page
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    //Get source of current page
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    // Wait for specific ExpectedCondition for the given amount of time in seconds
    protected void waitElementWithCondition(WebElement element, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for given number of seconds for element with given locator to be visible on the page
    protected void waitElementTillVisibility(WebElement element, Integer... timeOutInSeconds) {
        int attempts = 0;
        int timeout = timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : 30; // default to 30 seconds if not specified
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                break; // Exit loop if successful
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }
}