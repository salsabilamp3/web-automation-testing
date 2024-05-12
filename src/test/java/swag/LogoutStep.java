package swag;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class LogoutStep {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am logged in and on the dashboard page")
    public void i_am_logged_in_and_on_the_dashboard_page() {
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // Pastikan kita berada di halaman inventory
        Assert.assertTrue("Not on the inventory page", driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @When("I press the logout button")
    public void i_press_the_logout_button() {
        // Assuming the burger menu button needs to be clicked to access the logout button.
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as necessary.
        
        // Wait for the burger menu button to be clickable and then click it.
        WebElement burgerMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
        burgerMenuButton.click();

        // Wait for the logout link to be visible and clickable before clicking.
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    @Then("I should be navigated back to the login page")
    public void i_should_be_navigated_back_to_the_login_page() {
        Assert.assertTrue("Not navigated to login page", driver.getCurrentUrl().contains("www.saucedemo.com"));
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
