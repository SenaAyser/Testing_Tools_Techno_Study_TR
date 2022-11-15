package Odevler;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_XPathIleBulma extends BaseDriver {

   /* Aşağıdaki testlerde aranan elamanın kendi id veya name ini kullanmadan SADECE XPATH yardımı ile gerekiyorsa Child ve kardeş yolu ile bularak testleri yapınız.*/

    @Test
    public void Test1(){

        /*
        1) Bu siteye gidin. ->  http://demoqa.com/text-box

        2) Full Name kısmına "Automation" girin.

        3) Email kısmına "Testing@gmail.com" girin.

        4) Current Address kısmına "Testing Current Address" girin.

        5) Permanent Address kısmına "Testing Permanent Address" girin.

        6) Submit butonuna tıklayınız.

        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.

        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.*/

        driver.get("http://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Automation");

        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.sendKeys("Testing@gmail.com");

        WebElement currentAdress = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
        currentAdress.sendKeys("Testing Current Address");

        WebElement permanentAdress = driver.findElement(By.xpath("//textarea[@class='form-control'][@id='permanentAddress']"));
        permanentAdress.sendKeys("Testing Permanent Address");

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();

        WebElement nameC = driver.findElement(By.xpath("(//div[@class='border col-md-12 col-sm-12']/p)[1]"));
        Assert.assertTrue("name gozukmuyor",nameC.getText().contains("Automation"));

        WebElement eMailC = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']/p[@id='email']"));
        Assert.assertTrue("MAIL GOZUKMUYOR",eMailC.getText().contains("Testing"));

        driverBekleKapat();
    }
    @Test
    public void Test2() {

        /*
        1) Bu siteye gidin. -> https://demo.applitools.com/

        2) Username kısmına "ttechno@gmail.com" girin.

        3) Password kısmına "techno123." girin.

        4) "Sign in" buttonunan tıklayınız.

        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.*/

        driver.get("https://demo.applitools.com/");

        WebElement userName = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='username']"));
        userName.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='password']"));
        password.sendKeys("techno123.");

        WebElement signIn = driver.findElement(By.xpath("//a[@id='log-in']"));
        signIn.click();

        WebElement control = driver.findElement(By.xpath("//div[@class='content-w']//h6[@id='tim']"));
        Assert.assertTrue("mesaj gozukmuyor",control.getText().contains("Your nearest branch closes in: 30m 5s"));

        driverBekleKapat();
    }

    @Test
    public void Test3() {

        /*
        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.*/

        driver.get("https://www.snapdeal.com/");

        WebElement input = driver.findElement(By.xpath("//div[@class='topBar  top-bar-homepage  top-freeze-reference-point']//input[@id='inputValEnter']"));
        input.sendKeys("teddy bear");

        WebElement button = driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']//span"));
        button.click();

        WebElement yazi = driver.findElement(By.xpath("(//span[text()=\"We've got 256 results for teddy bear\"])[1]"));

        Assert.assertTrue("Yazi kalibi uygun degil",yazi.isDisplayed());
        driverBekleKapat();
    }

    @Test
    public void Test4() {

        /*
        Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]

        Calculate'e tıklayınız.

        İlk input'a herhangi bir sayı giriniz.

        İkinci input'a herhangi bir sayı giriniz.

        Calculate button'una tıklayınız.

        Sonucu alınız.

        Sonucu yazdırınız.*/

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculate = driver.findElement(By.xpath("//a[@id='calculate']"));
        calculate.click();

        WebElement firstInput = driver.findElement(By.xpath("//input[@id='number1']"));
        firstInput.sendKeys("12");

        WebElement secondInput = driver.findElement(By.xpath("//input[@id='number2']"));
        secondInput.sendKeys("1322");

        WebElement calculateNow = driver.findElement(By.xpath("//form[@action='calculate.php']//input[@id='calculate']"));
        calculateNow.click();

        WebElement answer = driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("answer = " + answer.getText());

        driverBekleKapat();
    }

    @Test
    public void Test5() {

        /*5-

        Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]

        Fake Alerts' tıklayınız.

        Show Alert Box'a tıklayınız.

        Ok'a tıklayınız.

        Alert kapanmalıdır.*/

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlerts = driver.findElement(By.xpath("//a[@id='fakealerttest']"));
        fakeAlerts.click();

        WebElement showAlertBox = driver.findElement(By.xpath("//input[@id='fakealert']"));
        showAlertBox.click();

        WebElement ok = driver.findElement(By.xpath("//button[@id='dialog-ok']"));
        ok.click();

        driverBekleKapat();
    }

    @Test
    public void Test6() {

        /*
        Bu siteye gidiniz.  https://testpages.herokuapp.com/styled/index.html

        Fake Alerts'e tıklayınız.

        Show modal dialog buttonuna tıklayınız.

                Ok'a tıklayınız.

        Alert kapanmalıdır.*/

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlerts = driver.findElement(By.xpath("//a[@id='fakealerttest']"));
        fakeAlerts.click();

        WebElement showModalDialog = driver.findElement(By.xpath("//input[@id='modaldialog']"));
        showModalDialog.click();

        WebElement okey = driver.findElement(By.xpath("//button[@id='dialog-ok']"));
        okey.click();

        driverBekleKapat();
    }
}
