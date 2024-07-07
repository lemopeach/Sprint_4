package com.scooter.withinterface.pageobjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.scooter.withinterface.interfaces.check.Check;
import com.scooter.withinterface.interfaces.support.Support;
import com.scooter.withinterface.interfaces.todo.ToDo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

abstract public class BasePage {
    WebDriver driver;
    Actions action;
    ToDo toDo;
    Check check;
    Support support;

    public BasePage(WebDriver driver, Actions action) {
        this.driver = driver;
        this.action = action;
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage performToDo(By element) {
        toDo.doing(element);
        return this;
    }

    public BasePage performToDo(String text, By element) {
        toDo.doing(text, element);
        return this;
    }

    public BasePage performToDo(Boolean setCheckbox, By element){
        toDo.doing(setCheckbox,element);
        return this;
    }

    public BasePage performCheck(By element) {
        check.checking(element);
        return this;
    }

    public BasePage performCheck(String example, By element) {
        check.checking(example, element);
        return this;
    }

    public BasePage performSupport(Keys key){
        support.toSupportKey(key);
        return this;
    }

    public BasePage setToDo(ToDo toDo) {
        this.toDo = toDo;
        return this;
    }

    public BasePage setCheck(Check check) {
        this.check = check;
        return this;
    }

    public BasePage setSupport(Support support){
        this.support = support;
        return this;
    }

    public Actions getAction(){
        return action;
    }
}
