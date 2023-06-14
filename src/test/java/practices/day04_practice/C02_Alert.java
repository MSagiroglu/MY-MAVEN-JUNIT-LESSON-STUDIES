package practices.day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import practices.utilities.TestBase;

public class C02_Alert extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("53920");
        //submit butonuna tıklayın
        bekle(2);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //cıkan alert mesajını yazdırın
        System.out.println("alert mesajı = " + driver.switchTo().alert().getText());
        //alerti kabul edin
        bekle(2);
        driver.switchTo().alert().accept();
        //cıkan 2. alert mesajını yazdırın
        System.out.println("2. alert mesajı = " + driver.switchTo().alert().getText());
        //cıkan 2. alerti kabul edin
        bekle(3);
        driver.switchTo().alert().accept();
    }
}
