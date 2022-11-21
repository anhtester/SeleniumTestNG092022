package anhtester.com.Bai11_Assertions;

import anhtester.com.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssertions extends BaseTest {

    @Test(priority = 1)
    public void TestAssertEquals() {

        driver.get("https://anhtester.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester - Automation";

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle, "Tiêu đề trang chưa đúng.");

        System.out.println("Hello Automation class");
    }

    @Test(priority = 2)
    public void TestAssertTrue() {

        driver.get("https://anhtester.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester 123";

        System.out.println("*** Checking For The Title ***");

        Assert.assertTrue(actualTitle.contains(expectedTitle), "Tiêu đề không chứa " + expectedTitle);
        System.out.println("Làm gì đó...");

//        if(actualTitle.equals("Anh Tester 123") == true){
//            System.out.println("Làm gì đó...");
//            System.out.println("Làm gì đó...");
//            System.out.println("Làm gì đó...");
//            System.out.println("Làm gì đó...");
//        }

        //System.out.println(actualTitle);
    }

}
