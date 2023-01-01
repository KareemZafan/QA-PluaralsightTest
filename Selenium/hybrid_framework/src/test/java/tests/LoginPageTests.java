package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTests {


    @BeforeClass
    public void openLink() {
        homePage.openPage( "Form Authentication" );
    }

    @Test
    public void testLoginWithValidCredentials() {
        elementActions.enterText( By.id( "username" ), "tomsmith" );
        elementActions.enterText( By.id( "password" ), "SuperSecretPassword!" );
        elementActions.clickOn( By.className( "radius" ) );
        String text = elementActions.getElementText( By.id( "flash" ) );
        Assert.assertTrue( text.contains( "You logged into a secure area!" ) );
       /* LoginPage lp = new LoginPage( driver );
        lp.enterUsername( "tomsmith" );
        lp.enterPassword( "SuperSecretPassword!" );
        lp.clickLogin();
        Assert.assertTrue( lp.getLoginState().contains( "You logged into a secure area!" ) );*/


    }

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    public void testLoginWithEmptyUsername() {
        elementActions.enterText( By.id( "username" ), "" );
        elementActions.enterText( By.id( "password" ), "SuperSecretPassword!" );
        elementActions.clickOn( By.className( "radius" ) );
        String text = elementActions.getElementText( By.id( "flash" ) );
        Assert.assertTrue( text.contains( "Your username is valid!" ) );
    }

    @Test
    public void testLoginWithEmptyPassword() {
        elementActions.enterText( By.id( "username" ), "tomsmith" );
        elementActions.enterText( By.id( "password" ), "" );
        elementActions.clickOn( By.className( "radius" ) );
        String text = elementActions.getElementText( By.id( "flash" ) );
        Assert.assertTrue( text.contains( "Your password is invalid!" ) );
    }


}
