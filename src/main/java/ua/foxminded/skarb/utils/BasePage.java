package ua.foxminded.skarb.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends TestUtilities {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println("Create driver: Chrome");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        System.out.println("Close driver");
        driver.quit();
    }

}
