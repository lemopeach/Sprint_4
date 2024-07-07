package com.scooter.withinterface.interfaces.todo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ToDoScroll implements ToDo {
    WebDriver driver;

    public ToDoScroll(WebDriver driver){
        this.driver = driver;
    }
    @Override
    public void doing(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }

    @Override
    public void doing(String text, By element){
    }

    @Override
    public void doing(Boolean setCheckbox, By element){
    }
}
