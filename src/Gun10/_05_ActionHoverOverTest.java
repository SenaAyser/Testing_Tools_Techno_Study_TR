package Gun10;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _05_ActionHoverOverTest extends BaseDriver {

/*    Jewellery -> Neckless -> Bib Neckless click
    tıklatma işleminden sonra URL de
    bib-necklaces kelimesinin geçtiğini doğrulayın.*/

    // 1- isDisplay ve isEnable gibi kontroller, element HTML nini içinde var fakat görünür değil.
    // durumunda kullanılır.
    // 2- BAZI durumlarda element HTML nini içinde hiç yoktur.
    @Test
    public void Test1() {
        driver.get("https://www.etsy.com/");

        List<WebElement> cookiesAccept = driver.findElements(By.cssSelector("[data-gdpr-single-choice-accept='true']"));

        //elementi bulamazsa implicitly wait devreye girer ve verilen sure kadar bulmaya calisir

        if (cookiesAccept.size()>0)//varsa
            cookiesAccept.get(0).click(); //kapat

        WebElement mucevher = driver.findElement(By.id("catnav-primary-link-10855"));
        WebElement kolye = driver.findElement(By.id("side-nav-category-link-10873"));
        WebElement bibKolye = driver.findElement(By.id("catnav-l3-10881"));

        Actions aksiyonlar = new Actions(driver);

        aksiyonlar.moveToElement(mucevher).build().perform();
        MyFunc.Bekle(1);

        aksiyonlar.moveToElement(kolye).build().perform();
        MyFunc.Bekle(1);

        aksiyonlar.moveToElement(bibKolye).build().perform();
        MyFunc.Bekle(1);

        bibKolye.click();
    }
    @Test
    public void TestBenimki(){

        //BEN YAPTIM

        driver.get("https://www.etsy.com/");

        WebElement mucevher = driver.findElement(By.id("catnav-primary-link-10855"));
        WebElement kolye = driver.findElement(By.id("side-nav-category-link-10873"));
        WebElement bibKolye = driver.findElement(By.id("catnav-l3-10881"));

        Actions actions = new Actions(driver);

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOf(mucevher));
        actions.moveToElement(mucevher).build().perform();

        bekle.until(ExpectedConditions.visibilityOf(kolye));
        actions.moveToElement(kolye).build().perform();

        bekle.until(ExpectedConditions.visibilityOf(bibKolye));
        actions.moveToElement(bibKolye).click().build().perform();
    }
}
