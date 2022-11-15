package Gun12;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_IFrame extends BaseDriver {
    @Test
    public void Test(){
/*
   1-driver.get("http://chercher.tech/practice/frames%22); sayfasına gidiniz.
   2-Inputa ülke adı yazınız
   3-CheckBox ı çekleyiniz.
   4-Select in 4.elemanını seçiniz.
 */

        driver.get("https://chercher.tech/practice/frames");
        driver.switchTo().frame(0);  //"frame1" id ve name ve webelement gecisi cok yavas ama index cok hizli
        WebElement input = driver.findElement(By.cssSelector("#topic + input"));
        input.sendKeys("Turkey");

        driver.switchTo().frame(0); // frame1 icindeki ilk frame
        WebElement chjBox = driver.findElement(By.id("a")); //xpath ile // input[@id='a']
        chjBox.click();

        //driver.switchTo().parentFrame(); //frame 1 e gecis
        //driver.switchTo().parentFrame(); //ilk sfya gecis

        driver.switchTo().defaultContent();  // yukaridaki 2 satirin yerine direkt ilk sayfaya gecis

        driver.switchTo().frame(1);   //selectin oldugu frame (frame2), ilk sayfadaki 2. yani index olarak 1 olan frame

        WebElement menu = driver.findElement(By.id("animals"));
        Select ddMenu = new Select(menu);
        ddMenu.deselectByIndex(3);  // 4 nollu eleman secildi: son eleman: ddMenu.getOptions().size()-1

        driverBekleKapat();
    }
}
