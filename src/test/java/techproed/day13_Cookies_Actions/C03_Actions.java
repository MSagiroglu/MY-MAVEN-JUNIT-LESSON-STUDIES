package techproed.day13_Cookies_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://amazon.com");
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountList=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();

        //driver.findElement(By.xpath("(//*[@class='nav-text'])[3]")).click();

        //veya
        WebElement element = driver.findElement(By.xpath("//span[text()='Account']"));
        actions.click(element).perform();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        assert driver.getTitle().contains("Your Account");
    }
}
