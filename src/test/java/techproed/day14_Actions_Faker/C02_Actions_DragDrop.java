package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);//iframe e geçiş yaptık
         /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
        /*
        Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */

    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);//iframe e geçiş yaptık
         /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile web elemente mouse ile basılı tuttuk
                moveToElement(drop).//-->Bu method ile basılı tuttğumuz web elementi diğer web elementin üzerine götürdük.
                release().//-->Bu method ile basılı tuttğumuz web elementi serbest bıraktık
                perform();//-->işlemi sonlandırdık


    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);//iframe e geçiş yaptık
         /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(drop.getLocation().x,drop.getLocation().y).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();
    }
}
