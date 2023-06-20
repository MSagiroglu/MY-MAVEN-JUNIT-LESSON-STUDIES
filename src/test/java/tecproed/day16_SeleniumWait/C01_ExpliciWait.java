package tecproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tecproed.utilities.TestBase;

import java.time.Duration;

public class C01_ExpliciWait extends TestBase {
     /*
 SELENIUM WAIT:
         IMPLICITLY WAIT --> Driver'i oluşturduktan sonra sayfadaki tüm webelementlerin etkileşime
         girebilmesi için belirtmiş olduğumuz max. (Duration.ofSecond(20)) süre kadar bekler.
         EXPLICIT WAIT / WebDriverWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
      max. belirtmiş olduğumuz süre kadar default(varsayılan) olarak yarım saniyelik aralıklarla bekler. Örneğin bir
      webelemente tıkladık ve bir alert'ün çıkması zaman alabilir, internet yoğunluğundan yada sayfanın
      performansından kaynaklı bu süreyi normalde kullandığımız Thread.sleep() ile de çözebiliriz fakat testimizi
      her çalıştırdığımızda Thread.sleep() için kaç saniye beklemesi gerektiğini kestiremeyebiliriz. Bu gibi
      durumlar için explicit wait kullanırız.
         EXPLICIT WAIT / FluentWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
      max. belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda (saniye/salise) bekler
  */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        WebElement startButton=driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();
        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));//--> max. 20 saniye bekletecek olan wait objesini oluşturduk.
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));//-->hangi elementin görünür oluncaya kadar bekleyecek olduğunu belirttik
        Assert.assertEquals("Hello World!",helloWorldText.getText());//-->element görükünce 20 sn beklemeden assertion'u yaptı.


    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        WebElement startButton=driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();
        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertEquals("Hello World!",helloWorldText.getText());//-->element görükünce 20 sn beklemeden assertion'u yaptı.


    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        WebElement startButton=driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();
        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());

    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        WebElement startButton=driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();
        //Hello World! Yazının sitede oldugunu test et
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

        //invisibilityOfElementLocated() metodu ile loading web elementi yok olana kadar bekler.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loading\"]")));
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
}
