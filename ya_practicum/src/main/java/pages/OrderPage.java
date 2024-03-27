package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerOrder = By.xpath("//div[contains(@class,'Header')]//button[text()='Заказать']");
    private By bodyOrder = By.xpath("//div[contains(@class,'FinishButton')]//button[text()='Заказать']");
    private By nameField = By.xpath("//input[contains(@placeholder,'Имя')]");
    private By surnameField = By.xpath("//input[contains(@placeholder,'Фамилия')]");
    private By addressField = By.xpath("//input[contains(@placeholder,'Адрес')]");
    private By metroField = By.xpath("//input[contains(@placeholder,'метро')]");
    private By phoneField = By.xpath("//input[contains(@placeholder,'Телефон')]");
    private By nextOrderPageField = By.xpath("//button[text()='Далее']");
    private By takeOrderField = By.xpath("//div[contains(@class,'Order')]//button[text()='Заказать']");
    private By deliveryDateField = By.xpath("//input[contains(@placeholder,'Когда привезти самокат')]");
    private By rentalPeriodField = By.xpath("//div[contains(text(),'Срок аренды')]");
    private By colorField = By.xpath("//div[contains(text(),'Цвет самоката')]");
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By confirmOrderField = By.xpath("//button[text()='Да']");
    private By titleOfSuccessOrder = By.xpath("//div[contains(@class,'Order_ModalHeader')]");

    public void takeHeaderOrder() {
        driver.findElement(headerOrder).click();
    }

    public void takeBodyOrder() {
        driver.findElement(bodyOrder).click();
    }

    public void fillFirstForm(String name, String surname, String address, String metro, String phone) throws InterruptedException {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
        Thread.sleep(1000);
        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
        Thread.sleep(1000);
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(By.xpath("//input[contains(@placeholder,'метро')]/../following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(phoneField).click();
        driver.findElement(phoneField).sendKeys(phone);
        Thread.sleep(1000);
        driver.findElement(nextOrderPageField).click();

    }

    public void fillSecondForm(String deliveryDate, String rentalPeriod, String color, String comment) throws InterruptedException {
        driver.findElement(deliveryDateField).click();
        driver.findElement(deliveryDateField).sendKeys(deliveryDate, Keys.ENTER);
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodField).findElement(By.xpath("./../following-sibling::div//div[text()='" + rentalPeriod + "']")).click();
        driver.findElement(colorField).click();
        driver.findElement(colorField).findElement(By.xpath("./following-sibling::label[text()='" + color + "']")).click();
        driver.findElement(commentField).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(takeOrderField).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderField));
        driver.findElement(confirmOrderField).click();
    }

    public String getOrderTitle(){
       return driver.findElement(titleOfSuccessOrder).getText().substring(0,14);
    }
}
