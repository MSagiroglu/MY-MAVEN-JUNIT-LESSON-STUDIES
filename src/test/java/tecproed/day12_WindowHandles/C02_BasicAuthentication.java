package tecproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tecproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {

    //Aşağıdaki bilgileri kullanarak authentication yapınız:
    //Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //admin:adnin yani Username:password başa yazarsak giriş yapılır.
        //3 veri girişi isteseydi 1:2:3 şeklinde yapacaktık URL' den önce.
        bekle(3);
    //Username: admin
    //Password: admin
    //Başarılı girişten sonra  doğrulayın.
        assert driver.findElement(By.xpath("//p")).isDisplayed();

    //Başarılı girişten sonra Congratulations! yazısının çıktığını doğrulayın.
        assert driver.findElement(By.xpath("//p")).getText().contains("Congratulations!");
        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();
        //Başlığın Elemental Selenium olduğunu doğrulayın
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());
        //DropDown menu den Java seçelim
        WebElement ddm=driver.findElement(By.xpath("//select[@class='dropdown-language']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Java");



    }
}
