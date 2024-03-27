package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;

    private By tableItems = By.xpath("//div[@class='accordion']");
    private By coockie = By.xpath("//button[@id='rcc-confirm-button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTableItems() {
        return driver.findElement(tableItems);
    }

    public void clickCoockie() {
        driver.findElement(coockie).click();
    }



}