package anhtester.com.Bai13_Alert_Popup_iFrame;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {
    @Test
    public void TestAlert01() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("30112022");
        driver.findElement(By.name("submit")).submit();

        Thread.sleep(1000);

        // Khai báo chuyển hướng đến Alert với đối tượng
        Alert alert = driver.switchTo().alert();

        // Get message trên alert
        String alertMessage = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(2000);

        // accept() = nhấn Ok button
        // driver.switchTo().alert().accept(); //Cách 1
        alert.accept(); //Cách 2

        //Nhấn Cancel button
        //alert.dismiss();

        Thread.sleep(1000);
    }

    @Test
    public void TestAlert02() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        //button[normalize-space()='click the button to demonstrate the prompt box']
        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Automation Blog");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("Anh Tester"), "Result không chứa giá trị điền vào ô textbox");

        Thread.sleep(2000);
    }
}
