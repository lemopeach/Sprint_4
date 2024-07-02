package com.scooter.pageobjects;

import com.scooter.constants.OrderButtonPlace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {

    // Логотип, размещенный в заголовке страницы
    protected By logo = By.xpath(".//div[@class='Header_Logo__23yGT']");

    // Блок "Вопросы о важном"
    protected By blockImportantQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text() = 'Вопросы о важном']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Кнопка для раскрытия вложенного текста у элемента c вопросом
    protected By openElementButton(int numOfQuestion) {
        return By.id("accordion__heading-" + numOfQuestion);
    }

    // Блок с отображаемым ответом при нажатии кнопки
    protected By elementName(int numOfQuestion) {
        return By.id("accordion__panel-" + numOfQuestion);
    }

    //Кнопка "Заказать" вверху и внизу страницы (в зависимости от входных параметров)
    protected By orderButton(String placeOfButton) {
        String xpathOfButton;
        if (OrderButtonPlace.MIDDLE.equals(placeOfButton)) {
            xpathOfButton = ".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM')]";
        } else {
            xpathOfButton = ".//button[@Class='Button_Button__ra12g']";
        }
        return By.xpath(xpathOfButton);
    }

    public HomePage checkPresenceOfBlock() {
        visibleElement(logo); // страница загрузилась, когда элемент отображен
        scrollPage(blockImportantQuestions); // прокручиваем страницу до блока "Вопросы о важном"
        return this;
    }

    public void checkElements(int numOfQuestion, String question, String answer) {

        waitingVisibleElement(openElementButton(numOfQuestion)); //ожидаем, пока на странице отобразится N элемент с вопросом
        assertEquals(question, driver.findElement(openElementButton(numOfQuestion)).getText()); // проверяем, что у N элемента вопрос, который мы проверяем
        driver.findElement(openElementButton(numOfQuestion)).click(); //нажимаем на этот вопрос
        waitingVisibleElement(elementName(numOfQuestion)); // ожидаем, пока на странице отобразится ответ на вопрос
        assertEquals(answer, driver.findElement(elementName(numOfQuestion)).getText()); //проверяем, что в ответе корректный текст
    }

    public OrderPage makeOrder(String placeOfButton) {
        visibleElement(logo); //проверяем, что страница загрузилась
        scrollPage(orderButton(placeOfButton)); //прокручиваем страницу до кнопки "Заказать"
        assertEquals("Заказать", driver.findElement(orderButton(placeOfButton)).getText()); //проверяем, что кнопка действительно называется "Заказать"
        driver.findElement(orderButton(placeOfButton)).click();//нажимаем на кнопку "Заказать"
        return new OrderPage(driver);
    }
}
