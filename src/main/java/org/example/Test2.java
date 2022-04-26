package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test2 {
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


        WebElement webElement5 = driver.findElement(By.cssSelector(".dqBnxB"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", webElement5);



        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ebIolo")));
        WebElement webElement6 = driver.findElement(By.cssSelector(".ebIolo"));
        webElement6.click();

       new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Редактировать профиль')]")));
       WebElement webElement7 = driver.findElement(By.xpath("//button[contains(.,'Редактировать профиль')]"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", webElement7);

        WebElement webElement8 = driver.findElement(By.xpath("//*[@id='lastName']"));
        webElement8.click();
        webElement8.clear();
        webElement8.sendKeys("Иванова");

        WebElement webElement9 = driver.findElement(By.xpath("//button[contains(.,'Сохранить изменения')]"));
        JavascriptExecutor executor3 = (JavascriptExecutor)driver;
        executor3.executeScript("arguments[0].click();", webElement9);

        WebElement webElement10 = driver.findElement(By.cssSelector(".ebIolo"));
        webElement10.click();

       // driver.close();

    }
}

