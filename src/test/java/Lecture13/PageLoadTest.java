package Lecture13;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageLoadTest {
    public static void main () {
        PageLoadTest(); {
        }
    }

    @Test
    private static void PageLoadTest () {
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.get("https://www.google.com/");
        webDriver.manage().window().maximize();
        webDriver.quit();
    }
}
