package tecproed.day07_MavenJUnit;

import org.junit.*;

public class C02_BeforeAfter {

        /*
        -Notasyonlara sahip methodlar oluşturabilmek için mouse+sağ tik + generate
        yaparak After methodu için tearDown'u seçeriz.

        - before metodu için setup'ı seçeriz.

        - test etme metodu için test'ı seçeriz

        - JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.

        - Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal
        olarak belirtmemiz gerekir

         */
    @After
    public void tearDown() throws Exception {
        System.out.println("After =Her test methodundan sonra bir kez çalıştırılır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before =Her test methodundan önce bir kez çalıştırılır");
    }

    @Test
    public void Test1() {
        System.out.println("Test1 Metodu Çalıştı");
    }

    @Test
    public void Test2() {
        System.out.println("Test2 Metodu Çalıştı");
    }

    @Test
    public void Test3() {
        System.out.println("Test3 Metodu Çalıştı");
    }
}
