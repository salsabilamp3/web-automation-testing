package swag.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import swag.helper.SwagWebDriverManager;
import swag.pagefactory.LoginPageFactory;
import swag.pagefactory.HomePageFactory;

public class LogoutStep {
    private WebDriver driver;
    private LoginPageFactory loginPage;
    private HomePageFactory homePage;

    @Given("I am logged in and on the dashboard page with {string} username and {string} password")
    public void i_am_logged_in_and_on_the_dashboard_page(String username, String password) {
        driver = SwagWebDriverManager.getWebDriver();
        loginPage = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);

        driver.get("https://www.saucedemo.com/");
        loginPage.login(username, password);

        // Pastikan kita berada di halaman inventory
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @When("I press the logout button")
    public void i_press_the_logout_button() {
        homePage.clickBurgerMenuButton();
        homePage.clickLogoutLink();
    }

    @Then("I should be navigated back to the login page")
    public void i_should_be_navigated_back_to_the_login_page() {
        Assert.assertTrue("Not navigated to login page", driver.getCurrentUrl().contains("www.saucedemo.com"));
    }

    @After
    public void closeBrowser() {
        SwagWebDriverManager.quitWebDriver();
    }
}
