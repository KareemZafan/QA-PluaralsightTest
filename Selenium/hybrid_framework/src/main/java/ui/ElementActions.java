package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ElementActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public ElementActions clickOn(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        return this;
    }

    public ElementActions selectOption(String option, By dropDownLocator) {
        Select select = new Select(driver.findElement(dropDownLocator));
        select.selectByVisibleText(option);
        return this;

    }

    public String getElementText(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).getText();
    }

    public ElementActions clearText(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).clear();
        return this;
    }

    public ElementActions enterText(By locator, String text) {
        clearText(locator);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).sendKeys(text);
        return this;
    }

    public ElementActions dragAndDrop(By sourceLocator, By targetLocator) {
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(sourceLocator)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(targetLocator)));
        actions.dragAndDrop(driver.findElement(sourceLocator), driver.findElement(targetLocator)).perform();
       return this;
    }

    public ElementActions doubleClick(By locator) {
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        actions.doubleClick(driver.findElement(locator)).perform();
      return this;
    }

    public ElementActions scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight");
        return this;
    }

    public ElementActions scroll(int height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("window.scrollBy(0,%d)", height));
       return this;
    }

    public ElementActions scrollUp(int height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("window.scrollBy(0,-%d)", height));
       return this;
    }

    public ElementActions cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return this;
    }

    public ElementActions acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }


}
