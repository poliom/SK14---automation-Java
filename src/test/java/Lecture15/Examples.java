package Lecture15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Examples extends TestObject {
    //WebDriver webDriver = getWebDriver();

    @Test
    public void testPromtBox(){
        WebDriver webDriver = getWebDriver();
        webDriver.get("https://demoqa.com/alerts");
        WebElement promptBoxButton = webDriver.findElement(By.id("alertButton"));
        promptBoxButton.click();

        Alert alertBox = webDriver.switchTo().alert();
        alertBox.accept();
        //alertBox.dismiss();
        System.out.println("");
    }

    @Test
    public void testPromtBoxFillText(){
        WebDriver webDriver = getWebDriver();
        webDriver.get("https://demoqa.com/alerts");
        WebElement promptBoxButton = webDriver.findElement(By.id("promtButton"));
        promptBoxButton.click();

        String textForFill = "Test alert Text";

        Alert alertBox = webDriver.switchTo().alert();

        String alertBoxText = alertBox.getText();

        alertBox.sendKeys(textForFill);

        alertBox.accept();

        System.out.println("The Alert box text is: " + alertBoxText);

        WebElement textAfterAllert = webDriver.findElement(By.xpath("//span[@class='text-success']"));
        String textAfterAllertSuccess = textAfterAllert.getText();

        // need to maintain the first part of message
        //Assert.assertEquals(textAfterAllertSuccess,"You entered Test alert Text", "Text is different than the entered text with default message");
        // less maintain
        Assert.assertTrue(textAfterAllertSuccess.contains(textForFill),"Text is different than the entered text");
    }

    @Test
    public void testIFrame(){
        WebDriver webDriver = getWebDriver();
        webDriver.get(("https://demoqa.com/frames"));
        List<WebElement> frames = webDriver.findElements(By.tagName("iframe"));

        System.out.println("Nuber of iFrames is: "+ frames.size());

        webDriver.switchTo().frame("frame1");
        String textOfIFrame = webDriver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(textOfIFrame, "This is a sample page");
    }

    @Test
    public void checkboxDynamicGetAndExpand(){
        WebDriver webDriver = getWebDriver();
        webDriver.get("https://demoqa.com/checkbox");
        WebElement checkboxHomeButton = webDriver.findElement(By.xpath("//*[@for='tree-node-home']/preceding-sibling::button[@title='Toggle']"));

        Wait expWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        expWait.until(ExpectedConditions.elementToBeClickable(checkboxHomeButton));

        checkboxHomeButton.click();
        System.out.println("");

        // this is optional
        // Check the Desktop checkbox
        WebElement nextCheckboxButton = webDriver.findElement(By.xpath("//*[@id='tree-node']//li//span[text()='Desktop']"));
        expWait.until(ExpectedConditions.elementToBeClickable(nextCheckboxButton));
        nextCheckboxButton.click();

        // Expand Desktop
        WebElement checkboxDesktopExp = webDriver.findElement(By.xpath("//span[text()='Desktop']/../preceding-sibling::button[@title='Toggle']"));
        //WebElement checkboxDesktopExp = webDriver.findElement(By.xpath("//li[child::span//span[text()='Desktop']]//button[@title='Toggle']"));
        expWait.until(ExpectedConditions.elementToBeClickable(checkboxDesktopExp));
        checkboxDesktopExp.click();

        WebElement verificationCheckbox = webDriver.findElement(By.xpath("//*[@class='rct-title'][text()='Notes']"));
        Assert.assertTrue(verificationCheckbox.isDisplayed());


    }

}
