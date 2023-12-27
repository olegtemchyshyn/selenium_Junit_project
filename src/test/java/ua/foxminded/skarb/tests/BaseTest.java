package ua.foxminded.skarb.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @BeforeEach
    public void setUp() {
        log = LogManager.getLogger(getClass());
        driver = new ChromeDriver();
        log.info("Create driver: Chrome");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        log.info("Close driver");
        driver.quit();
    }

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}