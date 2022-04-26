package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class Test3 {


    public static void main(String[] args)  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://superapteka.ru");

      WebElement webElement1 = driver.findElement(By.xpath(".//input[@value='']"));
        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }

        webElement1.click();
        webElement1.sendKeys("омез");

        WebElement webElement2 = driver.findElement(By.id("searchSubmit"));
        webElement2.click();



        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@value='омез']")));
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@value='омез']"));

        webElement3.clear();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='logo']")));
        WebElement webElement4 = driver.findElement(By.xpath("//img[@alt='logo']"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", webElement4);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@value='']")));
        WebElement webElement5 = driver.findElement(By.xpath(".//input[@type='search']"));
        webElement5.click();
       webElement5.sendKeys("jvtp");


        WebElement webElement6 = driver.findElement(By.id("searchSubmit"));
        webElement6.click();


        // driver.close();
    }
}