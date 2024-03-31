package ru.praktikum.services.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;

    private By questionField;

    private By answerField;

    private By coockie = By.xpath("//button[@id='rcc-confirm-button']");

    private By tableItems = By.xpath("//div[@class='accordion']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getQuestionField() {
        return driver.findElement(questionField);
    }

    public void setQuestionField(String question) {
        this.questionField = By.xpath("//div[@class='accordion']//div//div[text()='" + question + "']");

    }

    public By getAnswerField() {
        return answerField;
    }

    public void setAnswerField(String answer) {
        this.answerField = By.xpath("//div[@class='accordion']//div//p[text()='" + answer + "']");
    }

    public WebElement getTableItems() {
        return driver.findElement(tableItems);
    }


    public void clickCoockie() {
        driver.findElement(coockie).click();
    }


}