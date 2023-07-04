package techproed.day21_Excel_JSExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_Homework_1 {
     /*

         */

    @Test
    public void test01() throws IOException {
       // ODEV1
       // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu="src/test/java/techproed/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String firstRowSecondCell=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("firstRowSecondCell = " + firstRowSecondCell);
        // 2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String capitalOfAfgan=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",capitalOfAfgan);
       // Satir sayisini bulalim
        int rowNum=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("rowNum = " + rowNum);
        // Fiziki olarak kullanilan satir sayisini bulun
        rowNum=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("PhysicalNumberOfRows = " + rowNum);
        // Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String,String> countryAndCapital=new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {

                String country=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String capital=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
                countryAndCapital.put(country,capital+"\n");


        }
        System.out.println(countryAndCapital);


    }
    public void excell(String filePath) throws IOException {
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
    }
}
