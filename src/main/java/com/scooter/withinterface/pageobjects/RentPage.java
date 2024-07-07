package com.scooter.withinterface.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RentPage extends BasePage {

    //Заголовок страницы. По нему мы определим, что страница загрузилась
    protected static By headerOfRentPage = By.className("Order_Header__BZXOb");
    public static By getHeaderOfRentPage() {
        return headerOfRentPage;
    }

    //Поле для ввода даты
    protected static By startDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public static By getStartDate() {
        return startDate;
    }

    //Кнопка для выбора периода аренды
    protected static By periodOfRent = By.className("Dropdown-control");
    public static By getPeriodOfRent() {
        return periodOfRent;
    }

    //Чекбокс. Цвет самоката - черный
    protected static By checkboxBlack = By.id("black");
    public static By getCheckboxBlack() {
        return checkboxBlack;
    }

    //Чекбокс. Цвет самока - серый
    protected static By checkboxGrey = By.id("grey");
    public static By getCheckboxGrey() {
        return checkboxGrey;
    }

    //Поле комментария
    protected static By placeForComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public static By getPlaceForComment() {
        return placeForComment;
    }

    //Кнопка "Заказать" для создания заказа
    protected static By createOrderButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']");
    public static By getCreateOrderButton() {
        return createOrderButton;
    }

    //Заголовок всплывающего окна
    protected static By floatHeader = By.className("Order_ModalHeader__3FDaJ");
    public static By getFloatHeader() {
        return floatHeader;
    }

    //Кнопка "Да" вспылвающего окна
    protected static By yesButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']");
    public static By getYesButton() {
        return yesButton;
    }

    //Заголовок всплывающего окна об успешном создании заказа
    protected static By floatLastHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    public static By getFloatLastHeader() {
        return floatLastHeader;
    }

    protected static By correctPeriod(String Period) {
        return By.xpath(".//*[text()='" + Period + "']");
    }
    public static By getCorrectPeriod(String Period){
        return correctPeriod(Period);
    }

    public RentPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    public RentPage(WebDriver driver) {
        super(driver);
    }
}
