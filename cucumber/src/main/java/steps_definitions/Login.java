package steps_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("Enter valid username")
    public void enter_valid_username() {
       driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @When("Enter valid password")
    public void enter_valid_password() {
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!", Keys.ENTER);
    }

    @Then("Should successfully logged In")
    public void should_successfully_logged_in() {
     String ribbonText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(ribbonText.contains("You logged into a secure area!"));
    }

    @Then("Green ribbon should appear")
    public void green_ribbon_should_appear() {
      Assert.assertTrue( driver.findElement(By.id("flash")).isDisplayed());
    }

    @When("Enter invalid username {string}")
    public void enter_invalid_username(String userName) {
        driver.findElement(By.id("username")).sendKeys(userName);
    }
    @When("Enter invalid password {string}")
    public void enter_invalid_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password,Keys.ENTER);
    }
    @Then("Should unsuccessfully logged In")
    public void should_unsuccessfully_logged_in() {
        String ribbonText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(ribbonText.contains("invalid!"));
    }
    @Then("Red ribbon should appear")
    public void red_ribbon_should_appear() {
        Assert.assertTrue( driver.findElement(By.id("flash")).isDisplayed());
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
