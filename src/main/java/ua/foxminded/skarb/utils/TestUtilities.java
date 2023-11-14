package ua.foxminded.skarb.utils;

import org.openqa.selenium.WebDriver;

public class TestUtilities {

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
