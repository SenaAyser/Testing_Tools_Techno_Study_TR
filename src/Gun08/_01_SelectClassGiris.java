package Gun08;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _01_SelectClassGiris extends BaseDriver {

    @Test
    public void Test1(){
        driver.get("https://www.amazon.com/");

        WebElement webMenu = driver.findElement(By.id("searchDropdownBox"));

        Select ddMenu = new Select(webMenu); //select menu,DropDown menu

//        ddMenu.selectByVisibleText("Books");
//        ddMenu.selectByIndex(5);// index 0 dan başlıyor
        ddMenu.selectByValue("search-alias=stripbooks-intl-ship");
        MyFunc.Bekle(1);

        WebElement srcButton = driver.findElement(By.id("nav-search-submit-button"));
        srcButton.click();

        WebElement element = driver.findElement(By.xpath("//h2[text()='Best sellers '] "));

        Assert.assertTrue(element.getText().contains("Best sellers "));
        //assert cok da gerekli degil cunku zaten eleman bulma islemi de bir kontrol eleman bulamazsa hata verecek

        driverBekleKapat();
    }
}
