package Lecture10.examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests4 {

    @DataProvider(name = "generateValidTestData")
    public Object[][] generateValidTestData() {
        return new Object[][] { {2, 1, 2}, {4, 2 , 2} };
    }
    @DataProvider(name = "generateInvalidTestData")
    public Object[][] generateInvalidTestData() {
        return new Object[][]{ {4, 2, 1}, {10, 5, 1} };
    }

    @Test(dataProvider = "generateValidTestData", groups = "validTests")
    public void testDataPtovider (int a, int b, int expectedResult) {
    int result = a / b;
    Assert.assertEquals(expectedResult, result);
    }

    @Test(dataProvider = "generateInvalidTestData", groups = "invalidTests")
    public void testDataProvider (int a, int b, int expectedResult) {
        int result = a / b;
        Assert.assertNotEquals(expectedResult, result);
    }

}