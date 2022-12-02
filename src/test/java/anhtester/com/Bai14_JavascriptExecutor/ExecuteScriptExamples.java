package anhtester.com.Bai14_JavascriptExecutor;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExecuteScriptExamples extends BaseTest {

    @Test
    public void testScript01() {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");

        //Khai báo và khởi tạo gi trị cho đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Điền giá trị vào input và click
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);", driver.findElement(By.xpath("//input[@id='email']")), "customer@example.com");
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);", driver.findElement(By.xpath("//input[@id='password']")), "123456");
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[normalize-space()='Login']")));

        WebUI.sleep(2);
        WebElement buttonUpgradePackage = driver.findElement(By.xpath("//a[normalize-space()='Upgrade Package']"));

        //Scroll to Element
        //true là bên trên, false là bên dưới
        js.executeScript("arguments[0].scrollIntoView(false);", buttonUpgradePackage);

        WebUI.sleep(2);
    }

    @Test
    public void testScript02() {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");

        //Khai báo và khởi tạo gi trị cho đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebUI.sleep(1);
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        //Get Text của element
        String innerText = js.executeScript("return arguments[0].innerText", driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']"))).toString();
        System.out.println(innerText);

        //Kiểm tra element có edit được hay không
        boolean result = (boolean) js.executeScript("return arguments[0].isContentEditable", driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")));
        System.out.println(result);

        //Get height and width of browser
        System.out.println(js.executeScript("return window.innerHeight;").toString());
        System.out.println(js.executeScript("return window.innerWidth;").toString());

        //Highlight element trên web
        //red là đỏ, blue là xanh,...
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")));
        js.executeScript("arguments[0].style.border='3px solid blue'", driver.findElement(By.xpath("//input[@id='email']")));

        WebUI.sleep(1);

        //CHỤP MÀN HÌNH - lưu vào thư mục Screenshots
        //Take Screenshot với driver hiện tại
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Gọi hàm capture screenshot getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
        //Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
        File theDir = new File("Screenshots" + File.separator);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        try {
            FileHandler.copy(source, new File("Screenshots" + File.separator + "screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot taken");

        WebUI.sleep(2);

    }

}
