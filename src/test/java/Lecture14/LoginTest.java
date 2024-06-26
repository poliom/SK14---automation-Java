package Lecture14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest () {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
    }

    @AfterMethod
    protected final void tearDownTest () {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "getRegistrationData")
    public Object[][] getRegistrationData () {
        return new Object[][]{{"tsveta.v", "123Abc", "tsveta.v"}, //login with username
                {"tsveta.v@test.com", "123Abc", "tsveta.v"}, //login with email
        };
    }
    @BeforeTest
    @Test(priority =-1)
    public void testRegistration() {
    }

    @Test(dataProvider = "getRegistrationData")
    public void testLoginWithWaits (String user, String password, String name) {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Sign in']"))));

        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys(user);

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        WebDriverWait waitSecond = new WebDriverWait(driver, Duration.ofSeconds(25));

        waitSecond.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        Boolean isTextDisplayed = waitSecond.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed!");

        String userProfileAddress = driver.getCurrentUrl();

        Assert.assertEquals(userProfileAddress, "http://training.skillo-bg.com:4300/users/8376", "The user profile address is not matching the expected");
    }
}