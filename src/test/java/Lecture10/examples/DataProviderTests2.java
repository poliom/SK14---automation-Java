package Lecture10.examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests2 {

    @DataProvider(name = "generateValidTestData")
    public Object[][] generateValidTestData() {
        return new Object[][] { {2, 1, 1}, {4, 2 ,2} };
    }
    @DataProvider(name = "generateInvalidTestData")
    public Object[][] generateInvalidTestData() {
        return new Object[][]{ {4, 2, 1}, {9, 5, 3} };
    }

    @Test(dataProvider = "generateValidTestData", groups = "validTests")
    public void testDataPtovider (int a, int b, int expectedDifference) {
    int difference = a - b;
    Assert.assertEquals(expectedDifference, difference);
    }

    @Test(dataProvider = "generateInvalidTestData", groups = "invalidTests")
    public void testDataProvider (int a, int b, int expectedDifference) {
        int difference = a - b;
        Assert.assertNotEquals(expectedDifference, difference);
    }

}