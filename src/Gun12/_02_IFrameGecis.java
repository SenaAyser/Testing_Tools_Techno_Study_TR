package Gun12;
/*
   Senaryo :
   https://chercher.tech/practice/frames sitesine gidiniz
   Ekranda gözüken ilk kutucuğa Türkiye yazınız.
   Daha sonra animals dan seçeneklerinden avatar ı seçiniz.
*/

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.driverBekleKapat;

public class _02_IFrameGecis {

    @Test

    public void Test1(){
        driver.get("https://chercher.tech/practice/frames");
        driver.switchTo().frame(0);  //"frame1" id ve name ve webelement gecisi cok yavas ama index cok hizli
        WebElement input = driver.findElement(By.cssSelector("#topic + input"));
        input.sendKeys("Turkey");

        //driver.switchTo().parentFrame(); //1 kademe iceride oldugumdan yine default page e ulasiyor
        driver.switchTo().defaultContent(); // default page yani asil giris sayfasina ulastim ayni sekilde

        //driver.switchTo().defaultContent().switchTo().frame(1); //
        driver.switchTo().frame(1); //ana sfdaki 2. frame(index olarak 1) ulasildi.burasi selectin oldugu yer

        WebElement menu = driver.findElement(By.id("animals"));
        Select ddMenu = new Select(menu);
        ddMenu.selectByVisibleText("Avatar");
        driverBekleKapat();
    }
}
