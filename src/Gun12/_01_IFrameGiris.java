package Gun12;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_IFrameGiris extends BaseDriver {
    @Test
    public void Test(){

        driver.get("https://chercher.tech/practice/frames");
        driver.switchTo().frame(0);  //"frame1" id ve name ve webelement gecisi cok yavas ama index cok hizli
        WebElement input = driver.findElement(By.cssSelector("#topic + input"));
        input.sendKeys("Turkey");

        //su anda frame1 ile gosterilen sayfadayiz, diger frame 2 veya 3 ilk sayfamizdaki
        // locatorlari bulamayiz, cunku Driver su anda frame1 isimli sayfayi DRIVE etmektedir.

        //driver.switchTo().frame(0); -------> icteki frame3 e gecis olur

        //driver.switchTo().parentFrame(); ----------> bir onceki sayfaya geri donerim

        //driver.switchTo().defaultContent();  ----------->hangi sayfada olursan ol ilk sayfaya direkt gecis

          driverBekleKapat();
    }
}
