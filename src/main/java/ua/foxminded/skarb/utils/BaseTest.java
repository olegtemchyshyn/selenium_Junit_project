package ua.foxminded.skarb.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BaseTest extends TestUtilities {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println("Create driver: Chrome");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Close driver");
        driver.quit();
    }

    //Get title of current page
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    //Get source of current page
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

}
