package Cuma_Projeleri._Proje_1;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Cuma_Proje_01 extends BaseDriver {

    public static void main(String[] args) {
        driver.navigate().to("https://www.akakce.com/");

        MyFunc.Bekle(1);
        WebElement ha = driver.findElement(By.cssSelector("[id = 'H_rl_v8'] > a"));
        ha.click();

        WebElement isim = driver.findElement(By.xpath("//input[@id='rnufn']"));
        isim.sendKeys("Sedat en dogru karar");

        WebElement soyad = driver.findElement(By.id("rnufs"));
        soyad.sendKeys("MJ");

        WebElement email = driver.findElement(By.name("rnufe1"));
        email.sendKeys("cejar71391@cadolls.com");

        WebElement tEmail = driver.findElement(By.name("rnufe2"));
        tEmail.sendKeys("cejar71391@cadolls.com");

        WebElement sifre = driver.findElement(By.xpath("//input [@id = 'rnufp1']"));
        sifre.sendKeys("T3st1ngTeam*");

        WebElement tSifre = driver.findElement(By.id("rnufp2"));
        tSifre.sendKeys("T3st1ngTeam*");

        WebElement cinsiyet = driver.findElement(By.id("rngf"));
        cinsiyet.click();

        WebElement ilSecim = driver.findElement(By.id("locpr"));
        ilSecim.click();

        WebElement il = driver.findElement(By.cssSelector("[id ='locpr'] > *:nth-child(49)"));
        il.click();

        // 1.Yontem CssSelector ilce secim
/*        WebElement ilceSecim = driver.findElement(By.id("locds"));
        ilceSecim.click();

        WebElement ilce = driver.findElement(By.cssSelector("[id ='locds'] >*:nth-child(8)"));
        ilce.click();*/

        // 2.Yontem (En iyisi) XPath ilce secim
        WebElement secim = driver.findElement(By.xpath("//*[@id ='locds']//child::option[8]"));
        secim.click();

        WebElement gun = driver.findElement(By.xpath("//select[@id='bd']//child::option[6]"));
        gun.click();

        WebElement ay = driver.findElement(By.xpath("//select[@id='bm']//child::option[3]"));
        ay.click();

        WebElement yil = driver.findElement(By.xpath("//select[@id='by']//child::option[2]"));
        yil.click();

        WebElement kabul1 = driver.findElement(By.id("rnufpca"));
        kabul1.click();

        WebElement kabul2 =driver.findElement(By.id("rnufnee"));
        kabul2.click();

        MyFunc.Bekle(1);
        WebElement kabul = driver.findElement(By.id("rfb"));
        kabul.click();

        WebElement p = driver.findElement(By.partialLinkText("Sedat en dogru"));
        p.click();

        WebElement m = driver.findElement(By.partialLinkText("Mesajlarım"));
        m.click();

        driver.navigate().back();
        driver.navigate().back();

        WebElement p1 = driver.findElement(By.partialLinkText("Sedat en dogru"));
        p1.click();

        WebElement hSil = driver.findElement(By.partialLinkText("Hesabımı Sil"));
        hSil.click();

        WebElement hSilSifre = driver.findElement(By.id("p"));
        hSilSifre.sendKeys("T3st1ngTeam*");

        WebElement kabul3 = driver.findElement(By.id("u"));
        kabul3.click();


    }
}
