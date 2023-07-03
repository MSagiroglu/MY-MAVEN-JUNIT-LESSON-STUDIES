package techproed.day21_Excel_JSExecuter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {


    @Test
    public void readExcell() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1).toString());

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        System.out.println(workbook.getSheet("Sheet1").getRow(2).getCell(0).toString());
        Assert.assertTrue(workbook.getSheet("Sheet1").getRow(2).getCell(0).toString().equals("France"));
        Assert.assertEquals("France",workbook.getSheet("Sheet1").getRow(2).getCell(0).toString());

        //Kullanılan satır sayısın bulun
        int satırSayısı=workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("satırSayısı = " + satırSayısı);
        //getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.Index 1 den başlar

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Sayfadaki satır sayısı = " + workbook.getSheet("Sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki satır sayısını verir ve index 0(sıfır) dan başlar




        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test02() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map <String,String> ulkeBaskent=new LinkedHashMap<>();
        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            String ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir=workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");

        }
        System.out.println(ulkeBaskent);
    }

    @Test
    public void test03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map <String,String> ulkeBaskent=new LinkedHashMap<>();
        for (int i = 0; i <workbook.getSheet("Sheet1").getLastRowNum()+1 ; i++) {
            if (workbook.getSheet("Sheet1").getRow(i)!=null){//-->Atırlar boş değilse bu işlemleri ekle
                String ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
                String sehir=workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
                ulkeBaskent.put(ulke,sehir+"\n");
            }


        }
        System.out.println(ulkeBaskent);
    }

    @Test
    public void readExcel() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("satir3sutun1 = " + satir3sutun1);
        Assert.assertEquals("France", satir3sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanilan satirsayisi " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOT:getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir.
        //Index 1'den baslar

        //sAYFADAKI satir sayisini yazdiriniz
        System.out.println("Sayfadaki satir sayisi " + workbook.getSheet("Sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki son satirin sira numarasini verir ve index 0'dan baslar


        Iterator<Row> rowIterator = workbook.getSheet("Sheet1").iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.iterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.println(cell + "\t");
            }

        }
    }
}
