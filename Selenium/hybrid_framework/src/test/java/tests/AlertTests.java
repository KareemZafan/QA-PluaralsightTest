package tests;

import listeners.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends BaseTests {

    @BeforeClass
    public void openLink() {
        homePage.openPage("JavaScript Alerts");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testClickingOnOk() {
        String text =
                elementActions.clickOn(By.xpath("//button[text()='Click for JS Confirm']")).acceptAlert().getElementText(By.id("result"));

        Assert.assertEquals(text, "You clicked: Ok");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testClickingOnCancel() {
        String text = elementActions.clickOn(By.xpath("//button[text()='Click for JS Confirm']")).cancelAlert().getElementText(By.id("result"));
        Assert.assertEquals(text, "You clicked: Cancel");
    }

    @Test
    public void testAlertText() {

        String alertText = elementActions.clickOn(By.xpath("//button[text()='Click for JS Confirm']")).getAlertText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        elementActions.cancelAlert();
    }


}
