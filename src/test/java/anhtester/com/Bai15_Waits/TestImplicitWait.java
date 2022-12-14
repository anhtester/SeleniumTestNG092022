package anhtester.com.Bai15_Waits;

import anhtester.com.common.BaseTest_OLD;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestImplicitWait extends BaseTest_OLD {

    @Test
    public void loginCRM() {
        //Chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với thời gian 10 giây
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rise.fairsketch.com/signin");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();
        WebUI.sleep(2);
    }

    @Test
    public void loginHRM() {
        //Chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với thời gian 10 giây
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://app.hrsale.com/");
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();
        WebUI.sleep(2);
    }

}
