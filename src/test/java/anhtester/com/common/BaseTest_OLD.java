package anhtester.com.common;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest_OLD {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        System.out.println("Start Chrome browser from BaseTest_OLD...");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement với thời gian 10 giây
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Chờ đợi trang load xong (trong 40s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void closeBrowser() {
        WebUI.sleep(2);
        System.out.println("Close browser from BaseTest_OLD...");
        driver.quit();
    }
}
