package Gun09;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _07_ActionDragAndDropTest extends BaseDriver {
    @Test
    public void Test1() {

        //HOCANIN COZUMU BITIRMEDI BIZE BIRAKTI TEST2 DE BITMIS HALI VAR
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norvec = driver.findElement(By.id("box101"));

        MyFunc.Bekle(2);
        //1.yöntem
        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar.dragAndDrop(oslo, norvec).build();
        aksiyon.perform();

        //2.Yöntem
        WebElement seul = driver.findElement(By.id("box5"));
        WebElement kore = driver.findElement(By.id("box105"));

        aksiyon = aksiyonlar.clickAndHold(seul).build();
        aksiyon.perform();  // sürüklenecek elementi mousla tuttum aldım.
        //new Actions(driver).clickAndHold(seul).build().perform();   //kısa yol


        aksiyon = aksiyonlar.moveToElement(kore).release().build();
        aksiyon.perform();  // hedef e götür(moveToElement) ve bırak(release)
        //new Actions(driver).moveToElement(kore).release().build().perform();  //kısa hali


        MyFunc.Bekle(2);
        driverBekleKapat();

    }

    @Test
    public void Test2() {
        //BENIM COZUMUM

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");


        List<WebElement> ulkeler = driver.findElements(By.cssSelector("[id='countries'] div"));

        List<WebElement> baskentler = driver.findElements(By.className("dragableBox"));

        Actions actions = new Actions(driver);

        for (WebElement baskent : baskentler) {
            if (!baskent.getText().equals("")) {
                for (WebElement ulke : ulkeler) {
                    Action action = actions.clickAndHold(baskent).build();
                    action.perform();
                    action = actions.moveToElement(ulke).release().build();
                    action.perform();
                    if (baskent.getCssValue("background").contains("rgb(0, 255, 0)")) {
                        break;
                    }
                }
            }
        }
    }
}

