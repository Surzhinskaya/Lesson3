package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test4 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://superapteka.ru");


        WebElement webElement1 = driver.findElement(By.xpath("//img[@alt='Эркафарм Пустырник с витамином С таб.№60']"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", webElement1);


        WebElement webElement2 = driver.findElement(By.cssSelector(".ggnCCj > .AppButton__AppButtonDefault-sc-122azo8-0"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", webElement2);

        WebElement webElement3 = driver.findElement(By.cssSelector(".AppCircularCounter__AppCircularCounterBlock-sc-1l48tdq-0 "));
        JavascriptExecutor executor3 = (JavascriptExecutor)driver;
        executor3.executeScript("arguments[0].click();", webElement3);

        WebElement webElement4 = driver.findElement(By.xpath("//img[@alt='Эркафарм Пустырник с витамином С таб.№60']"));
        webElement4.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dTAYuO")));
        WebElement webElement5 = driver.findElement(By.cssSelector(".dTAYuO"));
        webElement5.click();

        WebElement webElement6 = driver.findElement(By.cssSelector(".AppCircularCounter__AppCircularCounterBlock-sc-1l48tdq-0"));
        JavascriptExecutor executor4 = (JavascriptExecutor)driver;
        executor4.executeScript("arguments[0].click();", webElement6);


        //driver.close();

    }
}