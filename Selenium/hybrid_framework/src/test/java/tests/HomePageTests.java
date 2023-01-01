package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTests{

    @Test
    public void testHeadlineText(){
        String hText = homePage.getHeadline();
        Assert.assertEquals(hText,"Welcome to the-internet", "headlines are not the same ");
    }

    @Test
    public void testOpenPage(){
        homePage.openPage("Context Menu");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/context_menu"));
    }



}
