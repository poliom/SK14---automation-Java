package Lecture13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Examples {
    public static void main(String[] args) {
        myFirstTestToOpenASite();
    }

    public static void myFirstWebBrowser(){
        ChromeDriver webDriver = new ChromeDriver();
        //FirefoxDriver webDriver = new FirefoxDriver();
        //EdgeDriver webDriver = new EdgeDriver();

        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        webDriver.quit();
    }

    public static void myFirstTestToOpenASite() {
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.get("http://training.skillo-bg.com/posts/all");
        webDriver.manage().window().maximize();
        WebElement login = webDriver.findElement(By.id("nav-link-login"));
        login.click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            System.out.println("The waiting of 1 second if interrupted due to: " + ex);
//        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement username = webDriver.findElement(By.id("defaultLoginFormUsername"));

        username.click();
        username.sendKeys("kn3222");
        WebElement password = webDriver.findElement(By.id("defaultLoginFormPassword"));
        password.click();
        password.sendKeys("passpass");
        WebElement signIn = webDriver.findElement(By.id("sign-in-button"));
        signIn.click();
//        webDriver.quit();
    }
}