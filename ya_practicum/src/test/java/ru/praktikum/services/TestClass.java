package ru.praktikum.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(Parameterized.class)
public class TestClass {

    private String cityName;
    private boolean isVisible;

    public TestClass(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {"Москва", true},
                {"Санкт-Петербург", true}
                // Добавь другие города для проверки здесь
        };
    }

    @Test
    public void citiesTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Выполним авторизацию
        driver.findElement(By.id("email")).sendKeys("chunvar@list.ru");
        driver.findElement(By.id("password")).sendKeys("123456aA");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Найдем карточки городов и проверим их видимость
        List<WebElement> elements = driver.findElements(By.className("city-card"));

        for (WebElement element : elements) {
            if (element.getText().contains(cityName)) {
                assertEquals(element.isDisplayed(), isVisible);
            }
        }
    }
}