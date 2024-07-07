package com.scooter.withinterface.pageobjects;

import com.scooter.constants.OrderButtonPlace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    // Логотип, размещенный в заголовке страницы
    protected static By logo = By.xpath(".//div[@class='Header_Logo__23yGT']");
    public static By getLogo(){
        return logo;
    }

    // Блок "Вопросы о важном"
    protected static By blockImportantQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text() = 'Вопросы о важном']");
    public static By getBlockImportantQuestions() {
        return blockImportantQuestions;
    };

    //Кнопка для раскрытия вложенного текста у элемента c вопросом + по совместительству блок, хранящий вопрос
    protected static By openElementButton(int numOfQuestion) {
        return By.id("accordion__heading-" + numOfQuestion);
    }
    public static By getOpenElementButton(int numOfQuestion){
        return openElementButton(numOfQuestion);
    }

    // Блок с отображаемым ответом при нажатии кнопки
    protected static By elementName(int numOfQuestion) {
        return By.id("accordion__panel-" + numOfQuestion);
    }
    public static By getElementName(int numOfQuestion){
        return elementName(numOfQuestion);
    }

    //Кнопка "Заказать" вверху и внизу страницы (в зависимости от входных параметров)
    protected static By orderButton(String placeOfButton) {
        String xpathOfButton;
        if (OrderButtonPlace.MIDDLE.equals(placeOfButton)) {
            xpathOfButton = ".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM')]";
        } else {
            xpathOfButton = ".//button[@Class='Button_Button__ra12g']";
        }
        return By.xpath(xpathOfButton);
    }
    public static By getOrderButton(String placeOfButton){
        return orderButton(placeOfButton);
    }

    public HomePage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}