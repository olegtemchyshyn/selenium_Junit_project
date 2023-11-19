package ua.foxminded.skarb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.foxminded.skarb.utils.BaseTest;

import java.time.Duration;

public class BasePageObject extends BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Open page with given URL */
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Find element using given locator */
    /*protected WebElement find(WebElement element) {
        return element;
    }*/

    // Click on element with given locator when its visible */
   /* protected void click(WebElement element) {
        waitForVisibilityOf(element, 5);
        find(element).click();
    }*/

    //Get title of current page
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    //Get source of current page
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    //Type given text into element with given locator */
   /* protected void type(String text, WebElement element) {
        waitForVisibilityOf(element, 5);
        find(element).sendKeys(text);
    }*/

    // Wait for specific ExpectedCondition for the given amount of time in seconds
    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(condition);
    }

     // Wait for given number of seconds for element with given locator to be visible on the page
    protected void waitForVisibilityOf(WebElement element, Integer... timeOutInSeconds) {
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