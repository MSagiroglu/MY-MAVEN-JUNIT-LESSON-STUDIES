package techproed.day09_DropDownMenu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void test01() {

   //1.http://zero.webappsecurity.com/ Adresine gidin
    driver.get("http://zero.webappsecurity.com/");
   //2.Sign in butonuna basin
        WebElement signIn=driver.findElement(By.xpath("//*[@id=\"signin_button\"]"));
        signIn.click();
   //3.Login kutusuna “username” yazin
   // 4.Password kutusuna “password.” yazin
   //5.Sign in tusuna basin(not: navigate.Back yapınız)
        WebElement logIn=driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        logIn.sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);

   //6.Pay Bills sayfasina gidin
        driver.navigate().back();
        WebElement onlineBanking=driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong"));
        onlineBanking.click();
        bekle(2);
        WebElement payBill=driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]"));
        payBill.click();
   //7.“Purchase Foreign Currency” tusuna basin
        WebElement purhaseForeignCurrency=driver.findElement(By.xpath("//*[@href='#ui-tabs-3']"));
        purhaseForeignCurrency.click();
   //8.“Currency” drop down menusunden Eurozone’u secin
        bekle(2);
        WebElement currency=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(currency);
        select.selectByValue("EUR");
   //9.“amount” kutusuna bir sayi girin
        WebElement amaunt=driver.findElement(By.xpath("//*[@id=\"pc_amount\"]"));
        amaunt.sendKeys("1000");
   //10.“US Dollars” in secilmedigini test edin
        WebElement UsDollars=driver.findElement(By.id("pc_inDollars_true"));
        assert !UsDollars.isSelected();

   //11.“Selected currency” butonunu secin
        WebElement selectedCurrency=driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrency.click();
   //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement calculateCosts=driver.findElement(By.id("pc_calculate_costs"));
        calculateCosts.click();
        WebElement purchaseCash=driver.findElement(By.id("purchase_cash"));
        purchaseCash.click();
   //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement alertContent=driver.findElement(By.id("alert_content"));
        assert alertContent.isDisplayed();

    }


}
