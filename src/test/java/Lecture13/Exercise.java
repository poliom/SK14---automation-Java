package Lecture13;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Exercise {
    private ChromeDriver webDriver;
//    private FirefoxDriver webDriver;
//    private EdgeDriver webDriver;

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {

        return new Object[][]{{"vidko.v", "123abc", "vidko@test.com", "123abc"}};
    }

    @BeforeMethod
    public void myBrowserSetup(){
        System.out.println("Before");
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        this.webDriver.get("http://training.skillo-bg.com:4200/posts/all");
    }

    @Test
    public void loginTest(){
        System.out.println("login test");
        WebElement login = webDriver.findElement(By.id("nav-link-login"));
        login.click();

        WebElement username = webDriver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys("dbsdhsh");

        WebElement password = webDriver.findElement(By.id("defaultLoginFormPassword"));
        password.sendKeys("sdhshs");

        //WebElement rememberMe = webDriver.findElement((By.xpath("//*[contains(@class, 'remember-me-button')]")));
        WebElement rememberMe = webDriver.findElement((By.xpath("//input[@class='remember-me-button ng-untouched ng-pristine ng-valid']")));
        rememberMe.click();
        //if page is refreshed the StaleElement exception will be present
        //next code is handling this error in simple way
        try {
            rememberMe.click();
        }catch (StaleElementReferenceException ex){
            rememberMe = webDriver.findElement((By.xpath("//input[@class='remember-me-button ng-untouched ng-pristine ng-valid']")));
            rememberMe.click();
        }

        if (rememberMe.isSelected()){
            System.out.println("Remember me is selected");
        }else {
            System.out.println("Remember me is not selected");
        }

        if (rememberMe.isEnabled()){
            System.out.println("Remember me is enabled");
        }else {
            System.out.println("Remember me is not enabled");
        }

        WebElement signIn = webDriver.findElement(By.id("sign-in-button"));
        signIn.click();

        WebElement newPost = webDriver.findElement(By.linkText("New post"));
        Assert.assertTrue(newPost.isDisplayed(), "The 'New post' link is not shown on site");

        Assert.assertFalse(isElementDisplayedByID("nav-link-login"), "The login link is still present");


        By webElementLocator = By.xpath("//*[@id='nav-link-login'");
        Assert.assertFalse(isElementDisplayedBy(webElementLocator), "The login link is still present");
    }

    @Test(dataProvider = "registrationData")
    public void registrationTest(String usernameValue, String passwordValue, String emailValue, String confPasswordValue ){
        System.out.println("registration test");
        WebElement login = webDriver.findElement(By.id("nav-link-login"));
        login.click();

        WebElement registerLink = webDriver.findElement(By.linkText("Register"));
        registerLink.click();

        WebElement username = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys(usernameValue);

        WebElement email = webDriver.findElement(By.xpath("//input[@placeholder='email']"));
        email.sendKeys(emailValue);

        WebElement password = webDriver.findElement(By.name("password"));
        password.sendKeys(passwordValue);

        WebElement confirmPassword = webDriver.findElement(By.id("defaultRegisterPhonePassword"));
        confirmPassword.sendKeys(confPasswordValue);

        WebElement signin = webDriver.findElement(By.xpath("//button[@type='submit']"));
        signin.click();

        WebElement newPost = webDriver.findElement(By.linkText("New post"));
        Assert.assertTrue(newPost.isDisplayed(), "The 'New post' link is not shown on site");
    }

    @AfterMethod
    public void myCloseBrowser(){
        System.out.println("after");
        this.webDriver.quit();
    }

    private boolean isElementDisplayedByID(String webElementId){
        boolean isDisplayed;

        try{
            WebElement element = webDriver.findElement(By.id(webElementId));
            isDisplayed = element.isDisplayed();
        }catch (StaleElementReferenceException ex){
            System.out.println("Stale Element Reference Exception is catch");
            isDisplayed = false;
        }catch (NoSuchElementException ex){
            System.out.println("Element is not present on the page");
            isDisplayed = false;
        }
        return isDisplayed;
    }

    private boolean isElementDisplayedBy(By webElementLocator){
        boolean isDisplayed;

        try{
            WebElement element = webDriver.findElement(webElementLocator);
            isDisplayed = element.isDisplayed();
        }catch (StaleElementReferenceException ex){
            System.out.println("Stale Element Reference Exception is catch");
            isDisplayed = false;
        }catch (NoSuchElementException ex){
            System.out.println("Element is not present on the page");
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
