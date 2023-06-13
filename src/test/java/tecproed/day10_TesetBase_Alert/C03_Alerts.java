package tecproed.day10_TesetBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tecproed.utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("getTextAlert() = " + getTextAlert());
        Assert.assertEquals("You clicked a button",getTextAlert());
        //Ve alert'ü kapatalım
        acceptAlert();
    }

    @Test
    public void test02() {
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[4]")).click();
        //Çıkan alertte iptale basalım.
        dismissAlert();
        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi=driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);
    }

    @Test
    public void test03() {
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.xpath("(//button)[5]")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        bekle(2);
        //çıkan alerte ismimizi girelim
        senKeysAlert("Mustafa");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi=driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Mustafa"));
    }

    @Test
    public void test04() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(5);
        acceptAlert();
    }
}
