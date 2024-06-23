package Lecture13;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PageLoadTest2 {

    public static void main () {
        new PageLoadTest2();
    }

    @Test
    public void myPageLoadTest2 () {
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");


        WebElement login = webDriver.findElement(By.id("nav-link-login"));
        login.click();

        WebElement username = webDriver.findElement(By.id("defaultLoginFormUsername"));

        username.click();
        username.sendKeys("dbsdhsh");
        WebElement password = webDriver.findElement(By.id("defaultLoginFormPassword"));
        password.click();
        password.sendKeys("sdhshs");
        WebElement signIn = webDriver.findElement(By.id("sign-in-button"));
        signIn.click();

        By webElementLocator = By.xpath("//*[@id='nav-link-login'");
        Assert.assertFalse(isElementDisplayedBy(webElementLocator), "The login link is still present");

        webDriver.quit();
    }

    private boolean isElementDisplayedBy(By webElementLocator){
        boolean isDisplayed;

        try{
            ChromeDriver webDriver = new ChromeDriver();
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
