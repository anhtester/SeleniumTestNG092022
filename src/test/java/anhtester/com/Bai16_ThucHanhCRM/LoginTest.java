package anhtester.com.Bai16_ThucHanhCRM;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithoutEmailAndPassword() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //Verify 2 message Email và Password required hiển thị
        //Verify 2 message hiển thị đúng câu từ

        SoftAssert softAssert = new SoftAssert();

        //Viết hàm kiểm tra Element tồn tại trong DOM
        boolean emailRequired = WebUI.checkElementExist(driver, "//form/div[1]"); //Message Email required
        boolean passwordRequired = WebUI.checkElementExist(driver, "//form/div[2]/ABC"); //Message Password required
        System.out.println(emailRequired);
        System.out.println(passwordRequired);
        softAssert.assertTrue(emailRequired, "Message Email required no exist.");
        softAssert.assertTrue(passwordRequired, "Message Password required no exist.");

        //Kiểm tra Element hiển thị trên UI
        boolean messageEmailVisible = driver.findElement(By.xpath("//form/div[1]")).isEnabled(); //Message Email enable
        boolean messagePassVisible = driver.findElement(By.xpath("//form/div[2]")).isEnabled(); //Message Password enable
        System.out.println(messageEmailVisible);
        System.out.println(messagePassVisible);
        softAssert.assertTrue(messageEmailVisible, "Message Email no displays.");
        softAssert.assertTrue(messagePassVisible, "Message Password no displays.");

        //Kiểm tra Text cả Message
        String textForMessageEmailRequired = driver.findElement(By.xpath("//form/div[1]")).getText(); //get text of message email
        String textForMessagePassRequired = driver.findElement(By.xpath("//form/div[2]")).getText(); //get text of message password
        System.out.println(textForMessageEmailRequired);
        System.out.println(textForMessagePassRequired);
        softAssert.assertEquals(textForMessageEmailRequired, "The Password field is required. 123", "The text on message Email not match.");
        softAssert.assertEquals(textForMessagePassRequired, "The Email Address field is required.", "The text on message Password not match.");

        softAssert.assertAll();

    }
}
