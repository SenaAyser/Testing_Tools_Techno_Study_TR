package Gun11;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_WaitSoru extends BaseDriver {

    /*
Senaryo
1-  https://www.demoblaze.com/index.html  siteyi açınız.
2- Samsung galaxy s6  linkine tıklayınız.
3- Sepete ekleyiniz.
4- Daha Sonra PRODUCT STORE yazısına tıklatarak ana ekrana geri dönününz
 */
    @Test
    public void Test1(){
        driver.get("https://www.demoblaze.com/index.html");

        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6")));

        WebElement btn = driver.findElement(By.linkText("Samsung galaxy s6"));
        btn.click();

        WebDriverWait w2 = new WebDriverWait(driver,Duration.ofSeconds(30));
        w2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));

        WebElement sepeteEkle = driver.findElement(By.linkText("Add to cart"));
        sepeteEkle.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        WebElement anasayfa = driver.findElement(By.id("nava"));
        anasayfa.click();
    }
}
