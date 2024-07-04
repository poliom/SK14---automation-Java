package Lecture16;

import Lecture15.TestObject;
import Lecture16.pom.HomePage;
import Lecture16.pom.LoginPage;
import org.testng.annotations.Test;

public class CheckTest extends TestObject {

    @Test
    public void checkTest() throws InterruptedException {

        HomePage homePage = new HomePage(super.getWebDriver());

        //Step 1: the user opens the Iskilo homepage
        System.out.println("Step 1 the user opens the Iskilo homepage");
        homePage.openHomePage();

        //Step 2: The user opens the login page by clicking on homepage navigation button
        System.out.println("Step 2: The user opens the login page by clicking on homepage navigation button");
        homePage.clickOnNavigationBarLoginButton();

        //Step 7: The user has clicked on login form submit button
        System.out.println("Step 7: The user has clicked on login form submit button");
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        loginPage.clickOnLoginSubmitButton();

        Thread.sleep(7777);
    }
}
