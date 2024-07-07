package com.scooter.withinterface.interfaces.support;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class SupportClose implements Support{
    public Actions action;

    public SupportClose(Actions action) {
        this.action = action;
    }

    @Override
    public void toSupportKey (Keys key){
        action.sendKeys(key).build().perform();
    }
}
