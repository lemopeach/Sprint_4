package com.scooter.withinterface.interfaces.todo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ToDoSendText implements ToDo {
        WebDriver driver;

        public ToDoSendText(WebDriver driver){
            this.driver = driver;
        }

        @Override
        public void doing(By element) {
        }

        @Override
        public void doing(String text, By element){
            driver.findElement(element).sendKeys(text);
        }

        @Override
        public void doing(Boolean sectCheckbox, By element){
        }
    }
