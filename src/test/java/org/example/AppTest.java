package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppTest {

     static WebDriver driver;


    @BeforeAll
    static void init(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void getPage() {
        driver.get("https://www.superapteka.ru");
        driver.manage().deleteAllCookies();
    }




    @Test
    @DisplayName("Авторизация")
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        Thread.sleep(1000);
        WebElement webElement1= driver.findElement(By.xpath(".//span[contains(.,'Войти')]"));
        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }
        webElement1.click();
        Thread.sleep(1000);
        WebElement webElement2 = driver.findElement(By.id("phone"));
        webElement2.sendKeys("9111123435");
        webElement2.submit();
        Thread.sleep(1000);
        WebElement webElement3 = driver.findElement(By.id("password"));
        webElement3.sendKeys("tm05TM05");
        Thread.sleep(1000);
        webElement3.submit();
        WebElement webElement4 = driver.findElement(By.xpath(".//button[contains(.,'Войти')]"));
        webElement4.click();
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
    }



    @Test
    @DisplayName("Замена личных данных")

    public void test2() throws InterruptedException {

        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        Thread.sleep(2000);
        WebElement webElement1= driver.findElement(By.xpath(".//span[contains(.,'Войти')]"));
        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }
        webElement1.click();
        Thread.sleep(1000);
        WebElement webElement2 = driver.findElement(By.id("phone"));
        webElement2.sendKeys("9111123435");
        webElement2.submit();
        Thread.sleep(1000);
        WebElement webElement3 = driver.findElement(By.id("password"));
        webElement3.sendKeys("tm05TM05");
        Thread.sleep(1000);
        webElement3.submit();
        WebElement webElement4 = driver.findElement(By.xpath(".//button[contains(.,'Войти')]"));
        webElement4.click();
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        WebElement webElement5 = driver.findElement(By.cssSelector(".dqBnxB"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", webElement5);
        Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ebIolo")));
        WebElement webElement6 = driver.findElement(By.cssSelector(".ebIolo"));
        webElement6.click();
        Thread.sleep(1000);
        Assertions.assertEquals("Личный кабинет", driver.getTitle(), "страница  недоступна");

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
        Thread.sleep(1000);

        Assertions.assertEquals("Личный кабинет", driver.getTitle(), "страница недоступна");

    }

    @Test
    @DisplayName("Поиск")
    public void test3() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
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

        Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@value='омез']")));
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@value='омез']"));
        Thread.sleep(1000);
        Assertions.assertTrue (driver.findElement(By.xpath(".//input[@value='омез']")).isDisplayed());

        webElement3.clear();
        Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='logo']")));
        WebElement webElement4 = driver.findElement(By.xpath("//img[@alt='logo']"));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", webElement4);
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@value='']")));
        WebElement webElement5 = driver.findElement(By.xpath(".//input[@type='search']"));
       // webElement5.click();
        webElement5.sendKeys("jvtp");
        Thread.sleep(1000);
        Assertions.assertTrue (driver.findElement(By.xpath(".//input[@value='jvtp']")).isDisplayed());

        WebElement webElement6 = driver.findElement(By.id("searchSubmit"));
        webElement6.click();

    }


    @Test
    @DisplayName("Добавление в корзину через кнопку")
    public void test4() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        WebElement webElement1 = driver.findElement(By.xpath("//img[@alt='Эркафарм Пустырник с витамином С таб.№60']"));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", webElement1);
        Thread.sleep(3000);

        WebElement webElement2 = driver.findElement(By.cssSelector(".ggnCCj > .AppButton__AppButtonDefault-sc-122azo8-0"));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", webElement2);
        Thread.sleep(1000);
        WebElement webElement3 = driver.findElement(By.cssSelector(".AppCircularCounter__AppCircularCounterBlock-sc-1l48tdq-0 "));
        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click();", webElement3);
        Thread.sleep(1000);
        Assertions.assertEquals("Корзина Superapteka", driver.getTitle(), "страница недоступна");

        Assertions.assertTrue (driver.findElement(By.xpath("//*[@href='/catalog/product/erkafarm-pustyrnik-s-vitaminom-s-tab-60/']")).isDisplayed());


    }

    @Test
    @DisplayName("Проверка бонусов")
    public void test5() throws InterruptedException {

               Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        Thread.sleep(1000);
        WebElement webElement1= driver.findElement(By.xpath(".//span[contains(.,'Войти')]"));
        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }
        webElement1.click();
        Thread.sleep(1000);
        WebElement webElement2 = driver.findElement(By.id("phone"));
        webElement2.sendKeys("9111123435");
        webElement2.submit();
        Thread.sleep(1000);
        WebElement webElement3 = driver.findElement(By.id("password"));
        webElement3.sendKeys("tm05TM05");
        Thread.sleep(1000);
        webElement3.submit();
        WebElement webElement4 = driver.findElement(By.xpath(".//button[contains(.,'Войти')]"));
        webElement4.click();
        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        WebElement webElement5 = driver.findElement(By.xpath("//*[@href='/lk/bonuses/']"));
        webElement5.click();
        Thread.sleep(1000);
        Assertions.assertEquals("Начисление бонусов", driver.getTitle(), "страница недоступна");
        }


    @Test
    @DisplayName("Любимые товары")
    public void test6() throws InterruptedException {

        Thread.sleep(1000);
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", driver.getTitle(), "страница входа недоступна");
        WebElement webElement1 = driver.findElement(By.cssSelector(".FavoritesWidget__FavoritesWidgetIcon-sc-ctistr-1"));
        webElement1.click();
        Thread.sleep(1000);
        Assertions.assertEquals("Избранные товары", driver.getTitle(), "страница недоступна");
    }

        @AfterAll
    static void close(){
        driver.quit();
    }
}










