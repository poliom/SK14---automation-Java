package Lecture16.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ISkilo {

    // 1 Consts
    private final String BASE_URL = "http://training.skillo-bg.com:4200/";

    // 2. UI elements

    // 3. Constructor members
    WebDriver driver;
    WebDriverWait wait;

    //4. Constructor
    public ISkilo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    };

    // 5. Uer actions
    // 5.1. Navigation
    // 5.1.1. Basic navigation
    public void navigateTo(String pageURLsufix) {
        String currentURL = BASE_URL + pageURLsufix;
        driver.get(currentURL);

        waitPageTobeFullLoaded();
    };

    //5.2. User actions
    // 5.3. interactions with web elements
    // 5.3.1. Click Button
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
        System.out.println("The user has clicked on element");

        waitPageTobeFullLoaded();
    };

    // 5.3.2. Type text in input field
    public void typeTextInField(WebElement element, String inputText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(inputText);

        waitPageTobeFullLoaded();
    };

    //7. Support methods
    public void waitPageTobeFullLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
        System.out.println("DOM tree is fully loaded");
    };

    //7. Validations

    public boolean isUrlLoaded(String pageURL) {
        waitPageTobeFullLoaded();

        return wait.until(ExpectedConditions.urlContains(pageURL));
    };

    public String getPlaceholder(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("placeholder");
    };

    public boolean isPlaceholderCorrect(WebElement element, String expectedPlaceholder) {
        try {
            String actualPlaceholder = getPlaceholder(element);
            return expectedPlaceholder.equals(actualPlaceholder);
        } catch (NoSuchElementException e) {
            System.out.println("ERROR! The placeholder for the element is not correct or element is not found.");
            return false;
        }
    };

    public boolean isTitleShown(WebElement element) {
        boolean isTitleShown = false;
        System.out.println(" ACTION @ The user is verifying if the Registration title is shown");
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("CONFIRM # The Registration title is shown to the user");
            isTitleShown = true;
        } catch (NoSuchElementException e) {
            System.out.println("ERROR ! The title is not presented the user is not on Registration page");
        }
        return isTitleShown;
    };
}
