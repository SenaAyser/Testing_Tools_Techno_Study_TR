package Gun08;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_Soru_Cozum2 extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://www.facebook.com/");


        MyFunc.Bekle(2);
        WebElement btnYeniHesap = driver.findElement(By.linkText("Create New Account"));
        btnYeniHesap.click();

        MyFunc.Bekle(3);
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("ismet");

        MyFunc.Bekle(3);
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("temur");

        // #fullname_field+div+div    -> WebElementi buldu, getattribute ile Class controlü yaptı
        //görünmüyor
        WebElement hiddenElement=driver.findElement(By.cssSelector("#fullname_field+div+div"));
        Assert.assertTrue("Email girmeden önce gizli durumu", hiddenElement.getAttribute("class").equals("hidden_elem"));

        MyFunc.Bekle(3);
        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys("ismet@hotmail.com");

        //görünüyor
        hiddenElement=driver.findElement(By.cssSelector("#fullname_field+div+div"));
        Assert.assertFalse("Email girdikten sonra gizli durumu", hiddenElement.getAttribute("class").equals("hidden_elem"));

        driverBekleKapat();
    }
}
