package tecproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tecproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutExcetion extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

//Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
//Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));//-->max.2 saniye belirttik
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
//visibilityOf() methoduyla görünür olana kadar bekler

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }
    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("yanlis locate"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlisLocate")));
      /*
Yukardaki örnekte max. süreyi doğru vermemize rağmen yanlis locate aldığımız için yine
org.openqa.selenium.TimeoutException hatası alırız. Dolayısıyla bu exception'ı handle edebilmek için
locate'i doğru almalıyız
 */
    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='ch']")));
    /*
    org.openqa.selenium.TimeoutException: yanlış method kullandığımız için bu hatayı aldık
     */

        //checkBox'ın seçili olduğunu doğrulayalım(CheckBox'ı locate etmeliyiz)
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());
    }
}
