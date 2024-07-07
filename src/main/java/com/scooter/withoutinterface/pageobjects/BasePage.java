package com.scooter.withoutinterface.pageobjects;

import com.scooter.constants.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime.WAITTIME));
    }

    public void scrollPage(By element) { //прокрутка страницы до нужного элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element)); //прокручиваем страницу до желаемого элемента
    }

    public void visibleElement(By element) { //проверяем, что элемент отображен
        ExpectedConditions.visibilityOfElementLocated(element); //проверяем, что логотип отображен на главной странице. Если отображен - страница загрузилась.
    }

    public void waitingVisibleElement (By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
