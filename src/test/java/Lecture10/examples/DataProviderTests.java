package Lecture10.examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests {

    @DataProvider(name = "generateValidTestData")
    public Object[][] generateValidTestData() {
        return new Object[][] { {1, 2, 3}, {2, 3 ,5} };
    }
    @DataProvider(name = "generateInvalidTestData")
    public Object[][] generateInvalidTestData() {
        return new Object[][]{ {3, 4, 8}, {4, 5, 10} };
    }

    @Test(dataProvider = "generateValidTestData", groups = "validTests")
    public void testDataPtovider (int a, int b, int expectedSum) {
    int sum = a + b;
    Assert.assertEquals(expectedSum, sum);
    }

    @Test(dataProvider = "generateInvalidTestData", groups = "invalidTests")
    public void testDataProvider (int a, int b, int expectedSum) {
        int sum = a + b;
        Assert.assertNotEquals(expectedSum, sum);
    }

}