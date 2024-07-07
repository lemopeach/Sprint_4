package com.scooter.withinterface;

import com.scooter.BaseTest;
import com.scooter.constants.OrderButtonPlace;
import com.scooter.withinterface.interfaces.check.CheckText;
import com.scooter.withinterface.interfaces.check.CheckVisible;
import com.scooter.withinterface.interfaces.support.SupportClose;
import com.scooter.withinterface.interfaces.todo.ToDoClick;
import com.scooter.withinterface.interfaces.todo.ToDoScroll;
import com.scooter.withinterface.interfaces.todo.ToDoSendText;
import com.scooter.withinterface.pageobjects.HomePage;
import com.scooter.withinterface.pageobjects.OrderPage;
import com.scooter.withinterface.pageobjects.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;

@RunWith(Parameterized.class)
public class TestOrder extends BaseTest {

    private final String placeOfButton;
    private final String nameOfButton;
    private final String nameOfClient;
    private final String secondNameOfClient;
    private final String adressOfClient;
    private final String subwayOfClient;
    private final String phoneNumberOfClient;
    private final String startDateOfClient;
    private final String periodOfClient;
    private final boolean blackForClient;
    private final boolean greyForClient;
    private final String commFromClient;

    public TestOrder(String placeOfButton, String nameOfButton, String nameOfClient, String secondNameOfClient, String adressOfClient, String subwayOfClient, String phoneNumberOfClient,
                     String startDateOfClient, String periodOfClient, boolean blackForClient, boolean greyForClient, String commFromClien) {
        this.placeOfButton = placeOfButton;
        this.nameOfButton = nameOfButton;
        this.nameOfClient = nameOfClient;
        this.secondNameOfClient = secondNameOfClient;
        this.adressOfClient = adressOfClient;
        this.subwayOfClient = subwayOfClient;
        this.phoneNumberOfClient = phoneNumberOfClient;
        this.startDateOfClient = startDateOfClient;
        this.periodOfClient = periodOfClient;
        this.blackForClient = blackForClient;
        this.greyForClient = greyForClient;
        this.commFromClient = commFromClien;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {OrderButtonPlace.UP, "Заказать", "Юлия", "Глазкова", "ул.Ленина д.1", "Лубянка", "88008008080", "31.08.2025", "двое суток", true, true, "Спасибо!"},
                {OrderButtonPlace.UP, "Заказать", "Евгения", "Максимова", "ул.Ленина д.313", "Кропоткинская", "89638538484", "01.12.2024", "сутки", false, true, "Огромное спасибо!"},
                {OrderButtonPlace.MIDDLE, "Заказать", "Виктор", "Петрович", "пр. Ветеранов д.9", "Павелецкая", "89120000045", "17.09.2026", "шестеро суток", true, false, "Огромнейшее спасибо!"},
                {OrderButtonPlace.MIDDLE, "Заказать", "Василиса", "Голикова", "пр. Культуры", "Румянцево", "89120000045", "20.02.2025", "семеро суток", false, false, "Спасибо-спасибо!"},
        };
    }


    @Test
    public void checkOpenQuestion() {

        new HomePage(driver,action)
                //Шаг 1
                .setCheck(new CheckVisible(driver))
                .performCheck(HomePage.getLogo())
                //Шаг 2
                .setToDo(new ToDoScroll(driver))
                .performToDo(HomePage.getOrderButton(placeOfButton))
                .performCheck(HomePage.getOrderButton(placeOfButton))
                //Шаг 2: ожидаемый результат
                .setCheck(new CheckText(driver))
                .performCheck(nameOfButton, HomePage.getOrderButton(placeOfButton))
                //Шаг 3
                .setToDo(new ToDoClick(driver))
                .performToDo(HomePage.getOrderButton(placeOfButton))
                //Шаг 3: ожидаемый результат
                .setCheck(new CheckVisible(driver))
                .performCheck(OrderPage.getHeadOfOrderPage())
                //Шаг 4
                .setToDo(new ToDoSendText(driver))
                .performToDo(nameOfClient, OrderPage.getPlaceForName())
                .performToDo(secondNameOfClient, OrderPage.getPlaceForSecondName())
                .performToDo(adressOfClient, OrderPage.getPlaceForAdress())
                //Шаг 5
                .setToDo(new ToDoClick(driver))
                .performToDo(OrderPage.getSubwayButton())
                //Шаг 5: ожидаемый результат
                .performCheck(OrderPage.getSubwayStation(subwayOfClient))
                //Шаг 6
                .setToDo(new ToDoScroll(driver))
                .performToDo(OrderPage.getSubwayStation(subwayOfClient))
                .setToDo(new ToDoClick(driver))
                .performToDo(OrderPage.getSubwayStation(subwayOfClient))
                //Шаг 7
                .setToDo(new ToDoSendText(driver))
                .performToDo(phoneNumberOfClient, OrderPage.getPlaceForPhoneNumber())
                //Шаг 8
                .setToDo(new ToDoClick(driver))
                .performToDo(OrderPage.getNextButton())
                //Шаг 8: ожидаемый результат
                .performCheck(RentPage.getHeaderOfRentPage())
                //Шаг 9
                .setToDo(new ToDoSendText(driver))
                .performToDo(startDateOfClient, RentPage.getStartDate())
                .setSupport(new SupportClose(action))
                .performSupport(Keys.ESCAPE)
                //Шаг 10
                .setToDo(new ToDoClick(driver))
                .performToDo(RentPage.getPeriodOfRent())
                //Шаг 10: ожидаемый результат
                .performCheck(RentPage.getCorrectPeriod(periodOfClient))
                //Шаг 11
                .setToDo(new ToDoScroll(driver))
                .performToDo(RentPage.getCorrectPeriod(periodOfClient))
                .setToDo(new ToDoClick(driver))
                .performToDo(RentPage.getCorrectPeriod(periodOfClient))
                // Шаг 12
                .performToDo(blackForClient, RentPage.getCheckboxBlack())
                .performToDo(greyForClient, RentPage.getCheckboxGrey())
                // Шаг 13
                .setToDo(new ToDoSendText(driver))
                .performToDo(commFromClient, RentPage.getPlaceForComment())
                // Шаг 14
                .setToDo(new ToDoClick(driver))
                .performToDo(RentPage.getCreateOrderButton())
                //Шаг 14: ожидаемый результат
                .performCheck(RentPage.getFloatHeader())
                //Шаг 15
                .performToDo(RentPage.getYesButton())
                //Шаг 15: ожидаемый результат
                .performCheck(RentPage.getFloatLastHeader());
    }
}