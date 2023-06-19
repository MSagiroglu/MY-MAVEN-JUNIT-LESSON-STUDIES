package tecproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
            Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
        için;
            Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
        assing ederiz.
        */
        String dosyaYolu="C:/Users/Mustafa-PC/Desktop/Proje.docx";    //Shift+sağ click=yol olarak kopyala
        String dosyaYolu2="C:/Users/Mustafa-PC/Desktop/Proje.docx";    //yukarıdaki ile aynı
        System.out.println(Files.exists(Paths.get(dosyaYolu)));     //-->dosya varsa True,yoksa False döner.
        System.out.println(Files.exists(Paths.get(dosyaYolu2)));   //-->dosya varsa True,yoksa False döner.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test2() {
        String dosyaYolu="C:\\Users\\Mustafa-PC\\Desktop\\Excel-To-Do-List-Template-Checklist_v1.xlsx";    //Shift+sağ click=yol olarak kopyala
        String dosyaYolu2="C:\\Users\\Mustafa-PC\\Desktop\\Excel-To-Do-List-Template-Checklist_v1.xlsx";    //yukarıdaki ile aynı
        System.out.println(Files.exists(Paths.get(dosyaYolu)));     //-->dosya varsa True,yoksa False döner.
        System.out.println(Files.exists(Paths.get(dosyaYolu2)));   //-->dosya varsa True,yoksa False döner.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() {
        String dosyaYolu="C:\\Users\\Mustafa-PC\\Desktop\\video1222236192.mp4";    //Shift+sağ click=yol olarak kopyala
        String dosyaYolu2="C:\\Users\\Mustafa-PC\\Desktop\\video1222236192.mp4";    //yukarıdaki ile aynı
        System.out.println(Files.exists(Paths.get(dosyaYolu)));     //-->dosya varsa True,yoksa False döner.
        System.out.println(Files.exists(Paths.get(dosyaYolu2)));   //-->dosya varsa True,yoksa False döner.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test04() throws InterruptedException {
    /*
        Bir server'da farkli işlerim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz
     */
        //-->Dosya yolumuz : "C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt"
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/Desktop/sen.txt";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try{
            Files.delete(Paths.get(dosyaYolu));//-->Bu sekilde belirtmis oldugumuz dosyayi sileriz
        }catch(IOException e) {
            System.out.println("Dosya Bulunamadi ");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));
        Thread.sleep(3000);
        //Sildiğiniz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
         /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
    yukardaki delete işlemini kullanabiliriz
     */
    }

    @Test
    public void test05() throws InterruptedException, IOException {
        String dosyaYolu="C:\\Users\\Mustafa-PC\\Desktop\\sen.txt";
        File file=new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        Thread.sleep(3);
        file.delete();
    }
}
