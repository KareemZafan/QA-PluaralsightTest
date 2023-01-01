package browser_actions;

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

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    /**
     * You can add all method that related to browser actions here
     */

}
