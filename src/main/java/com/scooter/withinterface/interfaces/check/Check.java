package com.scooter.withinterface.interfaces.check;

import org.openqa.selenium.By;

public interface Check {

    public void checking(By element);

    public void checking(String example, By element);
}
