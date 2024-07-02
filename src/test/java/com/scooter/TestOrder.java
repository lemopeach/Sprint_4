package com.scooter;

import com.scooter.constants.OrderButtonPlace;
import com.scooter.pageobjects.HomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestOrder extends BaseTest {

    private final String placeOfButton;
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

    public TestOrder(String placeOfButton, String nameOfClient, String secondNameOfClient, String adressOfClient, String subwayOfClient, String phoneNumberOfClient,
                     String startDateOfClient, String periodOfClient, boolean blackForClient, boolean greyForClient, String commFromClien) {
        this.placeOfButton = placeOfButton;
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
                {OrderButtonPlace.UP, "Юлия", "Глазкова", "ул.Ленина д.1", "Лубянка", "88008008080", "31.08.2025", "двое суток", true, true, "Спасибо!"},
                {OrderButtonPlace.UP, "Евгения", "Максимова", "ул.Ленина д.313", "Кропоткинская", "89638538484", "01.12.2024", "сутки", false, true, "Огромное спасибо!"},
                {OrderButtonPlace.MIDDLE, "Виктор", "Петрович", "пр. Ветеранов д.9", "Павелецкая", "89120000045", "17.09.2026", "шестеро суток", true, false, "Огромнейшее спасибо!"},
                {OrderButtonPlace.MIDDLE, "Василиса", "Голикова", "пр. Культуры", "Румянцево", "89120000045", "20.02.2025", "семеро суток", false, false, "Спасибо-спасибо!"},
        };
    }


    @Test
    public void checkOpenQuestion() {

        new HomePage(driver)
                .makeOrder(placeOfButton)
                .enterDataForOrder(nameOfClient, secondNameOfClient, adressOfClient, subwayOfClient, phoneNumberOfClient)
                .pressNextButton()
                .enterDataForOrder(startDateOfClient, periodOfClient, blackForClient, greyForClient, commFromClient)
                .pressCreateOrderButton()
                .checkSuccessOrder();

    }
}