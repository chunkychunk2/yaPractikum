package ru.praktikum.services;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.services.pages.HomePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DropDownListTest extends BaseTests {

    @Test
    public void checkResult() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Map<String, String> questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        questionsAndAnswers.put("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        questionsAndAnswers.put("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        questionsAndAnswers.put("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        questionsAndAnswers.put("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        questionsAndAnswers.put("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        questionsAndAnswers.put("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        questionsAndAnswers.put("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
        HomePage homePage = new HomePage(driver);
        WebElement element = homePage.getTableItems();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        homePage.clickCoockie();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> questionElement = homePage.getTableItems().findElements(By.xpath(".//div//div//div"));
        List<WebElement> answerElement = homePage.getTableItems().findElements(By.xpath(".//div//div//p"));
        for (int i = 0; i < questionElement.size(); i++) {
            questionElement.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='accordion']//div//div//p[contains(text(),'" + questionsAndAnswers.get(questionElement.get(i).getText()) + "')]")));
            assertEquals(questionsAndAnswers.get(questionElement.get(i).getText()), answerElement.get(i).getText());
        }
    }
}