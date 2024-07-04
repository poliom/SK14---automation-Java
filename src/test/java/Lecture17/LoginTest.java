package Lecture17;

import Lecture17.POM.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestObject {

    @Test
    public void verifyUserCanLoginWithValidCredentials() {

        /*Fake login test case due to the fact that there is no
         Assert that checks the after click on login button
         The login was sucessfull or not not
        needs to be implemented
        */
        final String USERNAME = "gand46346t346yalf1";
        final String PASSWORD = "th3457y4574375egray";

        WebDriver driver = getWebDriver();

        HomePage homePage = new HomePage(driver);

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isLoginFormTitleShown();
        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();
    }

    @Test
    public void verifyUserCanNOTLoginWithINValidCredentials() {

        /*Fake login test case due to the fact that there is no
         Assert that checks the after click on login button
         The login was successful or not not
        needs to be implemented
        */
        final String USERNAME = "gand46346t346yalf1";
        final String PASSWORD = "th3457y4574375egray";

        WebDriver driver = getWebDriver();

        HomePage homePage = new HomePage(driver);

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isLoginFormTitleShown();
        System.out.println("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        System.out.println("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        System.out.println("STEP 7: The user has clicked on login submit button");
        loginPage.clickSubmitButton();
    }


}
