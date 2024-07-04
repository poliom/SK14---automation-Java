package Lecture16.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class HomePage extends ISkilo {

    // class private consts
    private final String HOMEPAGE_URL = "/posts/all";

    //WebElements => PageFactory
    //Ui MAP
    @FindBy(id = "nav-link-login")
    private WebElement navigationLoginButton;

    //Constructor
    public HomePage(WebDriver driver){
        //Driver which caomes from the father class => ISkilo / AbstractPageClass / CommonPageCLass
        super(driver);

        //PageFactory is being requested in order to init the webElements that will be used
        PageFactory.initElements(driver,this);
    }

    //Navigation methods spec for the page/object
    public void openHomePage(){
       navigateTo(HOMEPAGE_URL);
    }

    //User Interactions
    public void clickOnNavigationBarLoginButton(){
        waitAndClick(navigationLoginButton);
        System.out.println("The user has clicked in home page navigation login button.");
    }

    //Assertions
    public boolean isHomePageURlLoaded(){
        boolean isLoaded = false;

        try {
            wait.until(ExpectedConditions.urlContains("URL"));
            isLoaded =true;
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
       return isLoaded;
    }

    //Other supported methods
    //Getter
    // navigationLoginButtonText


}
