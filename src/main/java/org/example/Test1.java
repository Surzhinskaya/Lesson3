package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;



public class Test1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://superapteka.ru");


        WebElement webElement1 = driver.findElement(By.xpath(".//span[contains(.,'Войти')]"));
        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }

        webElement1.click();

        WebElement webElement2 = driver.findElement(By.id("phone"));
        webElement2.sendKeys("9111123435");
        try {
            webElement2.sendKeys("9111123435");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }


        WebElement webElement3 = driver.findElement(By.id("password"));
        webElement3.click();
        webElement3.sendKeys("tm05TM05");


       WebElement webElement4 = driver.findElement(By.xpath(".//button[contains(.,'Войти')]"));
       webElement4.click();


       //driver.close();

    }
}
