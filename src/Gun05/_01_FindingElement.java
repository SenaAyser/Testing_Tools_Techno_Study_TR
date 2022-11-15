package Gun05;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class _01_FindingElement {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(opt);

        driver.get("https://www.hepsiburada.com/"); // web sayfasını aç

        List<WebElement> linkler = driver.findElements(By.tagName("a"));   // tag ini gore bulma
        // bu bana sayfadaki tum linkleri verir


        for(WebElement e : linkler){
            if (e.getText().equals("")) // kirik link yani ekranda gozuken kismi yok
            {
                System.out.println("e.getAttribute(\"href\") = " + e.getAttribute("href"));
                System.out.println("e.getAttribute(\"title\") = " + e.getAttribute("title"));
                System.out.println("e.getAttribute(\"rel\") = " + e.getAttribute("rel"));
            }
        }

        MyFunc.Bekle(10);
        driver.quit();
    }
}
