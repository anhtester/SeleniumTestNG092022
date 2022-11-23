package anhtester.com.Bai12_ActionsRobot;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionsClass extends BaseTest {

    @Test
    public void testSendKeys() throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Selenium Java").sendKeys(Keys.ENTER).build().perform();

        WebElement titleResult = driver.findElement(By.xpath("//h3[contains(text(),'[Selenium Java] Bài 4: Cài đặt môi trường Selenium')]"));

        Thread.sleep(2000);
        action.click(titleResult).perform(); //Click vào 1 element

        Thread.sleep(2000);
    }

    @Test
    public void testDoubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        //Element cua Header page
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        //Click chuột trái 2 lần vào header page
        action.doubleClick(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void testContextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        //Click chuột phải vào element trên website
        action.contextClick(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);

        //Bắt 1 element bị khuất màn hình
        WebElement element = driver.findElement(By.xpath("//h4[contains(text(),'KHÓA HỌC AUTOMATION TESTING DÀNH CHO BẠN')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển trỏ chuột tới element)
        action.moveToElement(element).build().perform();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath("//h4[contains(text(),'Blog kiến thức Testing')]"));
        action.moveToElement(element2).perform();

        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(2000);
        // Element which needs to drag.
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        // Element on which need to drop.
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(driver);

        // Gọi hàm dragAndDrop giữa Element
        action.dragAndDrop(From, To).perform();

        Thread.sleep(1000);

        //Drag and Drop by Pixel. Đè chuột Kéo và Di chuyển trỏ chuột đến toạ độ xong thả ra
        WebElement from_5000 = driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
        action.dragAndDropBy(from_5000, 168, 50).release().perform();

        Thread.sleep(2000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh").keyUp(Keys.SHIFT).sendKeys(" tester").build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down cuối trang
        action.keyDown(Keys.CONTROL).keyDown(Keys.END).build().perform();
        Thread.sleep(2000);
        // Scroll up đầu trang
        action.keyDown(Keys.CONTROL).keyDown(Keys.HOME).build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(2000);
    }

}
