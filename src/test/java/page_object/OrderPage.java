package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    public WebDriver driver;

    //Заголовок страницы. По нему мы определим, что страница загрузилась
    public By headOfOrderPage = By.className("Order_Header__BZXOb");

    //Поскольку у полей стоит *, буду считать, что все поля обязательны для заполнения
    //поле для ввода Имени
    public By placeForName = By.xpath(".//input[@placeholder='* Имя']");

    //поле для ввода Фамилии
    public By placeForSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле для ввода Адреса

    public By placeForAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //кнопка выбора станции Метро
    public By subwayButton = By.className("select-search");

    //Элемент по названию станции в выпадающем списке
    public By subwayStation (String Station){
        return By.xpath(".//*[text()='"+Station+"']");
    }

    //поле для ввода телефона
    public By placeForPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка Далее
    public By nextButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM')]");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterDataForOrder(String nameOfClient, String secondNameOfClient, String adressOfClient, String subwayOfClient, String phoneNumberOfClient){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(headOfOrderPage)); //Проверяем, что страница загрузилась

        driver.findElement(placeForName).sendKeys(nameOfClient); //Заполняем поле Имя
        driver.findElement(placeForSecondName).sendKeys(secondNameOfClient); //Заполняем поле Фамилия
        driver.findElement(placeForAdress).sendKeys(adressOfClient); //Заполняем поле Адрес
        driver.findElement(subwayButton).click(); //Нажимаем на выбор метро

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(subwayStation(subwayOfClient))); //Проверяем, что выпадающий список открылся

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(subwayStation(subwayOfClient))); //Листаем до нужной станции

        driver.findElement(subwayStation(subwayOfClient)).click();//Выбираем нужную станцию
        driver.findElement(placeForPhoneNumber).sendKeys(phoneNumberOfClient); //Заполняем номер телефона
    }

    public void pressNextButton(){
        driver.findElement(nextButton).click();
    }
}
