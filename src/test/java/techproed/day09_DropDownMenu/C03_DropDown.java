package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() throws InterruptedException {
        //programming languages ddm den istediginiz 4 secenegi seciniz
        WebElement diller=driver.findElement(By.xpath("(//select)[6]"));
        Select select=new Select(diller);
        select.selectByIndex(0);
        Thread.sleep(2000);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByIndex(3);
        Thread.sleep(2000);
        select.selectByIndex(4);
        //Eğer sadece seçili olan optionlari yazdırmak istersek
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());
        //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
        System.out.println("**********************************************");
        System.out.println("Seçilen seçeneklerden ilki : "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        //Seçtiğimiz seçeneklerin hepsini kaldıralım
        select.deselectAll();


       ////senKeys() metodu ile istediğimiz bir seçeneği gönderelim
       //diller.sendKeys("C#");

        //visibleText olarak seçim yapacağımız bir metod oluştup programming languages ddm den bir
        //seçenek seçelim
        bekle(3);
        selectVisibleText(diller,"Java");

        //index olarak seçim yapacağımız bir metod oluştup programming languages ddm den bir
        //seçenek seçelim
        bekle(2);
        selectindex(diller,3);

        //value olarak seçim yapacağımız bir metod oluştup programming languages ddm den bir
        //seçenek seçelim
        bekle(2);
        selectValue(diller, "js");
    }
    public void selectVisibleText(WebElement ddm,String text){
        Select select=new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void selectindex(WebElement ddm,int index){
        Select select=new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select=new Select(ddm);
        select.selectByValue(value);
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }
}
