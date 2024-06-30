package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomePage {

    public WebDriver driver;
    // Логотип, размещенный в заголовке страницы
    public By logo = By.xpath(".//div[@class='Header_Logo__23yGT']");

    // Блок "Вопросы о важном"
    public By blockImportantQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text() = 'Вопросы о важном']");

    //Кнопка для раскрытия вложенного текста у элемента c вопросом
    public By openElementButton(int numOfQuestion){
        return By.id("accordion__heading-"+numOfQuestion);
    }

    // Блок с отображаемым ответом при нажатии кнопки
    public By elementName(int numOfQuestion){
        return By.id("accordion__panel-"+numOfQuestion);
   }

    //Кнопка "Заказать" вверху и внизу страницы (в зависимости от входных параметров)
    public By orderButton(String placeOfButton){
        String xpathOfButton; ;
        if (placeOfButton.equals("middle")){
            xpathOfButton = ".//button[contains(@*,'Button_Button__ra12g Button_Middle__1CSJM')]";
        }
        else {
            xpathOfButton = ".//button[@Class='Button_Button__ra12g']";
        }
        return By.xpath(xpathOfButton);
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)) //проверяем, что логотип отображен на главной странице. Если отображен - страница загрузилась.
                .until(ExpectedConditions.visibilityOfElementLocated(logo));
    }

    public void checkPresenceOfBlock() {
        openPage(); // проверяем, что страница загрузилась
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(blockImportantQuestions)); // прокручиваем страницу до блока "Вопросы о важном"
    }

    public void checkElements(int numOfQuestion, String question, String answer) {

        assertEquals(question,driver.findElement(openElementButton(numOfQuestion)).getText()); // проверяем, что у N элемента вопрос, который мы проверяем
        driver.findElement(openElementButton(numOfQuestion)).click(); //нажимаем на этот вопрос
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(elementName(numOfQuestion))); // проверяем, что ответ на вопрос отображен
        assertEquals(answer,driver.findElement(elementName(numOfQuestion)).getText()); //проверяем, что в ответе корректный текст
    }

    public void makeOrder(String placeOfButton){
        openPage(); //проверяем, что страница загрузилась
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButton(placeOfButton))); //прокручиваем страницу до кнопки "Заказать"
        assertEquals("Заказать",driver.findElement(orderButton(placeOfButton)).getText()); //проверяем, что кнопка действительно называется "Заказать"
        driver.findElement(orderButton(placeOfButton)).click(); //нажимаем на кнопку "Заказать"
    }
}
