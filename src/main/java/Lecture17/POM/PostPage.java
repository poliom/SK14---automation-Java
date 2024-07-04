package Lecture17.POM;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class PostPage extends ISkillo {

    private final String POST_PAGE_URL = "posts/create";
    @FindBy(css = "img.image-preview")
    private WebElement image;
    @FindBy(css = "input.input-lg")
    private WebElement imageTextElement;
    @FindBy(css = ".file[type='file']")
    private WebElement uploadField;
    @FindBy(name = "caption")
    private WebElement captionElement;
    @FindBy(id = "create-post")
    private WebElement createP0ostButton;

    public PostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isImageVisible() {
        boolean isVisible = false;

        try {
            isVisible = wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
   
             System.out.println("CONFIRMATION # The file is visible.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
             System.out.println("ERROR : The file is not visible");
            isVisible = false;
        }
        return isVisible;
    }

    public String getImageName() {
        String imageName = imageTextElement.getAttribute("placeholder");
         System.out.println("CONFIRMATION # The image name is: " + imageName);
        return imageName;
    }

    public void uploadPicture(File file) {
        uploadField.sendKeys(file.getAbsolutePath());
         System.out.println("CONFIRMATION # The file was successfully uploaded");
    }

    public void providePostCaption(String caption) {
        wait.until(ExpectedConditions.visibilityOf(captionElement));
        captionElement.sendKeys(caption);
         System.out.println("CONFIRMATION # The user has provided caption text :" + caption);
    }

    public void clickCreatePostButton() {
        wait.until(ExpectedConditions.visibilityOf(createP0ostButton));
        createP0ostButton.click();
         System.out.println("CONFIRMATION # The user has clicked on create post button");
    }
}
