package Lecture17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static Lecture17.TestObject.DOWNLOAD_DIR;

public class DownloadTest extends TestObject{
    WebDriver driver;


    @Test
    public void DwTest() throws InterruptedException {
        driver = super.getWebDriver();
        driver.get("https://demoqa.com/upload-download");

        //UI Map
        WebElement dwButton = driver.findElement(By.id("downloadButton"));
        //User action
        dwButton.click();

        String fileName = "sampleFile.jpeg";
        File file = new File(DOWNLOAD_DIR.concat(fileName));
        Assert.assertTrue(isFileDownloaded(file), "The file is not downloaded!");
    }

    private boolean isFileDownloaded(File file) throws InterruptedException {
        int waitTime = 3;
        int counter = 0;

        while (counter < waitTime) {
            if (file.exists()) {
                return true;
            }
            Thread.sleep(1000);
            counter++;
        }
        return false;
    }
}
