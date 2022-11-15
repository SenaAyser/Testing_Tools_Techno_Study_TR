package Gun06;

import Utility.BaseDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.Assert;

public class _01_CssSelector extends BaseDriver {
    public static void main(String[] args) {

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement txrbtn = driver.findElement(By.cssSelector("input[id='user-message']"));
        txrbtn.sendKeys("Merhaba Selenium");

        WebElement btn = driver.findElement(By.cssSelector("button[onclick='showInput();']"));
        btn.click();

        WebElement msg=driver.findElement(By.cssSelector("span[id='display']"));

        /*if(msg.getText().equals("Merhaba Selenium")){
            System.out.println("Burak benni mutlu eder");
        }
        else System.out.println("Burak beni uzer");*/

        Assert.assertTrue("mesaj bulunmadi",msg.getText().contains("merhaba selenium"));// beklenen expect

        // assertTrue: içindeki değer True mu ? True ise hiç bir şey yapmaz.mesaj vermez
        // değilse beklenen olmamışsa hata mesajı verir.
        // yani genel kural : Hata var ise göster

        driverBekleKapat();
    }
}
