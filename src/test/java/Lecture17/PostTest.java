package Lecture17;

import Lecture17.POM.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class PostTest extends TestObject{
    @DataProvider(name = "PostTestDataProvider")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\uploads\\testUpload.jpg");
        String caption = "Testing create post caption";

        return new Object[][]{{
                "testingDemos", "testing",
                "testingDemos", postPicture, caption},
        };
    };

    @Test(dataProvider = "PostTestDataProvider")
    public void verifyUserCanCreateNewPostAndDeleteIt(String user, String password, String username, File file, String caption) {

        final String HOME_PAGE_URL = "posts/all";
        final String LOGIN_PAGE_URL = "users/login";

        HomePage homePage = new HomePage(super.getWebDriver());

        System.out.println("STEP 1: Open Skillo website home page");
        homePage.openHomePage();
        homePage.isUrlLoaded(HOME_PAGE_URL);

        System.out.println(" STEP 2: Click on Login button");
        homePage.clickOnNavigationLoginButton();

        System.out.println(" STEP 3: Is URL loaded");
        homePage.isUrlLoaded(LOGIN_PAGE_URL);
        System.out.println(" STEP 4: Log in with correct credentials");

        //Starting to work with login page - init login page
        LoginPage loginPage = new LoginPage(super.getWebDriver());

        // represents one code line = 17 code lines
        loginPage.loginWithUserAndPassword(user, password);


        System.out.println(" STEP 5: Waiting for New Post button to be visible");
        homePage.isNewPostButtonToShown();

        System.out.println(" STEP 6: Click on New Post button");

        homePage.clickOnNewPostButton();
        System.out.println(" STEP 7: Upload new picture");

        //Post feature actions
        PostPage postPage = new PostPage(super.getWebDriver());
        postPage.uploadPicture(file);

        System.out.println(" STEP 8: Checking if the image is visible after upload");
        Assert.assertTrue(postPage.isImageVisible(), "The image is visible!");
        System.out.println(" STEP 9: Checking if the image name is correct");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is correct");
        System.out.println(" STEP 10: Provide caption for the new image");
        postPage.providePostCaption(caption);
        System.out.println(" STEP 11: Click on Create Button to create the new post");
        postPage.clickCreatePostButton();
        System.out.println(" STEP 12: Checking if the post count is correct");

        ProfilePage profilePage = new ProfilePage(super.getWebDriver());

        //***************************************
        //The second run the test case will fail
        //*************************************
        int expectedPostCount = 1;
        int actualPostCount = profilePage.getPostCount();

        Assert.assertEquals(
                actualPostCount,
                expectedPostCount,
                "The number of Posts is incorrect!");

        System.out.println(" Step 13: Clicking on the first post");
        profilePage.clickPost(0);

        //Iframe / PostModal / ShadowDom
        PostModal postModal = new PostModal(super.getWebDriver());
        System.out.println(" STEP 14: Verifying that the image and Username are visible");
        Assert.assertTrue(postModal.isImageVisible(), "The image is visible!");
        Assert.assertEquals(postModal.getPostUser(), username);


        //***************************************
        //is it a good practice to name the test case that will create only post
        //but not adding info that will delete post as well ?
        //*************************************
        System.out.println(" STEP 15: Deleting the new post so this test can be repeated");
        postModal.clickOnBinIcon();
        postModal.confirmDeletingPost();
    }
}
