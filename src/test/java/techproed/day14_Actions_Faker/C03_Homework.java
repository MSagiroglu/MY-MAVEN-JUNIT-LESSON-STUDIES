package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Homework extends TestBase {
    @Test
    public void test01() {
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    driver.get("http://webdriveruniversity.com/Actions");
    //2- Hover over  Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement HOMF=driver.findElement(By.xpath("(//*[@class=\"dropbtn\"])[1]"));
        actions.moveToElement(HOMF);

    //3- Link 1" e tiklayin
        WebElement Link1=driver.findElement(By.xpath("(//*[@class=\"list-alert\"])[1]"));
        actions.moveToElement(Link1).click().perform();

    //4- Popup mesajini yazdirin
        System.out.println("Popup mesaji = "+driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
    //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
    // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClickMe=driver.findElement(By.id("double-click"));
        String color=doubleClickMe.getCssValue("background-color");//orange
        System.out.println("color = " + color);
        actions.doubleClick(doubleClickMe).perform();
        WebElement elementEnable = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        String color2=doubleClickMe.getCssValue("background-color");//green
        System.out.println("color2 = " + color2);
        Assert.assertNotEquals(color,color2);
        Assert.assertTrue(elementEnable.isEnabled());


    }
}
