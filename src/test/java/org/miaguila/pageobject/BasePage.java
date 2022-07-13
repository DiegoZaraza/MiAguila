package org.miaguila.pageobject;

import org.apache.log4j.Logger;
import org.miaguila.utilities.PropertiesRead;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    static final Logger log = Logger.getLogger(BasePage.class);
    private static final long TIMEOUT = Long.parseLong(PropertiesRead.readFromFrameworkConfig("TIMEOUT"));
    private static WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void setImplicitlyWait() {
        log.info("Timeout is " + TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e, String msg) {
        log.info(msg);
        e.click();
    }

    public void javaScriptClick(WebElement e, String msg) {
        Actions act = new Actions(driver);
        log.info(msg);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", e);
    }

    public void clearTxt(WebElement e, String msg) {
        log.info(msg);
        e.clear();
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        log.info(msg);
        e.sendKeys(txt);
    }

    public void selectList(WebElement e, String txt, String msg) {
        log.info(msg);
        Select elements = new Select(e);
        elements.selectByVisibleText(txt);
    }

    public void alertClick() {
        Alert al = driver.switchTo().alert();
        // click on OK to accept with accept()
        al.accept();
    }
    public String getAttribute(WebElement e, String attribute) {
        return e.getAttribute(attribute);
    }

    public String getText(WebElement e, String msg) {
        return e.getText();
    }

    public boolean isDisplayed(WebElement e, String msg) {
        return e.isDisplayed();
    }
}
