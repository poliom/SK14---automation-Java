package lecture10;


import org.testng.annotations.*;

public class TestNGClass {

    @BeforeTest(alwaysRun = true)
    public void myBeforeTest(){
        System.out.println("This is my first Before test");
    }

    @AfterMethod()
    public void myAfterMethod(){
        System.out.println("My after method");
    }

    @Test(groups = "smoke", priority = -1)
    public void myFirstTest(){
        System.out.println("My first test ever");
    }

    @BeforeMethod(alwaysRun = true)
    public void myBeforeMethod(){
        System.out.println("My before method");
    }

    @Test
    public  void mySecondTest(){
        System.out.println("This is a test");
    }
    @AfterTest
    public void myAfterTest(){
        System.out.println("This is my first After test");
    }
}
