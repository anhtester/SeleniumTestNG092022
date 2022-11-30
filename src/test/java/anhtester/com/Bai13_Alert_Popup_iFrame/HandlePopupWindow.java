package anhtester.com.Bai13_Alert_Popup_iFrame;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class HandlePopupWindow extends BaseTest {
    @Test
    public void TestPopup01() throws InterruptedException {
        driver.get("https://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();

        Thread.sleep(2000);
    }

    @Test
    public void TestPopup02() throws InterruptedException {
        driver.get("https://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        // Lưu lại lớp window đầu tiên (màn hình chính) - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Get all new opened tab Window.
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Switch to Child window (tab con)
                driver.switchTo().window(window);
                Thread.sleep(2000);
                System.out.println("Đã chuyển đến lớp Window con");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(1000);
                //Get text trang sau khi Submit
                System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());

                // Closing the Child Window.
                Thread.sleep(2000);
                driver.close();
            }
        }
        // Switching to Parent window (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(2000);
    }

}
