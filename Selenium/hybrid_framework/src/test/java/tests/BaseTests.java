package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import ui.ElementActions;

import java.io.File;
import java.io.IOException;


public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ElementActions elementActions;
    protected WebDriverWait wait ;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,100);
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        elementActions = new ElementActions(driver,wait);
    }


    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File(System.getProperty("user.dir")+"/screenshots/"+ result.getName() + ".png"));
        }
    }


    @AfterSuite
    public void tearDown() {
       driver.quit();
    }

}
