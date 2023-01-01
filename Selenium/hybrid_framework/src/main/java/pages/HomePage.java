package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String pageLink){
        driver.findElement(By.linkText(pageLink)).click();
    }

    public String getHeadline(){
       return driver.findElement(By.tagName("h1")).getText();
    }

    public String getFooterText(){
        return driver.findElement(By.cssSelector(".large-4 div")).getText();
    }

}
