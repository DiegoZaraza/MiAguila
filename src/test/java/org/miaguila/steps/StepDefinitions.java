package org.miaguila.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        utilities = new Utilities();
        softAssertions = new SoftAssertions();
        webDriver.manage().window().maximize();
    }

    @Given("Navigate on zapatoca register page")
    public void navigateOnZapatocaRegisterPage() {
        BasePage.setImplicitlyWait();
        webDriver.get(PAGE);
    }

    @When("Type special or number characters")
    public void typeSpecialOrNumberCharacters() {
        loginPage.setInputName("123219");
    }

    @Then("Validate name field is empty")
    public void validateNameFieldIsEmpty() {
        softAssertions.assertThat(loginPage.getInputName().isEmpty());
    }

    @When("Type most of fifty letters on field")
    public void typeMostOfFiftyLettersOnField() {
        System.out.println(utilities.cadena(51));
        loginPage.setInputName(utilities.cadena(51));
    }

    @Then("Validate show message for quantity of characters")
    public void validateShowMessageForQuantityOfCharacters() {
        softAssertions.assertThat(loginPage.getNameMessageError().equals("- No puedes ingresar más de 50 caracteres"));
    }

    @After
    public void end() {
        //softAssertions.assertAll();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
