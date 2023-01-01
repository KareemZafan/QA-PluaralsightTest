package pages_tests;

import browser.BrowserNavigation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests {

    private WebDriver driver;
    private HomePage homePage;
    private BrowserNavigation br;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        br = new BrowserNavigation(driver);
    }

    @BeforeMethod
    public void openHomePage(){
        driver.get("https://the-internet.herokuapp.com/");
    }


    @Test
    public void testHeading(){
        Assert.assertEquals(homePage.getHeadline(),"Welcome to the-internet");
    }


    @Test
    public void testFooter(){

        Assert.assertEquals(homePage.getFooterText(),"Powered by Elemental Selenium");
    }

    @Test
    public void testOpenedPage(){
        homePage.openPage("Basic Auth");
        Alert al = driver.switchTo().alert();
        Assert.assertTrue(al.getText().contains("sign in"));

    }





    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
