package Odevler;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_CssSelectorIleBulma extends BaseDriver {
    /*Aşağıdaki testlerde aranan elamanın kendi id veya name ini kullanmadan SADECE CssSelector yardımı ile gerekiyorsa Child ve kardeş yolu ile bularak testleri yapınız.*/

    @Test
    public void Test1(){
    /*

    1) Bu siteye gidin. ->

    2) Full Name kısmına "Automation" girin.

    3) Email kısmına "Testing@gmail.com" girin.

    4) Current Address kısmına "Testing Current Address" girin.

    5) Permanent Address kısmına "Testing Permanent Address" girin.

    6) Submit butonuna tıklayınız.

    7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.

    8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

 */
        driver.get("http://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.cssSelector("[id='userName']"));
        userName.sendKeys("Automation");

        WebElement eMail = driver.findElement(By.cssSelector("[id='userEmail-wrapper']>div:nth-child(2)>input"));
        eMail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.cssSelector("[id='currentAddress-wrapper']>div:nth-child(2)>textarea"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.cssSelector("[id='permanentAddress-wrapper']>div:nth-child(2)>textarea"));
        permanentAddress.sendKeys("Testing Permanent Address");

        WebElement submit = driver.findElement(By.cssSelector("[id='submit']"));
        submit.click();

        WebElement nameControl = driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']>p:nth-child(1)"));
        Assert.assertTrue("isim dogru degil",nameControl.getText().contains("Automation"));

        WebElement mailControl = driver.findElement(By.cssSelector("[class='border col-md-12 col-sm-12']>p:nth-child(2)"));
        Assert.assertTrue("mail dogru degil",mailControl.getText().contains("Testing"));

    }

    @Test
    public void Test2(){
        /*
        1) Bu siteye gidin. -> https://demo.applitools.com/

        2) Username kısmına "ttechno@gmail.com" girin.

        3) Password kısmına "techno123." girin.

        4) "Sign in" buttonunan tıklayınız.

        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.*/

        driver.get("https://demo.applitools.com/");
        WebElement userName = driver.findElement(By.cssSelector("[id='username']"));
        userName.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("[id='password']"));
        password.sendKeys("techno123.");

        WebElement logIn = driver.findElement(By.cssSelector("[id='log-in']"));
        logIn.click();

    }

    @Test
    public void Test3(){

        /*
        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.*/

        driver.get("");
    }

    @Test
    public void Test4(){
        /*Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]

        Calculate'e tıklayınız.

        İlk input'a herhangi bir sayı giriniz.

        İkinci input'a herhangi bir sayı giriniz.

        Calculate button'una tıklayınız.

        Sonucu alınız.

        Sonucu yazdırınız.*/
    }

    @Test
    public void Test5(){

       /* Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]

        Fake Alerts' tıklayınız.

        Show Alert Box'a tıklayınız.

        Ok'a tıklayınız.

        Alert kapanmalıdır.*/
    }
    @Test
    public void Test6(){

        /*Bu siteye gidiniz.  https://testpages.herokuapp.com/styled/index.html

        Fake Alerts'e tıklayınız.

        Show modal dialog buttonuna tıklayınız.

                Ok'a tıklayınız.

        Alert kapanmalıdır.*/
    }
}
