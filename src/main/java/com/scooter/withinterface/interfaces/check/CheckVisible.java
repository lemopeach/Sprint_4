package com.scooter.withinterface.interfaces.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckVisible implements Check{
    WebDriver driver;

    public CheckVisible(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void checking(String example, By element){
    }

    @Override
    public void checking(By element){
        ExpectedConditions.visibilityOfElementLocated(element);
    }
}
