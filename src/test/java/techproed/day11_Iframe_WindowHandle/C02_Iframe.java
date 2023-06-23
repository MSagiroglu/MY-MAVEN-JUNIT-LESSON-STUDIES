package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void est01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        assert driver.findElement(By.xpath("//h3")).getText().contains("Editor");
        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");//id ile geçiş yaptık
        driver.findElement(By.xpath("//p")).clear();
        bekle(2);
        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        driver.findElement(By.xpath("//p")).sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);
        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
    }
}
