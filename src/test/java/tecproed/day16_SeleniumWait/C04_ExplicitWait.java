package tecproed.day16_SeleniumWait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tecproed.utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWait extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
        //Çıkan Alert'ü kapatalım
        alertWait(5);//--> alertin açılması için yaptığım metodu kullandım
        acceptAlert();//-->Çıkan alert'i kabul etme metodunu kullandım
    }
    @Test
    public void test02() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
        //Çıkan Alert'ü kapatalım
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        acceptAlert();//-->Çıkan alert'i kabul etme metodunu kullandım
    }
}
