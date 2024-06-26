package Lecture15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestWithScoll {
    ChromeDriver webDriver;
    //FirefoxDriver webDriver;
    //EdgeDriver webDriver;
    //SafariDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        webDriver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //webDriver = new FirefoxDriver();
        //WebDriverManager.edgedriver().setup();
        //webDriver = new EdgeDriver();
        //WebDriverManager.safaridriver().setup();
        //webDriver = new SafariDriver();

        webDriver.manage().window().maximize();
    }

    @Test
    public void homePageScrollTest() {
        String homeURL = "http://training.skillo-bg.com:4200/posts/all";
        webDriver.get(homeURL);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,770)", "");

        List<WebElement> numberOfImages = webDriver.findElements(By.xpath("//*[@class='post-feed-img']"));
        int numberOfLoadedImage = numberOfImages.size();
        System.out.println("The number of loaded images is: " + numberOfLoadedImage);
        Assert.assertNotEquals(numberOfLoadedImage,3);
    }

    @Test
    public void homePageScrollUpToSeveralPostsTest() {
        String homeURL = "http://training.skillo-bg.com:4200/posts/all";
        webDriver.get(homeURL);

        List<WebElement> numberOfImages = webDriver.findElements(By.xpath("//*[@class='post-feed-img']"));
        int numberOfLoadedImage = numberOfImages.size();

        int countForStop = 10;

        for (int i=numberOfLoadedImage; i<= 27;){
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0,770)", "");

            List<WebElement> numberOfImagesAfterScroll = webDriver.findElements(By.xpath("//*[@class='post-feed-img']"));
            int numberOfLoadedImagesAfterScroll = numberOfImagesAfterScroll.size();
            System.out.println("The number of loaded images is: " + numberOfLoadedImagesAfterScroll);
            i=numberOfLoadedImagesAfterScroll;
            if (countForStop ==0){
                System.out.println("We scroll N time and we don`t need the needed posts");
                break;
            }
            countForStop--;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        webDriver.quit();
    }
}