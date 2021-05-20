package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageScreen {

    WebDriver driver;
    By tfield_email = By.id("user_email");
    By tfield_password = By.id("user_password");
    By ch_box = By.id("remember_me");
    By btn_signin = By.xpath("//input[@name='next']");
    By loginError = By.xpath("//span[@data-reactid]");

    public LoginPageScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String email) {
        driver.findElement(tfield_email).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(tfield_password).sendKeys(pass);
    }

    public void clickSignIn() {
        driver.findElement(ch_box).click();
        driver.findElement(btn_signin).click();
    }

    public void openPage() {
        driver.navigate().to("https://www.goodreads.com/user/sign_in");
    }

    public void validateLoginSuccess() {
        String mainPageTitle = "Recent updates | Goodreads";
        Assert.assertEquals("Checking Title",mainPageTitle, driver.getTitle());
    }

    public void validateErrorMessage() {
        String errorMessage = "Sorry, that email or password isn't right. You can reset your password.";
        Assert.assertEquals("Checking Error Message",errorMessage, driver.findElement(loginError).getText());
    }

    public void closeWindow() {
        driver.close();
    }
}
