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

public class Examples
{
    public static final String PASSWORD = "123abcD";
    private WebDriver driver;

    /**
     * Setup all browser drivers before the test suite execution
     * This setup will be executed only once for the whole test run
     */
    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    /**
     * Opens a new window in the browser before the execution of each test method
     * Example: If you have 2 methods: method1 & method2. The execution will be:
     * 1. setUpTest + method1
     * 2. setUpTest + method2
     */
    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();

        //Sets timeout to wait for a page to load completely. Works only with get() and navigate().to()
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        /*
        Sets timeout to wait for any element to appear in the DOM tree
        Example:
        If you execute findElement() the driver will be checking for the element to appear in the DOM tree for the duration of 5 seconds
        If element the element is found within the 5 seconds the test execution continues
        Otherwise if the element is not found NoSuchElementException will be thrown
        Important:
        If the element is presented in the DOM tree this doesn't guarantee that the element is visible on the page!
        The implicit wait applies for all elements during the driver's lifecycle
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
    }

    /**
     * After each test closes the current browser window
     * Example: If you have 2 methods: method1 & method2. The execution will be:
     * 1. setUpTest + method1 + tearDownTest
     * 2. setUpTest + method2 + tearDownTest
     */
    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"vidko.v", "123abc", "vidko.v"}, //login with username
                {"vidko@test.com", "123abc", "vidko.v"}, //login with email
        };
    }

    // demo invocationCount = 10
    @Test(dataProvider = "getUsers")
    public void testLoginWithWaits(String user, String password, String name) {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

//        WebElement signInElement = driver.findElement(By.xpath("//*[text()='Sign in']"));
//        wait.until(ExpectedConditions.visibilityOf(signInElement));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Sign in']"))));

        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys(user);

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();


        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        WebDriverWait waitSecond = new WebDriverWait(driver, Duration.ofSeconds(20));

        waitSecond.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        Boolean isTextDisplayed = waitSecond.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed!");

        String userProfileAddress = driver.getCurrentUrl();

        Assert.assertEquals(userProfileAddress, "http://training.skillo-bg.com:4300/users/8335", "The user profile address is not matching the expected");
        Assert.assertEquals(userProfileAddress, "http://training.skillo-bg.com:4300/users/833");
    }


    @Test
    public void testRegistration() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        WebElement signInElement = driver.findElement(By.xpath("//*[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));

        WebElement signUpElement = driver.findElement(By.xpath("//*[text()='Sign up']"));
        wait.until(ExpectedConditions.visibilityOf(signUpElement));

        WebElement userNameField = driver.findElement(By.name("username"));
        String username = generateRandomAlphabeticString(5, 8);
        userNameField.sendKeys(username);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        String email = generateRandomEmail(5, 10);
        emailField.sendKeys(email);

        WebElement birthDateElement = driver.findElement(By.cssSelector("[formcontrolname='birthDate']"));
        birthDateElement.sendKeys("11122003");

        WebElement passwordField = driver.findElement(By.id("defaultRegisterFormPassword"));
        passwordField.sendKeys(PASSWORD);

        WebElement confirmPasswordField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        confirmPasswordField.sendKeys(PASSWORD);

        WebElement infoField = driver.findElement(By.name("pulic-info"));
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

    private String generateRandomEmail(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

}