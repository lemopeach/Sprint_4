package com.scooter.withinterface.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderPage extends BasePage {

    //Заголовок страницы. По нему мы определим, что страница загрузилась
    protected static By headOfOrderPage = By.className("Order_Header__BZXOb");
    public static By getHeadOfOrderPage(){
        return headOfOrderPage;
    }

    //Поскольку у полей стоит *, буду считать, что все поля обязательны для заполнения. Поле для ввода Имени
    protected static By placeForName = By.xpath(".//input[@placeholder='* Имя']");
    public static By getPlaceForName(){
        return placeForName;
    }

    //поле для ввода Фамилии
    protected static By placeForSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    public static By getPlaceForSecondName() {
        return placeForSecondName;
    }

    //поле для ввода Адреса
    protected static By placeForAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public static By getPlaceForAdress() {
        return placeForAdress;
    }

    //кнопка выбора станции Метро
    protected static By subwayButton = By.className("select-search");
    public static By getSubwayButton() {
        return subwayButton;
    }

    //поле для ввода телефона
    protected static By placeForPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static By getPlaceForPhoneNumber() {
        return placeForPhoneNumber;
    }

    //кнопка Далее
    protected static By nextButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM')]");
    public static By getNextButton() {
        return nextButton;
    }

    //Элемент по названию станции в выпадающем списке
    protected static By subwayStation(String Station) {
        return By.xpath(".//*[text()='" + Station + "']");
    }
    public static By getSubwayStation(String Station){
        return subwayStation(Station);
    }

    public OrderPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    public OrderPage(WebDriver driver) {
        super(driver);
    }
}