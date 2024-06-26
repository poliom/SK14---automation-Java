package Lecture14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RegistrationTest
{
    public static final String PASSWORD = "123Abc";
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "getRegistrationData")
    public Object[][] getRegistrationData() {
        return new Object[][]{{"tsveta.v", "123Abc", "tsveta.v"}, //login with username
                {"tsvetav@test.com", "123Abc", "tsveta.v"}, //login with email
        };
    }

    @Test(priority= -1)
    public void testRegistration() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        WebElement signInElement = driver.findElement(By.xpath("//*[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));

        WebElement signUpElement = driver.findElement(By.xpath("//*[text()='Sign up']"));
        wait.until(ExpectedConditions.visibilityOf(signUpElement));

        WebElement userNameField = driver.findElement(By.name("username"));
        String username = new String("tsveta.v");
        userNameField.sendKeys(username);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        String email = new String("tsveta.v@test.com");
        emailField.sendKeys(email);

        WebElement birthDateElement = driver.findElement(By.cssSelector("[formcontrolname='birthDate']"));
        birthDateElement.sendKeys("11223333");

        WebElement passwordField = driver.findElement(By.id("defaultRegisterFormPassword"));
        passwordField.sendKeys(PASSWORD);

        WebElement confirmPasswordField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        confirmPasswordField.sendKeys(PASSWORD);

        WebElement infoField;
        infoField = driver.findElement(By.name("pulic-info"));
        String info = generateRandomAlphabeticString(10, 15);
        infoField.sendKeys(info);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

        String profileLinkText = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-profile"))).getText();
        Assert.assertEquals(profileLinkText, "Profile", "Profile link text is different that expected!");

        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), username));
        Assert.assertEquals(isTextDisplayed, true, "The username is not displayed!");

        WebElement usernameLabel = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h2"))));
        String usernameText = usernameLabel.getText();
        Assert.assertEquals(usernameText, username, "The username is not same as expected.");
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }
}

