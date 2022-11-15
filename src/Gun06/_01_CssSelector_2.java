package Gun06;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class _01_CssSelector_2 extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");


        String mesajim = "Merhaba Selenium";
        WebElement txrbtn = driver.findElement(By.cssSelector("input[id='user-message']"));
        txrbtn.sendKeys(mesajim);

        WebElement btn = driver.findElement(By.cssSelector("button[onclick='showInput();']"));
        btn.click();

        WebElement msg = driver.findElement(By.cssSelector("span[id='display']"));

        /*if(msg.getText().equals("Merhaba Selenium")){
            System.out.println("Burak benni mutlu eder");
        }
        else System.out.println("Burak beni uzer");*/

        Assert.assertTrue(mesajim + "mesaj bulunmadi", msg.getText().contains(mesajim));// beklenen expect

        // assertTrue: içindeki değer True mu ? True ise hiç bir şey yapmaz.mesaj vermez
        // değilse beklenen olmamışsa hata mesajı verir.
        // yani genel kural : Hata var ise göster

        driverBekleKapat();
    }
}
