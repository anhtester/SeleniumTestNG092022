package anhtester.com.Bai13_Alert_Popup_iFrame;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest {
    @Test
    public void iFrame01() throws InterruptedException {

        driver.get("https://anhtester.com/contact");
        Thread.sleep(9000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());

        //----Switch to content of Messenger--------
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------
        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame();

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        Thread.sleep(2000);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }
}
