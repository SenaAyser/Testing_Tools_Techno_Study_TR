package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _05_FindingByLinkText {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();   // web sayfasını kontrol eden görevli   // web sayfasını kontrol eden görevli
        driver.get("https://www.hepsiburada.com/"); // web sayfasını aç

        WebElement link= driver.findElement(By.linkText("Siparişlerim")); // linkin ekranda görünen text i yazılır
        // sadace a TAG leri için özel Locator bulma yöntemi

        System.out.println("link.getText() = " + link.getText());

        System.out.println("link.getAttribute(href) = " + link.getAttribute("href"));
        System.out.println("link.getAttribute(title) = " + link.getAttribute("title"));
        System.out.println("link.getAttribute(rel) = " + link.getAttribute("rel"));


        WebElement link2 = driver.findElement(By.partialLinkText("Süper Fiyat")); // ===> Normalde "Süper Fiyat, Süper Teklif" olmasi gerek ama partial yazarak birazini alsak da oluyor // Linkin gorunen textinin bir kismi ile bulma
        // sadece "a" TAG leri icin ozel Locator bulma yontemi
        System.out.println("link2.getText() = " + link2.getText());


        MyFunc.Bekle(10);
        driver.quit();
    }

}
