package ru.praktikum.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.pages.HomePage;
import ru.praktikum.services.pages.OrderPage;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTests {

    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;
    private String deliveryDate;
    private String rentalPeriod;
    private String color;
    private String comment;

    public OrderTest(String name, String surname, String address, String metro, String phone, String deliveryDate,
                     String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Автотест", "Автотестов", "Улица Пушкина дом Колотушкина", "Лубянка", "89131231212", "31.03.2024", "трое суток", "серая безысходность", "Позвонить за 10 минут до приезда"},
                {"Автотестер", "Автотестеров", "Улица Есенина дом Колотушкина", "Красносельская", "89131231233", "25.03.2024", "сутки", "чёрный жемчуг", "Позвонить за 15 минут до приезда"}
        };
    }

    @Test
    public void getHeaderOrder() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        homePage.clickCoockie();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.takeHeaderOrder();
        orderPage.fillFirstForm(name, surname, address, metro, phone);
        orderPage.fillSecondForm(deliveryDate, rentalPeriod, color, comment);
        assertEquals("Заказ оформлен", orderPage.getOrderTitle());
    }

    @Test
    public void getBodyOrder() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        homePage.clickCoockie();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.takeBodyOrder();
        orderPage.fillFirstForm(name, surname, address, metro, phone);
        orderPage.fillSecondForm(deliveryDate, rentalPeriod, color, comment);
        assertEquals("Заказ оформлен", orderPage.getOrderTitle());
    }
}
