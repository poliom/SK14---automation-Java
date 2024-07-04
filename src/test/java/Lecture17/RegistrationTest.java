package Lecture17;

import Lecture17.POM.*;
import org.testng.Assert;
import utils.ContentGeneration;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestObject{

    @Test
    public void verifyUserCanRegisterWithValidData() {

        HomePage homePage = new HomePage(super.getWebDriver());

        //Providing a second way to generate random data
        //We are using current date stamp to generate random string
        //How : by getting the time at the moment and append some static user name
        final String USERNAME = ContentGeneration.createUser() ;
        final String EMAIL = ContentGeneration.createEmail();

        System.out.println("THE RANDOM GENERATED USERNAME IS: " + USERNAME);
        System.out.println("THE RANDOM GENERATED EMAIL IS: " + EMAIL);

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has clicked Register");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.clickOnRegistrationLink();

        //Must add new valid data for registration. Email must be under 20 chars.
        System.out.println("STEP 4: The user provides registration data");
        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());
        registrationPage.fullRegistrationInputsAndActions(USERNAME, EMAIL, "123456");

        System.out.println("STEP 4: Verify the user is successfully logged in after registration");
        //THERE IS A NEED MORE VERIICATION TO BE DONE
        //EXAMPLE user profile name matches the provided user for registration
        //
    }

    @Test
    public void verifyUserCanNotRegisterWithINValidData(){

        HomePage homePage = new HomePage(super.getWebDriver());

        //Providing a second way to generate random data
        //We are using current date stamp to generate random string
        //How : by getting the time at the moment and append some static user name
        final String USERNAME = "W" ;
        final String EMAIL = "WRONG";

        System.out.println("THE RANDOM GENERATED USERNAME IS: " + USERNAME);
        System.out.println("THE RANDOM GENERATED EMAIL IS: " + EMAIL);

        System.out.println("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();

        System.out.println("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.clickOnNavigationLoginButton();

        System.out.println("STEP 3: The user has clicked Register");
        LoginPage loginPage = new LoginPage(super.getWebDriver());
        loginPage.clickOnRegistrationLink();

        //Must add new valid data for registration. Email must be under 20 chars.
        System.out.println("STEP 4: The user provides registration data");
        RegistrationPage registrationPage = new RegistrationPage(super.getWebDriver());
        registrationPage.fullRegistrationInputsAndActions(USERNAME, EMAIL, "123456");

        System.out.println("STEP 4: Verify the user is successfully logged in after registration");
        //THERE IS A NEED MORE VERIFICATION TO BE DONE
        //EXAMPLE A Message for wrong email or  wrong username  is shown

    }

    //Providing a 3rd way to generate random data
    //There is other option to generate some random string with this method bellow
    public static String generateRandomString() {

        int length = 3;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }


}
