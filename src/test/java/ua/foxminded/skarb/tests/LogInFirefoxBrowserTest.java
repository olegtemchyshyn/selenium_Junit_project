package ua.foxminded.skarb.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInFirefoxBrowserTest {
    @Test
    public void logInTestFr () {

        System.out.println("Starting logInTest");

        //Create driver WebDriver
        WebDriver driver = new FirefoxDriver();

        //sleep
        sleep(2000);

        //maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "https://skarb.foxminded.ua/login";
        driver.get(url);
        System.out.println("Page is open");

        //enter logIn
        WebElement login = driver.findElement(By.id("login"));
        login.sendKeys("Example");
        System.out.println("Login is typing");

        //enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("WhatEver");
        System.out.println("Password is typing");

        //sleep
        sleep(3000);

        //Close browser
        driver.quit();


    }
    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
