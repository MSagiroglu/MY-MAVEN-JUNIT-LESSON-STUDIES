package techproed.day21_Excel_JSExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_Homework_1 {
    @Test
    public void test01() throws IOException {

      // ODEV2
      // Yeni bir test method olusturalim writeExcelTest()
      //
      // Adimlari takip ederek 1.satira kadar gidelim
        String filePath="src/test/java/techproed/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
        // 5.hucreye yeni bir cell olusturalim

      // Olusturdugumuz hucreye "Nufus" yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
      // 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
      // 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
      // 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");
      // Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(filePath);
        workbook.write(fos);
      // Dosyayi kapatalim
        fos.close();
        workbook.close();



    }
    }
