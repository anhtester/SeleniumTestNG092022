package anhtester.com.Bai16_ThucHanhCRM;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManageCustomers extends BaseTest {

    @BeforeMethod
    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    private String CUSTOMER_NAME = "VNG Game";
    private String WEBSITE = "https://vnggames.com/";

    @Test
    public void addCustomer() {
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(CUSTOMER_NAME);

        driver.findElement(By.id("vat")).sendKeys("10");
        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");
        driver.findElement(By.id("website")).sendKeys(WEBSITE);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        driver.findElement(By.id("address")).sendKeys("Viet Nam");
        driver.findElement(By.id("city")).sendKeys("Can Tho");
        driver.findElement(By.id("state")).sendKeys("Can Tho");
        driver.findElement(By.id("zip")).sendKeys("92000");
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        WebUI.waitForPageLoaded(driver);

        String getCustomerNameInDetail = driver.findElement(By.xpath("//input[@id='company']")).getAttribute("value");
        System.out.println("Customer Name in Detail: " + getCustomerNameInDetail);
        Assert.assertEquals(getCustomerNameInDetail, CUSTOMER_NAME, "FAILED. Customer Name not match.");

        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        String getCustomerNameOnTable = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
        System.out.println("Customer Name on Table: " + getCustomerNameOnTable);
        Assert.assertEquals(getCustomerNameOnTable, CUSTOMER_NAME, "FAILED. Customer Name on Table not match.");

    }

}
