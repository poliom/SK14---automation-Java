package Lecture16.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ISkilo {

    private final String LOGINPAGE_URL = "users/login";

    @FindBy(id = "sign-in-button")
    private WebElement loginFormSubmitButton;

    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void openLoginPage(){
        navigateTo(LOGINPAGE_URL);
    }

    public void clickOnLoginSubmitButton() {
       waitAndClick(loginFormSubmitButton);
    }


}
