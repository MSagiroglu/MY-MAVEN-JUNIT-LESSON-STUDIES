package techproed.day21_Excel_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_Homework_1 extends TestBase {
    @Test
    public void test01() {
        /*
    sayfaya gidin cerezi kapatin
    https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE
     */
        driver.get("https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");
        WebElement cerez=driver.findElement(By.xpath("class=\"button button--accept-all wb-button hydrated\""));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0]",cerez);
    }
}
