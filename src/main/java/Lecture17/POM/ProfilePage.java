package Lecture17.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class ProfilePage extends ISkillo {
    @FindBy(id = "upload-img")
    private WebElement uploadProfilePic;
    @FindBy(id = "nav-link-profile")
    private WebElement navToProfileButton;
    @FindBy(className = "profile-image-source")
    private WebElement imgSource;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnProfileButton() {
        waitAndClick(navToProfileButton);
    }

    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }

    public int getPostCount() {

        List<WebElement> posts = driver.findElements(By.tagName("app-post"));

        return posts.size();
    }

    public void clickPost(int postIndex) {
        List<WebElement> posts = driver.findElements(By.tagName("app-post"));
        posts.get(postIndex).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public void uploadProfilePic(File file) {
        uploadProfilePic.sendKeys(file.getAbsolutePath());
         System.out.println("CONFIRMATION # The image was successfully uploaded");
    }

    public boolean isProfilePicDisplayed() {
         System.out.println("CONFIRMATION # The Profile pic is displayed");
        wait.until(ExpectedConditions.visibilityOf(imgSource));
        String imgUrl = imgSource.getAttribute("src");
        return imgUrl.contains("https://i.imgur.com");
    }
}
