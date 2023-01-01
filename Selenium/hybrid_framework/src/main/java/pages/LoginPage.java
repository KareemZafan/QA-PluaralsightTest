package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String userName) {
        driver.findElement( By.id( "username" ) ).sendKeys( userName );
    }

    public void enterPassword(String pass) {
        driver.findElement( By.id( "password" ) ).sendKeys( pass );
    }

    public void clickLogin() {
        driver.findElement( By.cssSelector( ".radius" ) ).click();
    }

    public String getLoginState(){
        return driver.findElement( By.id( "flash" ) ).getText();
    }

    public void logOut() {
        driver.findElement( By.cssSelector( "a.radius" ) ).click();
    }
}
