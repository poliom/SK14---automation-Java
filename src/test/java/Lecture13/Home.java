package Lecture13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Home {
    public static void main (String[] args) {
        myFirstWebBrowser();
    }

    @Test
    public static void myFirstWebBrowser () {
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.get("http://training.skillo-bg.com/posts/all");
        webDriver.manage().window().maximize();
        WebElement login = webDriver.findElement(By.id("nav-link-login"));
        login.click();
        webDriver.quit();
    }
}




