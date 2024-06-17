package Lecture12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Examples {
    public static void main(String[] args) {
        dropdownTest();
    }
    public static void myFirstWebBrowser(){
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        webDriver.close();
    }
    public static void workWithWebElements(){
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        //WebElement login = webDriver.findElement(By.id("nav-link-login"));
        WebElement login = webDriver.findElement(By.xpath("//*[@id='nav-link-login']"));
        login.click();
        webDriver.close();
    }
    public static void findEmelentMethods(){
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        WebElement loginElement = webDriver.findElement(By.id("nav-link-login"));
        WebElement homeElement = webDriver.findElement(By.linkText("Home"));
        List<WebElement> postsElements = webDriver.findElements(By.xpath("//*[@class='post-feed-img']"));
        webDriver.close();
    }

    public static void sendKeysAndClear(){
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        //WebElement login = webDriver.findElement(By.id("nav-link-login"));
        WebElement login = webDriver.findElement(By.xpath("//*[@id='nav-link-login']"));
        login.click();
        webDriver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        WebElement usernameField = webDriver.findElement(By.id("defaultLoginFormUsername"));
        usernameField.sendKeys("test");
        usernameField.clear();
        webDriver.close();
    }
    public static void additionalMethods(){
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        //return title of the page as a string
        String titleOfThePage = webDriver.getTitle();
        System.out.println("The title is: " + titleOfThePage);

        WebElement login = webDriver.findElement(By.id("nav-link-login"));
        login.click();
        WebElement rememberMe = webDriver.findElement(By.xpath("//input[@formcontrolname='rememberMe']"));
        rememberMe.click();

        //return true if element is selected(checked)
        System.out.println("Element is selected: " + rememberMe.isSelected());

        WebElement signInButton = webDriver.findElement(By.id("sign-in-button"));
        //return text of the field as a string
        String buttonText = signInButton.getText();
        System.out.println("The text of the element is: " + buttonText);

        //return true if element is displayed on the page
        System.out.println("The element is displayed: " + signInButton.isDisplayed());

        //return true if element is enabled, and you can interact with it
        System.out.println("The element is enabled: " + signInButton.isEnabled());
        webDriver.close();
    }

    public static void dropdownTest(){
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.mobile.bg/pcgi/mobile.cgi");
        webDriver.manage().window().maximize();
        //wait to be visible
        WebElement cookieAccept = webDriver.findElement(By.xpath("//button[@aria-label='Към сайта']"));
        cookieAccept.click();
        //wait to be visible
        WebElement avDbButton = webDriver.findElement((By.xpath("//a[@class='a1']/ico[@class='cat1']")));
        avDbButton.click();
        //wait to be visible
        Select dropdownMarka = new Select(webDriver.findElement(By.name("locat")));
        dropdownMarka.selectByValue("Кюстендил");

        webDriver.quit();
    }
}
