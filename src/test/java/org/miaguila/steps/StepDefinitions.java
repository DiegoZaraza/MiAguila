package org.miaguila.steps;

import com.github.dockerjava.core.command.LogContainerCmdImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.miaguila.pageobject.BasePage;
import org.miaguila.pageobject.LoginPage;
import org.miaguila.utilities.PropertiesRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("URL");
    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private LoginPage loginPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
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

    @When("Type most of fifty letter on field")
    public void typeMostOfLetterOnField() {
        loginPage.setInputName();
    }

    @Then("Validate show message for quantity of characters")
    public void validateShowMessageForQuantityOfCharacters() {
    }
}
