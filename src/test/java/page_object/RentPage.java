package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {
    public WebDriver driver;

    public Actions action;

    //Заголовок страницы. По нему мы определим, что страница загрузилась
    public By headerOfRentPage = By.className("Order_Header__BZXOb");

    //Поле для ввода даты
    public By startDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Кнопка для выбора периода аренды
    public  By periodOfRent = By.className("Dropdown-control");

    //Чекбокс. Цвет самоката - черный
    public By checkboxBlack = By.id("black");

    //Чекбокс. Цвет самока - серы
    public By checkboxGrey = By.id("grey");

    //Поле комментария
    public By placeForComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать" для создания заказа
    public By createOrderButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']");

    //Заголовок всплывающего окна
    public By floatHeader = By.className("Order_ModalHeader__3FDaJ");

    //Кнопка "Да" вспылвающего окна
    public By yesButton = By.xpath(".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']");

    public By correctPeriod(String Period){
        return By.xpath(".//*[text()='"+Period+"']");
    }

    //Заголовок всплывающего окна об успешном создании заказа
    public By floatLastHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public RentPage(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void enterDataForOrder(String startDateOfClient, String periodOfClient, boolean blackForClient, boolean greyForClient, String commFromClient){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(headerOfRentPage)); //Проверяем, что страница загрузилась

        driver.findElement(startDate).sendKeys(startDateOfClient);//Заполняем поле Дата
        action.sendKeys(Keys.ESCAPE).build().perform();//Нажимаем кнопку esc, чтобы перейти дальше

        driver.findElement(periodOfRent).click(); //Нажимаем на выбор периода

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(correctPeriod(periodOfClient))); //Проверяем, что выпадающий список открылся

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(correctPeriod(periodOfClient))); //Листаем до нужного периода

        driver.findElement(correctPeriod(periodOfClient)).click(); //выбираем нужный период

        if(blackForClient){
            driver.findElement(checkboxBlack).click(); //Устанавливаем черный цвет
        }

        if(greyForClient){
            driver.findElement(checkboxGrey).click(); //Устанавливаем серый цвет
        }

        driver.findElement(placeForComment).sendKeys(commFromClient); //Добавяем коммантарий

    }

    public void pressCreateOrderButton(){
        driver.findElement(createOrderButton).click(); // Нажимаем кнопку "Заказать"

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(floatHeader)); // Проверяем, что всплывающее окно открылось

        driver.findElement(yesButton).click(); //Нажимаем кнопк "Да"
    }

    public void checkSuccessOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(floatLastHeader)); // Проверяем, что окно с подтверждением успеха открылось
    }
}
