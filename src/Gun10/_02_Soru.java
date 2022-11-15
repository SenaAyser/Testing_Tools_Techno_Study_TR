package Gun10;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _02_Soru extends BaseDriver {
    public static void main(String[] args) {
        // bir önceki örnekse sürgüyü 200$ ve 400$ arasını gösterecek şekilde konumlandırınız


        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        WebElement solSurgu = driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));

        WebElement sagSurgu = driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));

        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.dragAndDropBy(solSurgu,-500,0).build();

        aksiyon.perform();

        aksiyon = aksiyonlar.dragAndDropBy(sagSurgu,500,0).build();

        aksiyon.perform();

        aksiyon = aksiyonlar.dragAndDropBy(solSurgu,200,0).build();

        aksiyon.perform();

        aksiyon = aksiyonlar.dragAndDropBy(sagSurgu,-99,0).build();

        aksiyon.perform();

        driverBekleKapat();
    }
}
