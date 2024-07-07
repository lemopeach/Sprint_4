package com.scooter.withinterface.interfaces.todo;

import org.openqa.selenium.By;

public interface ToDo {
    public void doing(By element);

    public void doing (String text, By element);

    public void doing (Boolean setCheckbox, By element);
}
