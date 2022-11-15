package Gun04.Odev;

/*1-

/*

    1) Bu siteye gidin. ->  http://demoqa.com/text-box

    2) Full Name kısmına "Automation" girin.

    3) Email kısmına "Testing@gmail.com" girin.

    4) Current Address kısmına "Testing Current Address" girin.

    5) Permanent Address kısmına "Testing Permanent Address" girin.

    6) Submit butonuna tıklayınız.

    7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.

    8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.


2-
        1) Bu siteye gidin. -> https://demo.applitools.com/

        2) Username kısmına "ttechno@gmail.com" girin.

        3) Password kısmına "techno123." girin.

        4) "Sign in" buttonunan tıklayınız.

        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.



        3-
        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.


        4-

        Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]

        Calculate'e tıklayınız.

        İlk input'a herhangi bir sayı giriniz.

        İkinci input'a herhangi bir sayı giriniz.

        Calculate button'una tıklayınız.

        Sonucu alınız.

        Sonucu yazdırınız.




        5-

        Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]

        Fake Alerts' tıklayınız.

        Show Alert Box'a tıklayınız.

        Ok'a tıklayınız.

        Alert kapanmalıdır.




        6-

        Bu siteye gidiniz.  https://testpages.herokuapp.com/styled/index.html

        Fake Alerts'e tıklayınız.

        Show modal dialog buttonuna tıklayınız.

        Ok'a tıklayınız.

        Alert kapanmalıdır.
*/

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.module.FindException;
import java.util.List;

public class Odev {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions opt = new ChromeOptions();

        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        WebDriver driver = new ChromeDriver(opt);


        /********************************1.Kisim*******************************************/

        driver.get("http://demoqa.com/text-box");


        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Automation");

        WebElement userMail = driver.findElement(By.id("userEmail"));
        userMail.sendKeys("Testing@gmail.com");

        WebElement userAddress = driver.findElement(By.id("currentAddress"));
        userAddress.sendKeys("Testing Current Address");

        WebElement userPermAdress = driver.findElement(By.id("permanentAddress"));
        userPermAdress.sendKeys("Testing Permanent Address");

        MyFunc.Bekle(2);

        WebElement click = driver.findElement(By.id("submit"));
        click.click();

        WebElement name = driver.findElement(By.className("mb-1"));
        System.out.println(name.getText());
        if (name.getText().equals("Name:Automation")) {
            System.out.println("Name bulunuyor");
        } else {
            System.out.println("Name bulunamadi");
        }

        WebElement mail = driver.findElement(By.id("email"));
        System.out.println(mail.getText());
        if (mail.getText().equals("Email:Testing@gmail.com")) {
            System.out.println("email bulundu");
        } else {
            System.out.println("email bulunamadı");
        }


        System.out.println("*******************");

        /********************************2.Kisim*******************************************/


        driver.get("https://demo.applitools.com/");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("techno123.");

        WebElement rememberMeButton = driver.findElement(By.className("form-check-input"));
        rememberMeButton.click();

        WebElement singIn = driver.findElement(By.id("log-in"));
        singIn.click();

        WebElement yazi = driver.findElement(By.id("time"));
        System.out.println(yazi.getText());
        if (yazi.getText().equals("Your nearest branch closes in: 30m 5s")) {
            System.out.println("Yazi dogru yazilmiş");
        } else {
            System.out.println("Yazi dogru yazilmamis");
        }

        System.out.println("*******************");

        MyFunc.Bekle(2);


        /********************************3.Kisim*******************************************/

        /*1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.*/

        driver.get("https://www.snapdeal.com/");
        WebElement aramaKelimesi = driver.findElement(By.id("inputValEnter"));
        aramaKelimesi.sendKeys("teddy bear");

        WebElement searchButton = driver.findElement(By.className("searchTextSpan"));
        searchButton.click();


        WebElement toplamSayiYazisi = driver.findElement(By.className("nnn"));
        String sayiliHali, sayisizHali;
        int ilkBosluk, ikinciBosluk, ucuncuBosluk;

        sayiliHali = toplamSayiYazisi.getText();
        // We've got 262 results for teddy bear

        ilkBosluk = sayiliHali.indexOf(" ");
        ikinciBosluk = sayiliHali.indexOf(" ", ilkBosluk + 1);
        ucuncuBosluk = sayiliHali.indexOf(" ", ikinciBosluk + 1);
        sayisizHali = sayiliHali.replace(sayiliHali.substring(ikinciBosluk + 1, ucuncuBosluk), "");

        System.out.println(sayisizHali);

        if (sayisizHali.equals("We've got  results for teddy bear")) {
            System.out.println("odevin 3. kisimdaki yazi gozuktu");
        } else {
            System.out.println("Soru daha bitmedi");
        }

        // 2. yol daha guzel ve kisa

/*
        sayisizHali = sayiliHali.replaceAll("\\d", "");
        System.out.println(sayisizHali);
*/


        /********************************4.Kisim*******************************************/

        MyFunc.Bekle(1);


        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement clickCalculate = driver.findElement(By.id("calculate"));
        clickCalculate.click();

        WebElement numberOne = driver.findElement(By.id("number1"));
        numberOne.sendKeys("69");

        WebElement numberTwo = driver.findElement(By.id("number2"));
        numberTwo.sendKeys("2");

        WebElement calcButton = driver.findElement(By.id("calculate"));
        calcButton.click();

        WebElement calcClick = driver.findElement(By.id("answer"));
        System.out.println("calcClick.getText() = " + calcClick.getText());


        /********************************5.Kisim*******************************************/

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement clickFake = driver.findElement(By.id("fakealerttest"));
        clickFake.click();

        WebElement clickBox = driver.findElement(By.id("fakealert"));
        clickBox.click();

        WebElement clickOk = driver.findElement(By.id("dialog-ok"));
        clickOk.click();


        /********************************6.Kisim*******************************************/

        /*
                Bu siteye gidiniz.  https://testpages.herokuapp.com/styled/index.html

        Fake Alerts'e tıklayınız.

        Show modal dialog buttonuna tıklayınız.

        Ok'a tıklayınız.

        Alert kapanmalıdır.
        */

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        //clickFake.click();

        WebElement faek = driver.findElement(By.id("fakealerttest"));
        faek.click();

        WebElement showModelDialog = driver.findElement(By.className("styled-click-button"));
        showModelDialog.click();

        WebElement aletiKapa=driver.findElement(By.id("dialog-ok"));
        aletiKapa.click();
    }
}
