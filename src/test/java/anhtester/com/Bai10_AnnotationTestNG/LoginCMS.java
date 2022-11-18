package anhtester.com.Bai10_AnnotationTestNG;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class LoginCMS extends BaseTest {

    @Test(priority = 2, description = "Login CMS Test")
    public void testLoginCMS() throws InterruptedException {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, description = "Check Blog on Anh Tester")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

}
