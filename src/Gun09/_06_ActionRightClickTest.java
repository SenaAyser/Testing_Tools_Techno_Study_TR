package Gun09;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class _06_ActionRightClickTest extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://demoqa.com/buttons");

        WebElement element = driver.findElement(By.id("rightClickBtn"));
        MyFunc.Bekle(2);

        Actions aksiyonlar=new Actions(driver); // sınıf oluşturma
        Action aksiyon= aksiyonlar.moveToElement(element).contextClick().build();
        aksiyon.perform();

        MyFunc.Bekle(2);

        //new Actions(driver).contextClick(element).build().perform();
        driverBekleKapat();
    }
}