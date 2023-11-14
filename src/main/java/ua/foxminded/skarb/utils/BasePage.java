package ua.foxminded.skarb.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

    /** Get title of current page */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    /** Get source of current page */
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

}
