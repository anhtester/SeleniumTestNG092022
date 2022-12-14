package anhtester.com.Bai15_Waits;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExplicitWait extends BaseTest {

    @Test
    public void addBrandCMS() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //Khai báo WebDriverWait = Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Chờ đợi menu Brand đến khi sẵn sàng hiển thị để có thể thao tác được
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));

        WebUI.waitForElementClickable(driver, By.xpath("//span[normalize-space()='Brand']"), 5);

        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();

        String headerAddNewBrand = driver.findElement(By.xpath("//div[@class='card-header']/h5")).getText();
        System.out.println(headerAddNewBrand);
        Assert.assertEquals(headerAddNewBrand, "Add New Brand");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Demo brand1", Keys.ENTER);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[2]")));

        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr/td[2]"), 2);

        String brandName = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
        System.out.println(brandName);
        Assert.assertEquals(brandName, "Demo brand1");
    }


}
