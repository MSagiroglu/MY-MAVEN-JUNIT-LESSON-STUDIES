package tecproed.day08_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodları static olmak zorundadır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her Class'dan önce BeforeClass Metodu bir kez çalkışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her Class'dan sonra AfterClass Metodu bir kez çalkışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her methoddan önce Before(setUp) metodu birkez çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methoddan sonra After(tearDown) metodu birkez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test01 metodu çalıştı");
    }
    @Test
    public void test02() {
        System.out.println("Test02 metodu çalıştı");
    }
    @Test
    public void test03() {
        System.out.println("Test03 metodu çalıştı");
    }
}
