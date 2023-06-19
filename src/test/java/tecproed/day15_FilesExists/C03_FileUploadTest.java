package tecproed.day15_FilesExists;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tecproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //dosya seç butonuna basalim
        String dosyaYolu="C:\\Users\\Mustafa-PC\\Desktop\\sen.txt";
        WebElement dosyaSec=driver.findElement(By.xpath("//input[@id='file-upload']"));
        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.click();
        bekle(2);

        //
        //"File Uploaded!" textinin goruntulendigini test edelim.
        assert driver.findElement(By.xpath("//h3")).isDisplayed();

    }
}
