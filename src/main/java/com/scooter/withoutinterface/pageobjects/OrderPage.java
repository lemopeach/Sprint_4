package com.scooter.withoutinterface.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    //Заголовок страницы. По нему мы определим, что страница загрузилась
    protected By headOfOrderPage = By.className("Order_Header__BZXOb");

    //Поскольку у полей стоит *, буду считать, что все поля обязательны для заполнения. Поле для ввода Имени
    protected By placeForName = By.xpath(".//input[@placeholder='* Имя']");

    //поле для ввода Фамилии
    protected By placeForSecondName = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле для ввода Адреса
    protected By placeForAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //кнопка выбора станции Метро
    protected By subwayButton = By.className("select-search");

    //поле для ввода телефона
    protected By placeForPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка Далее
    protected By nextButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM')]");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //Элемент по названию станции в выпадающем списке
    protected By subwayStation(String Station) {
        return By.xpath(".//*[text()='" + Station + "']");
    }

    public OrderPage enterDataForOrder(String nameOfClient, String secondNameOfClient, String adressOfClient, String subwayOfClient, String phoneNumberOfClient) {

        visibleElement(headOfOrderPage); //Проверяем, что страница загрузилась
        driver.findElement(placeForName).sendKeys(nameOfClient); //Заполняем поле Имя
        driver.findElement(placeForSecondName).sendKeys(secondNameOfClient); //Заполняем поле Фамилия
        driver.findElement(placeForAdress).sendKeys(adressOfClient); //Заполняем поле Адрес
        driver.findElement(subwayButton).click(); //Нажимаем на выбор метро

        visibleElement(subwayStation(subwayOfClient)); //Проверяем, что выпадающий список открылся

        scrollPage(subwayStation(subwayOfClient)); //Листаем до нужной станции

        driver.findElement(subwayStation(subwayOfClient)).click();//Выбираем нужную станцию
        driver.findElement(placeForPhoneNumber).sendKeys(phoneNumberOfClient); //Заполняем номер телефона

        return this;
    }

    public RentPage pressNextButton() {
        driver.findElement(nextButton).click();
        return new RentPage(driver);
    }
}
