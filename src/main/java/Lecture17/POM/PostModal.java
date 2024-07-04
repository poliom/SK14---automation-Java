package Lecture17.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostModal extends ISkillo {
    private final WebElement modalElement;

    public PostModal(WebDriver driver) {
        super(driver);
        this.modalElement = driver.findElement(By.className("post-modal"));
    }

    public boolean isImageVisible() {

        try {
            WebElement image = modalElement.findElement(By.cssSelector(".post-modal-img img"));
            return wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPostUser() {
        WebElement postUser = modalElement.findElement(By.className("post-user"));
        wait.until(ExpectedConditions.visibilityOf(postUser));
        return postUser.getText();
    }

    public void clickOnBinIcon() {
        WebElement deletePostButton = modalElement.findElement(By.cssSelector(".delete-ask"));
        wait.until(ExpectedConditions.visibilityOf(deletePostButton));
        deletePostButton.click();
        waitPageTobeFullLoaded();
    }

    public void confirmDeletingPost() {
        WebElement confirmDeletingPost = modalElement.findElement(By.cssSelector(".delete-confirm"));
        wait.until(ExpectedConditions.visibilityOf(confirmDeletingPost));
        confirmDeletingPost.click();
        waitPageTobeFullLoaded();
    }
}
