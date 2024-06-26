package Lecture15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestObject {
    public static final String TEST_RESOURCES_DIR = "src\\test\\resources\\";
    public static final String DOWNLOAD_DIR = TEST_RESOURCES_DIR.concat("download\\");
    private WebDriver webDriver;
    @BeforeSuite
    protected final void setupTestSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest(){
        this.webDriver = new ChromeDriver(configChromeOptions());
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    protected final void tearDownTest(ITestResult testResult){
        quitDriver();
    }
    @AfterSuite
    public void deleteDownloadFiles() throws IOException{
        //cleanDirectory(DOWNLOAD_DIR);
    }

    private void quitDriver() {
        if (this.webDriver != null){
            this.webDriver.quit();
        }
    }

    protected WebDriver getWebDriver(){
        return webDriver;
    }

    private ChromeOptions configChromeOptions(){
        //Create path and setting for download folder
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",
                System.getProperty("user.dir").concat("\\").concat(DOWNLOAD_DIR));

        ChromeOptions chromeOptions = new ChromeOptions();
        //Set new default download folder
        chromeOptions.setExperimentalOption("prefs", prefs);
        //Force the download to be automatic
        chromeOptions.addArguments("disable-popup-blocking");

        return chromeOptions;
    }

    private void cleanDirectory(String directoryPath) throws IOException{
        File directory = new File(directoryPath);
        Assert.assertTrue(directory.isDirectory(), "Invalid directory!");

        FileUtils.cleanDirectory(directory);
        String[] fileList = directory.list();
        if (fileList != null && fileList.length == 0){
            System.out.printf("All file are deleted in Directory: %s%n", directoryPath);
        }else {
            System.out.printf("Unable to delete the files in Directory: %s%n", directoryPath);
        }
    }
}