package StepDefinitions;

import io.cucumber.java.en.*;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageScenarios {
    WebDriver driver;
    LoginPageScreen loginPage;

    @Given("^I am in the login page$")
    public void iAmInTheLoginPage() {
        setupDriver();
        loginPage = new LoginPageScreen(driver);
        loginPage.openPage();
        System.out.println("The login page is loaded");
    }

    @When("^The login credentials \"([^\"]*)\" and \"([^\"]*)\" are used$")
    public void theLoginCredentialsAndAreUsed(String user, String pass) {
        loginPage.setUsername(user);
        loginPage.setPassword(pass);
        loginPage.clickSignIn();
        System.out.println(user + " and " + pass + " are used");
    }

    @Then("^I am in the primary page$")
    public void loginIsASuccess() {
        System.out.println("login is a success");
        loginPage.validateLoginSuccess();
        System.out.println("The primary page is loaded");
        loginPage.closeWindow();
        System.out.println("Window is closed. End of Test");
    }

    @Then("^An error massage is displayed$")
    public void anErrorMassageIsDisplayed() {
        loginPage.validateErrorMessage();
        System.out.println("Error Message is Displayed");
        loginPage.closeWindow();
        System.out.println("Window is closed. End of Test");
    }

    public void setupDriver() {
        String projectDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectDir+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}

