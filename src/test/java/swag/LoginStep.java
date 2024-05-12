package swag;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class LoginStep {
    private WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter my username but no password")
    public void i_enter_my_username_but_no_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Ensuring the password field is clear or empty
        driver.findElement(By.id("password")).clear();
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @When("I click the login button without entering credentials")
    public void i_click_the_login_button_without_entering_credentials() {
        // Ensure both username and password fields are clear before clicking the login button
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see a message saying {string}")
    public void i_should_see_a_message_saying(String expectedMessage) {
        String actualMessage = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertTrue("Expected error message not found. Found: " + actualMessage, actualMessage.contains(expectedMessage));
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
