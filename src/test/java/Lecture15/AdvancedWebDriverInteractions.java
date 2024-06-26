package Lecture15;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AdvancedWebDriverInteractions {

    WebDriver driver;

    @AfterMethod
    void cleanUp() {
        driver.quit();
    }

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void basicAuth(){
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement text = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations!')]"));
        Assert.assertEquals(text.getText(), "Congratulations! You must have the proper credentials.");

    }

    @Test
    void brokenImages() throws IOException {
        //Images that should be displayed here http://the-internet.herokuapp.com/broken_images
        URL url = new URL("http://the-internet.herokuapp.com/asdf.jpg");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        URL url2 = new URL("http://the-internet.herokuapp.com/hjkl.jpg");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setRequestMethod("GET");

        URL url3 = new URL("http://the-internet.herokuapp.com/img/avatar-blank.jpg");
        HttpURLConnection con3 = (HttpURLConnection) url3.openConnection();
        con3.setRequestMethod("GET");

        Assert.assertEquals(con.getResponseCode(), 404);
        Assert.assertEquals(con2.getResponseCode(), 404);
        Assert.assertEquals(con3.getResponseCode(), 200);

    }

    @Test
    void challengingDom(){
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        WebElement button1 = driver.findElement(By.xpath("//a[@class='button']"));

        button1.click();
        WebElement button2 = driver.findElement(By.xpath("//a[@class='button alert']"));

        button2.click();

        WebElement button3 = driver.findElement(By.xpath("//a[@class='button success']"));

        button3.click();

        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table/thead//th"));
        int tableColumnsCount = columnHeaders.size();
        List<WebElement> cells = driver.findElements(By.xpath("//table/tbody//td"));
        int cellsCount = cells.size();
        int rowsCount = cellsCount / tableColumnsCount;
        String table [][] = new String[rowsCount][tableColumnsCount];
        WebElement tableElements [][] = new WebElement[rowsCount][tableColumnsCount];

        for (int i = 0; i < rowsCount; i ++){
            for (int j = 0; j < tableColumnsCount; j ++){
                String currXPath = String.format("//table/tbody//tr[%s]//td[%s]", i + 1, j + 1);
                table[i][j] = driver.findElement(By.xpath(currXPath)).getText();
                tableElements[i][j] = driver.findElement(By.xpath(currXPath));
            }
        }

    }

    @Test
    void checkboxes(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("(//form/input[@type='checkbox'])[1]"));
        boolean checkbox1State = checkbox1.isSelected();
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.xpath("(//form/input[@type='checkbox'])[2]"));
        boolean checkbox2State = checkbox2.isSelected();
        checkbox2.click();
        Assert.assertEquals(checkbox1State, !checkbox1.isSelected());
        Assert.assertEquals(checkbox2State, !checkbox2.isSelected());

    }

    @Test
        //not working
    void dragAndDrop(){
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement divA = driver.findElement(By.id("column-a"));
        WebElement divB = driver.findElement(By.id("column-b"));

        Actions builder = new Actions(driver);
        //builder.dragAndDrop(divA, divB).perform();
        //Action dragAndDrop = builder.moveToElement(divA).clickAndHold(divA).moveToElement(divB).release(divB).build();
        //dragAndDrop.perform();
        //

    }

    @Test
    void dropdown(){
        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        WebElement firstOption = select.getFirstSelectedOption();
        String selectedOption0 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption0, "Please select an option");
        //select.selectByIndex(0);
        select.selectByVisibleText("Option 2");
        Assert.assertFalse(firstOption.isEnabled());
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 2");

    }

    @Test
    void dynamicControl(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        By checkBoxLoc = By.id("checkbox");
        WebElement checkbox = driver.findElement(checkBoxLoc);
        Assert.assertTrue(checkbox.isDisplayed());
        WebElement removeBtn = driver.findElement(By.xpath("//*[text()='Remove']"));
        removeBtn.click();
        Assert.assertTrue(driver.findElement(By.id("loading")).isDisplayed());
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        Assert.assertFalse(isElementPresent(driver, checkBoxLoc));
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");
        WebElement addBtn = driver.findElement(By.xpath("//*[text()='Add']"));
        Assert.assertTrue(addBtn.isDisplayed());

    }

    @Test
    void dynamicLoadedPageElement(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        By startBtnLoc = By.xpath("//div[@id='start']/button[contains(text(),'Start')]");
        By loadingBarLoc = By.id("loading");
        List<WebElement> loadingBars = driver.findElements(loadingBarLoc);
        Assert.assertTrue(loadingBars.isEmpty());
        WebElement hello = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        Assert.assertFalse(hello.isDisplayed());
        WebElement startBtn = driver.findElement(startBtnLoc);
        startBtn.click();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingBarLoc));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBarLoc));
        Assert.assertTrue(hello.isDisplayed());
        Assert.assertEquals(hello.getText(), "Hello World!");

    }

    @Test
    void dynamicLoadedPageElement2(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        By startBtnLoc = By.xpath("//div[@id='start']/button[contains(text(),'Start')]");
        By helloWorldLoc = By.xpath("//div[@id='finish']/h4");
        By loadingBarLoc = By.id("loading");
        List<WebElement> loadingBars = driver.findElements(loadingBarLoc);
        Assert.assertTrue(loadingBars.isEmpty());
        Assert.assertFalse(isElementPresent(driver, helloWorldLoc));
        WebElement startBtn = driver.findElement(startBtnLoc);
        startBtn.click();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingBarLoc));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBarLoc));
        WebElement hello = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        Assert.assertEquals(hello.getText(), "Hello World!");

    }

    @Test
    void entryAd_ModalWIndowOnEntry(){
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        closeModalIfAppears(driver, "modal");
        driver.navigate();
        closeModalIfAppears(driver, "modal");
        Assert.assertFalse(isModalWindowVisible(driver, "modal"));

    }

    @Test
    void floatingMenu(){
        driver.get("http://the-internet.herokuapp.com/floating_menu");

        WebElement floatingMenuTitle = driver.findElement(By.xpath("//h3[contains(text(), 'Floating Menu')]"));
        Assert.assertTrue(floatingMenuTitle.isDisplayed());
        WebElement menu = driver.findElement(By.id("menu"));
        Assert.assertTrue(menu.isDisplayed());
        WebElement homeMenu = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(homeMenu.isDisplayed());
        WebElement newsMenu = driver.findElement(By.linkText("News"));
        Assert.assertTrue(newsMenu.isDisplayed());
        WebElement contactMenu = driver.findElement(By.linkText("Contact"));
        Assert.assertTrue(contactMenu.isDisplayed());
        WebElement aboutMenu = driver.findElement(By.linkText("About"));
        Assert.assertTrue(aboutMenu.isDisplayed());

        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(homeMenu.isDisplayed());
        Assert.assertTrue(newsMenu.isDisplayed());
        Assert.assertTrue(contactMenu.isDisplayed());
        Assert.assertTrue(aboutMenu.isDisplayed());

        js.executeScript("window.scrollBy(0,-1000)", "");

        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(homeMenu.isDisplayed());
        Assert.assertTrue(newsMenu.isDisplayed());
        Assert.assertTrue(contactMenu.isDisplayed());
        Assert.assertTrue(aboutMenu.isDisplayed());

        js.executeScript("window.scrollBy(0,-1000)", "");

        Assert.assertTrue(menu.isDisplayed());
        Assert.assertTrue(homeMenu.isDisplayed());
        Assert.assertTrue(newsMenu.isDisplayed());
        Assert.assertTrue(contactMenu.isDisplayed());
        Assert.assertTrue(aboutMenu.isDisplayed());

    }

    @Test
    void hovers(){
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement image1 = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));
        WebElement userInfo1Div1 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[1]"));
        WebElement userInfoName1 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[1]/h5"));
        WebElement userInfoProfileLink1 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[1]/a"));

        WebElement image2 = driver.findElement(By.xpath("(//div[@class='figure']/img)[2]"));
        WebElement userInfo1Div2 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[2]"));
        WebElement userInfoName2 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[2]/h5"));
        WebElement userInfoProfileLink2 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[2]/a"));

        WebElement image3 = driver.findElement(By.xpath("(//div[@class='figure']/img)[3]"));
        WebElement userInfo1Div3 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[3]"));
        WebElement userInfoName3 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[3]/h5"));
        WebElement userInfoProfileLink3 = driver.findElement(By.xpath("(//div[@class='figure']/div[@class='figcaption'])[3]/a"));

        Assert.assertFalse(userInfo1Div1.isDisplayed());
        Assert.assertFalse(userInfo1Div2.isDisplayed());
        Assert.assertFalse(userInfo1Div3.isDisplayed());

        Actions builder = new Actions(driver);
        builder.moveToElement(image1).perform();
        Assert.assertTrue(userInfo1Div1.isDisplayed());
        Assert.assertTrue(userInfoName1.isDisplayed());
        Assert.assertTrue(userInfoProfileLink1.isDisplayed());
        Assert.assertEquals(userInfoName1.getText(), "name: user1");
        Assert.assertEquals(userInfoProfileLink1.getText(), "View profile");
        Assert.assertEquals(userInfoProfileLink1.getAttribute("href"), "http://the-internet.herokuapp.com/users/1");

        builder.moveToElement(image2).perform();
        Assert.assertTrue(userInfo1Div2.isDisplayed());
        Assert.assertTrue(userInfoName2.isDisplayed());
        Assert.assertTrue(userInfoProfileLink2.isDisplayed());
        Assert.assertEquals(userInfoName2.getText(), "name: user2");
        Assert.assertEquals(userInfoProfileLink2.getText(), "View profile");
        Assert.assertEquals(userInfoProfileLink2.getAttribute("href"), "http://the-internet.herokuapp.com/users/2");

        builder.moveToElement(image3).perform();
        Assert.assertTrue(userInfo1Div3.isDisplayed());
        Assert.assertTrue(userInfoName3.isDisplayed());
        Assert.assertTrue(userInfoProfileLink3.isDisplayed());
        Assert.assertEquals(userInfoName3.getText(), "name: user3");
        Assert.assertEquals(userInfoProfileLink3.getText(), "View profile");
        Assert.assertEquals(userInfoProfileLink3.getAttribute("href"), "http://the-internet.herokuapp.com/users/3");


    }

    @Test
    void openNewWindow(){
        driver.get("http://the-internet.herokuapp.com/windows");
        String firstWindowHandle = driver.getWindowHandle();
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        // Switch to new window opened
        //for(String winHandle : driver.getWindowHandles()){
        //   driver.switchTo().window(winHandle);
        // }

        List<String> alabala = (List<String>) driver.getWindowHandles();
        driver.switchTo().window(alabala.get(0));

        WebElement newWindowText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        Assert.assertTrue(newWindowText.isDisplayed());


        // Switch back to original browser (first window)
        driver.switchTo().window(firstWindowHandle);
        WebElement openingNewWindowText = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]"));
        Assert.assertTrue(openingNewWindowText.isDisplayed());


    }

    @Test
    void infiniteScroll() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/infinite_scroll");

        WebElement infiniteScrollTitle = driver.findElement(By.xpath("//h3[contains(text(), 'Infinite Scroll')]"));
        List<WebElement> divsAdded = driver.findElements(By.xpath("//div[@class='jscroll-added']"));
        Assert.assertEquals(divsAdded.size(), 1);

        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        Thread.sleep(2000);
        divsAdded = driver.findElements(By.xpath("//div[@class='jscroll-added']"));
        Assert.assertEquals(divsAdded.size(), 2);


        js.executeScript("window.scrollBy(0,-1000)", "");
        Thread.sleep(2000);
        divsAdded = driver.findElements(By.xpath("//div[@class='jscroll-added']"));
        Assert.assertEquals(divsAdded.size(), 2);

    }

    @Test
    void fileDownload(){
        String downloadFilepath = "C:\\Users\\skillo\\Downloads";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(service, options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/download");
        String fileName = "some-file.txt";
        WebElement thePic = driver.findElement(By.linkText(fileName));
        thePic.click();
        if(isStillDownloading((downloadFilepath)) == false){
            boolean fileExists = fileExists(downloadFilepath + "\\" + fileName);
            Assert.assertTrue(fileExists);
        } else{
            Assert.fail("Download stuck");
        }


    }

    @Test
    void iFrames(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textField = driver.findElement(By.xpath("//body[@id='tinymce']//p"));
        textField.clear();
        textField.sendKeys("alabala");
        driver.switchTo().parentFrame();
        WebElement pageHeading = driver.findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertEquals(pageHeading.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    @Test
    void nestedIFrames(){
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
        //driver.switchTo().frame("frame-left");
        WebElement leftFrameBody = driver.findElement(By.xpath("//body"));
        Assert.assertEquals(leftFrameBody.getText(), "LEFT");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrameBody = driver.findElement(By.xpath("//body"));
        Assert.assertEquals(middleFrameBody.getText(), "MIDDLE");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrameBody = driver.findElement(By.xpath("//body"));
        Assert.assertEquals(bottomFrameBody.getText(), "BOTTOM");
    }

    @Test
    void horizontalSlider() {
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        slider.click();
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        WebElement sliderValue = driver.findElement(By.id("range"));
        Assert.assertEquals(sliderValue.getText(), "3.5");
    }

    @Test
    void horizontalSlider2() {
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement sliderValue = driver.findElement(By.id("range"));
        Actions builder = new Actions(driver);
        builder.moveToElement(slider).clickAndHold().dragAndDropBy(sliderValue,-100, 0).perform();
        Assert.assertEquals(sliderValue.getText(), "1.5");
    }

    boolean isElementPresent(WebDriver driver, By locator){
        try {
            WebElement el = driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }

    }

    private void closeModalIfAppears(WebDriver driver, String modalLocator){

        try {
            By modalLoc = By.id(modalLocator);
            Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalLoc));
            WebElement addWindowCloseLink = driver.findElement(By.xpath("//div[@id='modal']//p[text()='Close']"));
            addWindowCloseLink.click();

        } catch (Exception e){

        }
    }

    private boolean isModalWindowVisible(WebDriver driver, String modalLocator){

        try {
            By modalLoc = By.id(modalLocator);
            Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalLoc));
            return true;

        } catch (Exception e){
            return false;
        }
    }

    private boolean fileExists(String filePath){
        File fileToLookFor = new File(filePath);
        boolean exists = fileToLookFor.exists();
        return exists;
    }

    private boolean isStillDownloading(String downloadDirectory){
        boolean stillDownloading = true;
        long startTime  = System.currentTimeMillis();
        long currentTime = 0;
        long maxWaitingTime = 0;
        String fileDownload = downloadDirectory + "\\" + "crdownload";
        File fileToLookFor = new File(fileDownload);
        boolean exists = false;
        while (stillDownloading == true && maxWaitingTime < 3000){
            exists = fileToLookFor.exists();
            currentTime = System.currentTimeMillis();
            maxWaitingTime = currentTime - startTime;

            if(exists == false){
                stillDownloading = false;
            }

        }

        return stillDownloading;
    }
}
