package Gun13;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.idealized.Javascript;

public class _01_Scrollintro extends BaseDriver {

    /*
    Selenium da Sayfayı aşağı kaydırılması gereken durumlar vardır:
    Bunlar , sayfa kaydırıldıkça yüklenen elemanlar için

    Bu işlem javascript executer ile yapılır.Bu interface sayesinde
    sayfa kaydırma işlemi ve javascript komutları çalıştırılabilir
    sayfa üzerinde.
 */

    @Test
    public void Test1(){
        driver.get("https://triplebyte.com/");

        MyFunc.Bekle(2);
        // JavaScript komutlarini calistirmak icin once js degiskeni tanimlandi
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,3000)");  // -> yani yukari
        // (0,3000) -> (x,y) Sayfayi saga x kadar ve asagi y kaydirir
        // 3000 px kadar asagi kaydiracak


        MyFunc.Bekle(2);
        js.executeScript("window.scrollBy(0,-3000)"); //-> yani asa

        // scrollTo : Verilen pixele gider.
        // scrollBy : Verilen kadar daha ileri gider

        MyFunc.Bekle(5);
        driverBekleKapat();
    }
}
