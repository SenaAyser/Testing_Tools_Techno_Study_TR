package Gun06.Gunun_Sorusu;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Cozum_2 extends BaseDriver {

    @Test
    public void test1(){
        driver.get("https://formsmarts.com/form/yu?mode=h5");

        WebElement business=driver.findElement(By.cssSelector("[type='radio'][value='Business']"));
        business.click();

        WebElement dropDownDiscover=driver.findElement(By.cssSelector("select[id$='_4588']"));
        dropDownDiscover.click();

        WebElement optionOnlineAdvertising=driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        optionOnlineAdvertising.click();

        WebElement buttonEveryDay=driver.findElement(By.cssSelector("[type='radio'][value='Every Day']"));
        buttonEveryDay.click();

        WebElement goodRadio=driver.findElement(By.cssSelector("[type='radio'][value='Good']"));
        goodRadio.click();

        WebElement howLongDropdown=driver.findElement(By.cssSelector("select[id$='_4597']"));
        howLongDropdown.click();

        WebElement secenek4=driver.findElement(By.cssSelector("select[id$='_4597'] > :nth-child(4)"));
        secenek4.click();

        goodRadio.click(); // sadece son açılan dropdown kapansın diye herhangi bir yere tıklattık


    }
}
