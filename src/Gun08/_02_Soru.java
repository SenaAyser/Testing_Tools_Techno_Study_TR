package Gun08;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class _02_Soru extends BaseDriver {
//        Test Senaryosu
//        1- https://www.facebook.com/  sayfasına gidiniz
//        2- CreateNewAccount a tıklatınız.
//        3- Açılan yeni pencerede isim, soyisim ve emaili giriniz.
//        4- Doğum tarihinizi Select sınıfı ile seçiniz
//        5- Email i tekrar girmenizi isteyen bir input daha açıldığını
//        öncesinde de görünmediğini assert ile doğrulayınız.
    @Test
    public void Test(){
        driver.get("https://www.facebook.com/");
        driver.manage().deleteAllCookies();  // girildikten sonrada cookies ler silindi

        WebElement btnYeniHesap=driver.findElement(By.linkText("Create New Account"));
        btnYeniHesap.click();

        MyFunc.Bekle(2);
        WebElement firstname=driver.findElement(By.name("firstname"));
        firstname.sendKeys("ismet");

        MyFunc.Bekle(2);
        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("temur");

        //1.Yöntem  // [id='reg_form_box'] > [class='hidden_elem'] -> direct WebElement arandı, class özelliği ile
        // Görünmediğinin kontrol edilecek yer
        List<WebElement> secondEmail=driver.findElements(By.cssSelector("[id='reg_form_box'] > [class='hidden_elem']"));
        Assert.assertTrue("2.Email su an gözüküyor mu",(secondEmail.size()==1));

        MyFunc.Bekle(1);
        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys("ismet@hotmail.com");

        // Göründüğününü kontorl eidleceği yer
        secondEmail=driver.findElements(By.cssSelector("[id='reg_form_box'] > [class='hidden_elem']"));
        Assert.assertTrue("2.Email su an gözüküyor mu",(secondEmail.size()==0));

        WebElement email2=driver.findElement(By.name("reg_email_confirmation__")); // 2.email girdik
        email2.sendKeys("ismet@hotmail.com");

        MyFunc.Bekle(2);
        WebElement day = driver.findElement(By.id("day"));
        Select dropDownDay = new Select(day);
        dropDownDay.selectByValue("4");

        MyFunc.Bekle(3);
        WebElement month = driver.findElement(By.id("month"));
        Select drpDownMonth = new Select(month);
        drpDownMonth.selectByValue("10");

        MyFunc.Bekle(3);
        WebElement year = driver.findElement(By.id("year"));
        Select dropDownYear = new Select(year);
        dropDownYear.selectByValue("2000");

        MyFunc.Bekle(3);
        WebElement sex = driver.findElement(By.cssSelector("input[value='2'][name='sex']"));

        // #fullname_field+div+div    -> WebElementi buldu, getattribute ile Class controlü yaptı

        //menu.selectByValue("23");

        sex.click();
    }
}
