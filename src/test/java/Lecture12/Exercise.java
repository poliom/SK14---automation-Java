package Lecture12;

import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise {
    public static void main (String[] args) {
        myFirstWebBrowser();
    }

    public static void myFirstWebBrowser () {
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        webDriver.manage().window().maximize();
        webDriver.close();
    }
}
