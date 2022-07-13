package org.miaguila.steps;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.miaguila.pageobject.BasePage;
import org.miaguila.pageobject.LoginPage;
import org.miaguila.utilities.PropertiesRead;
import org.miaguila.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("URL");
    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private LoginPage loginPage;
    private Utilities utilities;
    private Faker faker;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        utilities = new Utilities();
        softAssertions = new SoftAssertions();
        faker = new Faker();
        webDriver.manage().window().maximize();
    }

    @Given("Navigate on zapatoca register page")
    public void navigateOnZapatocaRegisterPage() {
        BasePage.setImplicitlyWait();
        webDriver.get(PAGE);
    }


    @When("Insert name of user")
    public void insertNameOfUser() {
        loginPage.setInputName(faker.name().firstName());
    }

    @And("Insert first last name")
    public void insertFirstLastName() {
        loginPage.setInputFirstLastName(faker.name().lastName());
    }

    @And("Insert second last name")
    public void insertSecondLastName() {
        loginPage.setInputSecondLastName(faker.name().lastName());
    }

    @And("Select document")
    public void selectDocument() {
        loginPage.setSelectTypeOfId("Cédula de ciudadanía");
    }

    @And("Insert id number")
    public void insertIdNumber() {
        loginPage.setInputDocumentId(faker.idNumber().valid());
    }

    @And("Insert email")
    public void insertEmail() {
        loginPage.setInputEmail(faker.name().username() + "@gmail.com");
    }

    @And("Insert phone number")
    public void insertPhoneNumber() {
        loginPage.setInputPhoneNumber(faker.phoneNumber().cellPhone());
    }

    @And("Insert password")
    public void insertPassword() {
        loginPage.setInputPassword("Pruebas1234");
    }

    @And("Confirm password")
    public void confirmPassword() {
        loginPage.setInputConfirmPassword("Pruebas1234");
    }

    @And("Accept terms conditions")
    public void acceptTermsConditions() {
        loginPage.setCheckAgreeTerms();
    }

    @And("Click on create account")
    public void clickOnCreateAccount() {
        loginPage.setButtonCreateAccount();
    }

    @And("Click ok on alert message")
    public void clickOkOnAlertMessage() {
        loginPage.setAlert();
    }

    /*@After
    public void end() {
        //softAssertions.assertAll();
        if (webDriver != null) {
            webDriver.quit();
        }
    }*/
}
