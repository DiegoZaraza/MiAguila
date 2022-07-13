package org.miaguila.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[1]/div/input")
    WebElement inputName;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[2]/div/input")
    WebElement inputFirstLastName;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[3]/div/input")
    WebElement inputSecondLastName;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[4]/div/select")
    WebElement selectTypeOfId;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[5]/div/input")
    WebElement inputDocumentId;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[6]/div[1]/input")
    WebElement inputEmail;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[7]/div/input")
    WebElement inputPhoneNumber;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[8]/div/input")
    WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[9]/div/input")
    WebElement inputConfirmPassword;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/label/input")
    WebElement checkAgreeTerms;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div[3]/div[2]/div/button")
    WebElement buttonCreateAccount;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setInputName(String value) {
        clearTxt(inputName, "Clear txt until introduce a new search");
        sendKeys(inputName, value, "Input text for find a product");
    }

    public void setInputFirstLastName(String value){
        clearTxt(inputFirstLastName, "");
        sendKeys(inputFirstLastName, value, "");
    }

    public void setInputSecondLastName(String value) {
        clearTxt(inputSecondLastName, "");
        sendKeys(inputSecondLastName, value, "");
    }

    public void setSelectTypeOfId(String value) {
        selectList(selectTypeOfId, value, "");
    }

    public void setInputDocumentId(String value) {
        clearTxt(inputDocumentId, "");
        sendKeys(inputDocumentId, value, "");
    }

    public void setInputEmail(String value) {
        clearTxt(inputEmail, "");
        sendKeys(inputEmail, value, "");
    }

    public void setInputPhoneNumber(String value) {
        clearTxt(inputPhoneNumber, "");
        sendKeys(inputPhoneNumber, value, "");
    }

    public void setInputPassword(String value) {
        clearTxt(inputPassword, "");
        sendKeys(inputPassword, value, "");
    }

    public void setInputConfirmPassword(String value) {
        clearTxt(inputConfirmPassword, "");
        sendKeys(inputConfirmPassword, value, "");
    }

    public void setCheckAgreeTerms() {
        javaScriptClick(checkAgreeTerms, "");
    }

    public void setButtonCreateAccount() {
        javaScriptClick(buttonCreateAccount, "");
    }

    public void setAlert() {
        alertClick();
    }
}
