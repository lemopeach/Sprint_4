package com.scooter;

import com.scooter.constants.DriverTypes;
import com.scooter.constants.PageURL;
import com.scooter.constants.WaitTime;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected Actions action;

    @Before
    public void setUpDriver() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? DriverTypes.FIREFOX : driverType);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitTime.WAITTIME));
        driver.get(PageURL.url);
        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
        action = new Actions(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    private WebDriver getDriver(String driverType) {
        switch (driverType) {
            case DriverTypes.CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case DriverTypes.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }
}
