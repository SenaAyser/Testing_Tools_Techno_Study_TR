package Gun11;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class bizYaptik_visibiltyOf extends BaseDriver {
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
