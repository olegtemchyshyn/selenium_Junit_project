package ua.foxminded.skarb.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends TestUtilities {

    protected WebDriver driver;
    protected Logger log;

    public BaseTest() {
        this.log = LogManager.getLogger(this.getClass());
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        log.info("Create driver: Chrome");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        log.info("Close driver");
        driver.quit();
    }

}
