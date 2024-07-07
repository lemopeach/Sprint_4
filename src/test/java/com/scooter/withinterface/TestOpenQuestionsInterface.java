package com.scooter.withinterface;

import com.scooter.withinterface.pageobjects.HomePage;
import com.scooter.withinterface.pageobjects.BasePage;
import com.scooter.BaseTest;
import com.scooter.withinterface.interfaces.check.CheckText;
import com.scooter.withinterface.interfaces.check.CheckVisible;
import com.scooter.withinterface.interfaces.todo.ToDoClick;
import com.scooter.withinterface.interfaces.todo.ToDoScroll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestOpenQuestionsInterface extends BaseTest {

    private final int number;
    private final String Question;
    private final String Answer;

    public TestOpenQuestionsInterface(int number, String Question, String Answer) {
        this.number = number;
        this.Question = Question;
        this.Answer = Answer;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    @Test
    public void checkOpenQuestion() {
       BasePage h = new HomePage(driver)
               // Шаг 1: ожидаемый результат
               .setCheck(new CheckVisible(driver))
               .performCheck(HomePage.getLogo())
               // Шаг 2:
               .setToDo(new ToDoScroll(driver))
               .performToDo(HomePage.getBlockImportantQuestions())
               // Шаг 2: ожидаемый результат
               .performCheck(HomePage.getBlockImportantQuestions())
               // Шаг 3:
               .setCheck(new CheckText(driver))
               .performCheck(Question, HomePage.getOpenElementButton(number))
               // Шаг 4:
               .setToDo(new ToDoClick(driver))
               .performToDo(HomePage.getOpenElementButton(number))
               //Шаг 4: ожидаемый результат
               .setCheck(new CheckVisible(driver))
               .performCheck(HomePage.getElementName(number))
               .setCheck(new CheckText(driver))
               .performCheck(Answer, HomePage.getElementName(number));
    }
}
