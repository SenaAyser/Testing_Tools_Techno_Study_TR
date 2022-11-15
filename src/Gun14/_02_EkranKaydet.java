package Gun14;

import Utility.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class _02_EkranKaydet extends BaseDriver {

    public static void main(String[] args) throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username=driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("123");

        WebElement submit= driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        List<WebElement> errorMesaji = driver.findElements(By.cssSelector("div[role='alert']"));

        if (errorMesaji.size() > 0)
        {
            System.out.println("Login olamadı, Hata mesajı gözüktü");

            LocalDateTime oAn = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss");
            String  oAnSon = oAn.format(formatter);
            System.out.println(oAnSon);

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;//1.Aşama ekran görünütü alma değişkenini tanımladım
            File hafizadakiHali = takesScreenshot.getScreenshotAs(OutputType.FILE);//2.Aşama ekran görüntüsü alındı, şu an hafıda
            String path = "ekranGoruntuleri\\"+oAnSon+".png";
            FileUtils.copyFile(hafizadakiHali,new File(path));



            // TODO : burada her hata da aynı dosyayı yeniliyor ve üzerine yazıyor.
            //        biz istiyoruzki her dosya ayrı olsun yani her kayıt ayrı olsun
            //        bunu nasıl yaparsınız
            //        LocalDateTime alıcaksın bilgileri
            //        YılAyGunSaatDakikaSan -> 2022_10_07_1319_20.png
        }
    }
}
