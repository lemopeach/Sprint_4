package com.scooter.withinterface.interfaces.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CheckText implements Check{
    WebDriver driver;

    public CheckText(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void checking(String example, By element) {
        assertEquals(example, driver.findElement(element).getText());
    }

    @Override
    public void checking(By element){
    }
}
