package browser;

import org.openqa.selenium.WebDriver;

public class BrowserNavigation {

    private WebDriver driver;

    public BrowserNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public void forward(){
        driver.navigate().forward();
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

}
