package org.miaguila.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[1]/div/input")
    WebElement inputName;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[1]/div[2]")
    WebElement nameMessageError;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setInputName(String value) {
        clearTxt(inputName, "Clear txt until introduce a new search");
        sendKeys(inputName, value, "Input text for find a product");
    }

    public String getInputName() {
        return getText(inputName, "");
    }

    public String getNameMessageError() {
        return getText(nameMessageError, "");
    }
}
