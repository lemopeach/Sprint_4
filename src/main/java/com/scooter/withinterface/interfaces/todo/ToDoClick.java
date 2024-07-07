package com.scooter.withinterface.interfaces.todo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToDoClick implements ToDo {

    WebDriver driver;

    public ToDoClick(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void doing(By element) {
        driver.findElement(element).click();
    }

    @Override
    public void doing(String text, By element){
    }

    @Override
    public void doing(Boolean setCheckbox, By element){
        if (setCheckbox){
            driver.findElement(element).click();
        }
    }
}
